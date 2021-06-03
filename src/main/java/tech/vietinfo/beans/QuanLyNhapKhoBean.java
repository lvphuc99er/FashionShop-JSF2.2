package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import tech.vietinfo.entities.Item;
import tech.vietinfo.models.*;
import tech.vietinfo.services.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    @Inject
    private MauSacService mauSacService;

    @Inject
    private KichCoService kichCoService;

    private List<Item> itemList = new ArrayList<>();
    private List<PhieuNhap> phieuNhapList = new ArrayList<>();
    private List<MauSac> mauSacList = new ArrayList<>();
    private List<KichCo> kichCoList = new ArrayList<>();
    private List<ChiTietPhieuNhap> chiTietPhieuNhapList = new ArrayList<>();

    private ChiTietPhieuNhap chiTietPhieuNhap;
    private NhaCungCap selectedNhaCungCap;
    private SanPham selectedSanPham;
    private KichCo kichCo;
    private MauSac mauSac;
    private PhieuNhap phieuNhap;
    private Item item;
    private int sl;
    private int maNCC;

    @Min(value = 1, message = "Chọn sản phẩm")
    private int maSP;

    @Min(value = 1, message = "Chọn kích cỡ")
    private int maKC;

    @Min(value = 1, message = "Chọn màu sắc")
    private int maM;

    @PostConstruct
    public void init() {
        phieuNhap = new PhieuNhap();
        selectedSanPham = new SanPham();
    }

    public List<PhieuNhap> getPhieuNhaps() {
        phieuNhapList = quanLyNhapKhoService.getPhieuNhaps();
        return phieuNhapList;
    }

    public List<ChiTietPhieuNhap> getChiTietPhieuNhaps(int ma) {
        chiTietPhieuNhapList = quanLyNhapKhoService.getChiTietPhieuNhaps(ma);
        return chiTietPhieuNhapList;
    }

    public String addPhieuNhap() {
        if (checkSoLuongNhap()) {
            selectedNhaCungCap = nhaCungCapService.find(maNCC);
            phieuNhap.setNhaCungCap(selectedNhaCungCap);
            phieuNhap.setThanhTien(total());
            quanLyNhapKhoService.addPhieuNhap(phieuNhap);

            for (Item it : itemList) {
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();

                ct.setTenNoiSanXuat(it.getSanPham().getTenNoiSanXuat());
                ct.setTenSanPham(it.getSanPham().getTenSanPham());
                ct.setDonGia(it.getSanPham().getDonGia());
                ct.setSoLuongNhap(it.getQuantity());
                ct.setPhieuNhap(phieuNhap);
                ct.setMaSanPham(it.getSanPham().getMaSanPham());
                ct.setThanhTien(it.getQuantity() * it.getSanPham().getDonGia());

                selectedSanPham = sanPhamService.find(it.getSanPham().getMaSanPham());
                int sl = selectedSanPham.getSoLuongCoSan();
                selectedSanPham.setSoLuongCoSan(sl + it.getQuantity());
                sanPhamService.updateSanPham(selectedSanPham);

                quanLyNhapKhoService.addChiTietPhieuNhap(ct);
            }
            return "quan-ly-nhap-kho?faces-redirect=true";
        } else {
            return "";
        }
    }

    public boolean checkSoLuongNhap() {
        if (itemList.size() == 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Thông báo", "Chưa có " +
                    "sản phẩm nào để nhập");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return false;
        }
        return true;
    }

    public List<Item> getItems() {
        selectedSanPham = sanPhamService.find(maSP);
        kichCo = new KichCo();
        mauSac = new MauSac();
        kichCo = kichCoService.find(maKC);
        mauSac = mauSacService.find(maM);
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

    public String deleteKhoiPhieuNhap(SanPham sanPham) {
        int index = exists(sanPham);
        itemList.remove(index);
        return "";
    }

    //    xóa phiếu nhập - chi tiết phiếu nhập, cập nhật số lượng sau khi xóa phiếu nhập
    public String deletePhieuNhap() {
        chiTietPhieuNhapList = quanLyNhapKhoService.getChiTietPhieuNhaps(phieuNhap.getMaPhieuNhap());
        for (ChiTietPhieuNhap ct : chiTietPhieuNhapList) {
            selectedSanPham = sanPhamService.find(ct.getMaSanPham());
            int sl = selectedSanPham.getSoLuongCoSan();
            selectedSanPham.setSoLuongCoSan(sl - ct.getSoLuongNhap());
            sanPhamService.updateSanPham(selectedSanPham);
        }
        quanLyNhapKhoService.deletePhieuNhap(phieuNhap);
        quanLyNhapKhoService.deleteChiTietPhieuNhap(phieuNhap.getMaPhieuNhap());
        return "";
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
}
