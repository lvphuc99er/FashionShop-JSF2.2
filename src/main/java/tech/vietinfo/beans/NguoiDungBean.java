package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import tech.vietinfo.models.GioHang;
import tech.vietinfo.models.KhachHang;
import tech.vietinfo.models.NhanVien;
import tech.vietinfo.services.GioHangService;
import tech.vietinfo.services.KhachHangService;
import tech.vietinfo.services.NhanVienService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("nguoiDungBean")
@ViewScoped
@Getter
@Setter
public class NguoiDungBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private KhachHangService khachHangService;
    private List<KhachHang> khachHangList = new ArrayList<>();
    private KhachHang khachHang;

    @Inject
    private GioHangService gioHangService;
    private GioHang gioHang;

    @Inject
    private NhanVienService nhanVienService;
    private List<NhanVien> nhanVienList = new ArrayList<>();
    private NhanVien nhanVien;
    private int ma;

    @PostConstruct
    public void init() {
        khachHang = new KhachHang();
        gioHang = new GioHang();
        nhanVien = new NhanVien();
    }

    public List<KhachHang> getKhachHangs() {
        khachHangList = khachHangService.getKhachHangs();
        return khachHangList;
    }

    public List<NhanVien> getNhanViens() {
        nhanVienList = nhanVienService.getNhanViens();
        return nhanVienList;
    }

    public String addKhachHang() {
        if (checkSoDienThoaiKhachHang(khachHang)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Thông báo", "Số điện " +
                    "thoại này đã được đăng ký, vui lòng nhập số điện thoại chưa đăng ký.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "register";
        } else {
            khachHangService.addKhachHang(khachHang);
            gioHang.setKhachHang(khachHang);
            gioHangService.addGioHang(gioHang);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thông báo", "Đã đăng ký " +
                    "thành công! Đăng nhập ngay để bắt đầu mua sắm.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "login?faces-redirect=true";
        }
    }

    public boolean checkSoDienThoaiKhachHang(KhachHang kh) {
        khachHangList = khachHangService.getKhachHangs();
        for (KhachHang k : khachHangList) {
            if (kh.getSoDienThoai().equals(k.getSoDienThoai())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSoDienThoaiNhanVien(NhanVien nv) {
        for (NhanVien k : nhanVienList) {
            if (nv.getSoDienThoai().equals(k.getSoDienThoai())) {
                return false;
            }
        }
        return true;
    }

    public String lockKhachHang(KhachHang kh, String st) {
        khachHang = khachHangService.find(kh.getMaKhachHang());
        khachHang.setTrangThai(st);
        khachHangService.updateKhachHang(khachHang);
        return "";
    }

    public String saveNhanVien() {
        if (nhanVien.getMaNhanVien() == 0) {
//            if (checkSoDienThoaiNhanVien(nhanVien)) {
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Thông báo", "Số điện " +
//                        "thoại này đã có.");
//                PrimeFaces.current().dialog().showMessageDynamic(message);
//            } else {
                nhanVienService.addNhanVien(nhanVien);
//            }
        } else {
            nhanVienService.updateNhanVien(nhanVien);
        }
        return "";
    }

    public String deleteNhanVien() {
        nhanVienService.deleteNhanVien(nhanVien);
        return "";
    }
}