package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.entities.Item;
import tech.vietinfo.models.ChiTietPhieuNhap;
import tech.vietinfo.models.NhaCungCap;
import tech.vietinfo.models.PhieuNhap;
import tech.vietinfo.models.SanPham;
import tech.vietinfo.services.NhaCungCapService;
import tech.vietinfo.services.QuanLyNhapKhoService;
import tech.vietinfo.services.SanPhamService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("quanLyNhapKhoBean")
@ViewScoped
@Getter
@Setter
public class QuanLyNhapKhoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private QuanLyNhapKhoService quanLyNhapKhoService;

    @Inject
    private SanPhamService sanPhamService;

    @Inject
    private NhaCungCapService nhaCungCapService;

    private List<PhieuNhap> phieuNhapList = new ArrayList<>();
    private PhieuNhap phieuNhap;
    private PhieuNhap selectedPhieuNhap;

    private List<ChiTietPhieuNhap> chiTietPhieuNhapList = new ArrayList<>();
    private ChiTietPhieuNhap chiTietPhieuNhap;

    private int sl;
    private int ma_sp;
    private int ma_ncc;
    private SanPham selectedSanPham;
    private NhaCungCap selectedNhaCungCap;

    private List<Item> itemList = new ArrayList<>();
    private Item item;

    @PostConstruct
    public void init() {
        phieuNhap = new PhieuNhap();
    }

    public List<PhieuNhap> getPhieuNhaps() {
        phieuNhapList = quanLyNhapKhoService.getPhieuNhaps();
        return phieuNhapList;
    }

    public List<ChiTietPhieuNhap> getChiTietPhieuNhaps(int ma) {
        chiTietPhieuNhapList = quanLyNhapKhoService.getChiTietPhieuNhaps(ma);
        return chiTietPhieuNhapList;
    }

    //    thêm mới phiếu nhập - chi tiết sản phẩm, cập nhật số lượng sau khi nhập của sản phẩm
    public String addPhieuNhap() {
        selectedNhaCungCap = nhaCungCapService.find(ma_ncc);
        phieuNhap.setNhaCungCap(selectedNhaCungCap);
        phieuNhap.setThanhTien_PN(total());
        quanLyNhapKhoService.addPhieuNhap(phieuNhap);

        for (Item it : itemList) {
            ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
            ct.setSanPham(it.getSanPham());
            ct.setSoLuongNhap(it.getQuantity());
            ct.setPhieuNhap(phieuNhap);
            ct.setThanhTien_SP(it.getQuantity() * it.getSanPham().getDonGia());
            quanLyNhapKhoService.addChiTietPhieuNhap(ct);

            selectedSanPham = sanPhamService.find(it.getSanPham().getMaSanPham());
            int sl = selectedSanPham.getSoLuongCoSan();
            selectedSanPham.setSoLuongCoSan(sl + it.getQuantity());
            sanPhamService.updateSanPham(selectedSanPham);
        }
        return "pmn_warehouse?faces-redirect=true";
    }

    public List<Item> getItems() {
        selectedSanPham = sanPhamService.find(ma_sp);
        int i = exists(selectedSanPham);
        if (i == -1) {
            item = new Item(selectedSanPham, sl);
            itemList.add(item);
        } else {
            int quantity = itemList.get(i).getQuantity() + sl;
            itemList.get(i).setQuantity(quantity);
        }
        return itemList;
    }

    public String delete(SanPham sanPham) {
        int index = exists(sanPham);
        itemList.remove(index);
        return "pmn_warehouse_create";
    }

    //    xóa phiếu nhập - chi tiết phiếu nhập, cập nhật số lượng sau khi xóa phiếu nhập
    public String deletePhieuNhap(PhieuNhap p) {
        chiTietPhieuNhapList = quanLyNhapKhoService.getChiTietPhieuNhaps(p.getMaPhieuNhap());
        for (ChiTietPhieuNhap ct: chiTietPhieuNhapList) {
            selectedSanPham = sanPhamService.find(ct.getSanPham().getMaSanPham());
            int sl = selectedSanPham.getSoLuongCoSan();
            selectedSanPham.setSoLuongCoSan(sl - ct.getSoLuongNhap());
            sanPhamService.updateSanPham(selectedSanPham);
        }
        quanLyNhapKhoService.deletePhieuNhap(p);
        quanLyNhapKhoService.deleteChiTietPhieuNhap(p.getMaPhieuNhap());
        return "pmn_warehouse?faces-redirect=true";
    }

    public double total() {
        double s = 0;
        for (Item item : itemList) {
            s += item.getSanPham().getDonGia() * item.getQuantity();
        }
        return s;
    }

    public int exists(SanPham sanPham) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getSanPham().getMaSanPham() == sanPham.getMaSanPham()) {
                return i;
            }
        }
        return -1;
    }

    public String nextPageCreate() {
        return "pmn_warehouse_create?faces-redirect=true";
    }
}
