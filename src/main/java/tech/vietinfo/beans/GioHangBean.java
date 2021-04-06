package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.models.*;
import tech.vietinfo.services.GioHangService;
import tech.vietinfo.services.SanPhamService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Named("cartBean")
@ViewScoped
@Getter
@Setter
public class GioHangBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private final double SHIPCOST = 30000;

    @Inject
    private SanPhamService sanPhamService;
    private SanPham sanPham;

    @Inject
    private GioHangService gioHangService;
    private GioHang gioHang;
    private ChiTietGioHang chiTietGioHang;
    private List<ChiTietGioHang> chiTietGioHangList = new ArrayList<>();
    private List<DonHang> donHangList = new ArrayList<>();
    private DonHang donHang;
    private List<ChiTietDonHang> chiTietDonHangList = new ArrayList<>();
    private ChiTietDonHang chiTietDonHang;

    private LocalDate ngayDatHang = LocalDate.now();

    @PostConstruct
    public void init() {
        donHang = new DonHang();
        chiTietGioHang = new ChiTietGioHang();
        chiTietDonHang = new ChiTietDonHang();
    }

    public List<ChiTietGioHang> getChiTietGioHangs(int makh) {
        gioHang = gioHangService.getGioHangs(makh).get(0);
        chiTietGioHangList = gioHang.getChiTietGioHangList();
        return chiTietGioHangList;
    }

    public String addSanPhamVaoGioHang(int masp, int makh) {
        if (!checkTrungSanPham(masp, makh)) {
            chiTietGioHang.setSanPham(sanPham);
            chiTietGioHangList.add(chiTietGioHang);

            gioHang.setChiTietGioHangList(chiTietGioHangList);
            chiTietGioHang.setSoLuong(1);
            chiTietGioHang.setGioHang(gioHang);
            chiTietGioHang.setThanhTien(sanPham.getDonGia());

            gioHangService.addChiTietGioHang(chiTietGioHang);
        } else {
            for (ChiTietGioHang ct : chiTietGioHangList) {
                if (ct.getSanPham().getMaSanPham() == sanPham.getMaSanPham()) {
                    ct.setSoLuong(ct.getSoLuong() + 1);
                    ct.setThanhTien(ct.getThanhTien() + ct.getSanPham().getDonGia());
                    gioHangService.updateChiTietGioHang(ct);
                }
            }
        }
        sanPham.setSoLuongCoSan(sanPham.getSoLuongCoSan() - 1);
        sanPhamService.updateSanPham(sanPham);
        gioHangService.updateGioHang(gioHang);
        return "shoppingcart?faces-redirect=true";
    }

    public String deleteSanPhamKhoiGioHang(ChiTietGioHang ct) {
        sanPham = sanPhamService.find(ct.getSanPham().getMaSanPham());
        int sl = sanPham.getSoLuongCoSan();
        sanPham.setSoLuongCoSan(sl + ct.getSoLuong());
        sanPhamService.updateSanPham(sanPham);
        gioHangService.deleteChiTietGioHang(ct);
        return "shoppingcart?faces-redirect=true";
    }

    public boolean checkTrungSanPham(int masp, int makh) {
        sanPham = sanPhamService.find(masp);
        gioHang = gioHangService.getGioHangs(makh).get(0);
        chiTietGioHangList = gioHang.getChiTietGioHangList();
        for (ChiTietGioHang ct : chiTietGioHangList) {
            if (ct.getSanPham().getMaSanPham() == sanPham.getMaSanPham()) {
                return true;
            }
        }
        return false;
    }

    public double totalSanPham() {
        double s = 0;
        for (ChiTietGioHang ct : chiTietGioHangList) {
            s += ct.getThanhTien();
        }
        return s;
    }

    public double totalDonHang() {
        return totalSanPham() + SHIPCOST;
    }

    public String addDonHang(KhachHang kh) {
        donHang.setKhachHang(kh);
        donHang.setNgayDatHang(ngayDatHang.toString());
        donHang.setNgayNhanHang(ngayDatHang.plusDays(3).toString());
        donHang.setDonViVanChuyen("Nhân viên LIVE LOUNGE");
        donHang.setTrangThai("Chờ xác nhận");
        donHang.setThanhTien(totalDonHang());
        gioHangService.addDonHang(donHang);
        for (ChiTietGioHang ct : chiTietGioHangList) {
            chiTietDonHang.setDonHang(donHang);
            chiTietDonHang.setThanhTien(ct.getThanhTien());
            chiTietDonHang.setSanPham(ct.getSanPham());
            chiTietDonHang.setSoLuong(ct.getSoLuong());
            gioHangService.addChiTietDonHang(chiTietDonHang);
        }
        return "shoppingcart?faces-redirect=true";
    }

    public List<DonHang> getDonHangs() {
        donHangList = gioHangService.getDonHangs();
        return donHangList;
    }

    public List<DonHang> getDonHangsByKhachHang(int makh){
        return gioHangService.getDonHangsByKhachHang(makh);
    }

    public List<ChiTietDonHang> getChiTietDonHangs(int madh) {
        chiTietDonHangList = gioHangService.getChiTietDonHangs(madh);
        return chiTietDonHangList;
    }

    public String huyDonHang(DonHang dh){

        return "";
    }

    public String dangGiaoHang(DonHang donHang){
        donHang.setTrangThai("Đang giao hàng");
        gioHangService.updateDonHang(donHang);
        return "listorder?faces-redirect=true";
    }

    public String daGiaoHang(DonHang donHang){
        donHang.setTrangThai("Đã giao hàng");
        gioHangService.updateDonHang(donHang);
        return "listorder?faces-redirect=true";
    }
}
