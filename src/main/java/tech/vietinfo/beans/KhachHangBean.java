package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.models.GioHang;
import tech.vietinfo.models.KhachHang;
import tech.vietinfo.services.GioHangService;
import tech.vietinfo.services.KhachHangService;

import javax.annotation.PostConstruct;
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
        khachHangService.addKhachHang(khachHang);
        gioHang.setKhachHang(khachHang);
        gioHangService.addGioHang(gioHang);
        return "";
    }

    public String lockKhachHang(KhachHang kh, String st) {
        selectedKhachHang = khachHangService.find(kh.getMaKhachHang());
        selectedKhachHang.setTrangThai(st);
        khachHangService.updateKhachHang(selectedKhachHang);
        return "umn_listuser?faces-redirect=true";
    }
}
