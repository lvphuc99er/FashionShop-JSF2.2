package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.models.SanPham;
import tech.vietinfo.services.SanPhamService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("homeBean")
@SessionScoped
@Getter
@Setter
public class HomeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SanPhamService sanPhamService;
    private List<SanPham> sanPhamList = new ArrayList<>();
    private int ma;

    public String setMa(int ma) {
        this.ma = ma;
        return "sanpham-danh-sach?faces-redirect=true";
    }

    public List<SanPham> getSanPhams() {
        if (ma == 4) {
            sanPhamList = sanPhamService.getSanPhams();
        }
        if (ma == 1) {
            sanPhamList = sanPhamService.getSanPhamsByDanhMuc(1);
        }
        if (ma == 2) {
            sanPhamList = sanPhamService.getSanPhamsByDanhMuc(2);
        }
        if (ma == 3) {
            sanPhamList = sanPhamService.getSanPhamsByDanhMuc(3);
        }
        return sanPhamList;
    }


}
