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
    private int maAdminPage;
    private int maHeader;
    private int dieuHuong;
    private String tuKhoa;
    private String tuTimKiem;
    private int maGia;
    private int maDonHang;
    private int maMau;

    public String setMaAdminPage(int ma) {
        this.maAdminPage = ma;
        return "";
    }

    public String setTu(){
        setTuTimKiem(tuKhoa);
        setTuKhoa("");
        return "";
    }
}
