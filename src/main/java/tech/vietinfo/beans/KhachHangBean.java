package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.models.KhachHang;
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

    @PostConstruct
    public void init() {
        khachHang = new KhachHang();
    }

    public List<KhachHang> getKhachHangs() {
        khachHangList = khachHangService.getKhachHangs();
        return khachHangList;
    }

    public String addKhachHang() {
        khachHangService.addKhachHang(khachHang);
        return "";
    }

    public String lockKhachHang(KhachHang kh, String st) {
        selectedKhachHang = khachHangService.find(kh.getMaKhachHang());
        selectedKhachHang.setTrangThai(st);
        khachHangService.updateKhachHang(selectedKhachHang);
        return "umn_listuser?faces-redirect=true";
    }

    public int checkTrangThai(KhachHang kh){
        if(kh.getTrangThai().equals("KHÓA")){
            return 0;
        }
        return 1;
    }
//    private String strKhoa = "LƯỢNG";
}
