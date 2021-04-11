package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import tech.vietinfo.models.GioHang;
import tech.vietinfo.models.KhachHang;
import tech.vietinfo.services.GioHangService;
import tech.vietinfo.services.KhachHangService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("khachHangBean")
@ViewScoped
@Getter
@Setter
public class KhachHangBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private KhachHangService khachHangService;

    private List<KhachHang> khachHangList = new ArrayList<>();
    private KhachHang khachHang;
    private KhachHang selectedKhachHang;

    @Inject
    private GioHangService gioHangService;
    private GioHang gioHang;

    @PostConstruct
    public void init() {
        khachHang = new KhachHang();
        gioHang = new GioHang();
    }

    public List<KhachHang> getKhachHangs() {
        khachHangList = khachHangService.getKhachHangs();
        return khachHangList;
    }

    public String addKhachHang() {
        if (checkTrungSDT(khachHang)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Thông báo", "Số điện " +
                    "thoại này đã được đăng ký, vui lòng nhập số điện thoại chưa đăng ký.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "register";
        }else{
            khachHangService.addKhachHang(khachHang);
            gioHang.setKhachHang(khachHang);
            gioHangService.addGioHang(gioHang);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thông báo", "Đã đăng ký " +
                    "thành công! Đăng nhập ngay để bắt đầu mua sắm.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return "login?faces-redirect=true";
        }
    }

    public boolean checkTrungSDT(KhachHang kh) {
        for (KhachHang k : khachHangList) {
            if (kh.getSoDienThoai().equals(k.getSoDienThoai())) {
                return false;
            }
        }
        return true;
    }

    public String lockKhachHang(KhachHang kh, String st) {
        selectedKhachHang = khachHangService.find(kh.getMaKhachHang());
        selectedKhachHang.setTrangThai(st);
        khachHangService.updateKhachHang(selectedKhachHang);
        return "umn_listuser?faces-redirect=true";
    }
}
