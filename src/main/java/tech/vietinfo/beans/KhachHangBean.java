package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.models.KhachHang;
import tech.vietinfo.models.NhaCungCap;
import tech.vietinfo.services.KhachHangService;
import tech.vietinfo.services.NhaCungCapService;

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

    public List<KhachHang> getKhachHangs() {
        khachHangList = khachHangService.getKhachHangs();
        return khachHangList;
    }

    @PostConstruct
    public void init(){
        khachHang = new KhachHang();
    }

    public String add_KH(){
        khachHangService.add_KH(khachHang);
        return "home?faces-redirect=true";
    }
}
