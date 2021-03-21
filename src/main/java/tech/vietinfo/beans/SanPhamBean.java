package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.InjectService;
import tech.vietinfo.models.DanhMuc;
import tech.vietinfo.models.SanPham;
import tech.vietinfo.services.DanhMucService;
import tech.vietinfo.services.SanPhamService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Named("sanPhamBean")
@ViewScoped
@Getter
@Setter
public class SanPhamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SanPhamService sanPhamService;

    @Inject
    private DanhMucService danhMucService;

    private List<SanPham> sanPhamList = new ArrayList<>();
    private SanPham sanPham;

    private List<DanhMuc> danhMucList = new ArrayList<>();
    private DanhMuc danhMuc;
    private int iddm;

    @PostConstruct
    public void init() {
        sanPham = new SanPham();
    }

    public void init_update(int id) {
        sanPham = sanPhamService.find(id);
    }

//    lay danh sach san pham
    public List<SanPham> getSanPhams() {
        sanPhamList = sanPhamService.getSanPhams();
        return sanPhamList;
    }

//    lay danh sach danh muc
    public List<DanhMuc> getDanhMucs() {
        danhMucList = danhMucService.getDanhMucs();
        return danhMucList;
    }

//    them 1 san pham
    public String add_SP() {
        danhMuc = danhMucService.find(iddm);
        sanPham.setDanhMuc(danhMuc);
        sanPhamService.add_SP(sanPham);
        return "pmn_listproduct?faces-redirect=true";
    }

//    xoa 1 san pham
    public String delete_SP(SanPham sp) {
        sanPhamService.delete_SP(sp);
        return "pmn_listproduct?faces-redirect=true";
    }

//    cap nhat 1 san pham
    public String update_SP() {
        sanPhamService.update_SP(sanPham);
        return "pmn_listproduct?faces-redirect=true";
    }

//    chuyen trang
    public String nextPageUdate() {
        return "pmn_listproduct_update?faces-redirect=true&includeViewParams=true";
    }
    public String nextPageCreate() {
        return "pmn_listproduct_create?faces-redirect=true";
    }

}