package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;

import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import tech.vietinfo.models.DanhMuc;
import tech.vietinfo.models.SanPham;
import tech.vietinfo.services.DanhMucService;
import tech.vietinfo.services.SanPhamService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private SanPham selectedSanPham;

    private List<DanhMuc> danhMucList = new ArrayList<>();
    private DanhMuc danhMuc;
    private int iddm;


    private UploadedFile resume;
    private static final String FILE_PATH = "T:\\IUH\\4_Senior\\Semester 2" +
            "\\TTDN\\MyProject_Vietinfo\\Project\\WebsiteOnline\\src\\main\\webapp\\images\\";

    @PostConstruct
    public void init() {
        sanPham = new SanPham();
    }

    public void initDetail(int id) {
        sanPham = sanPhamService.find(id);
    }

    public List<DanhMuc> getDanhMucs() {
        danhMucList = danhMucService.getDanhMucs();
        return danhMucList;
    }

    public List<SanPham> getSanPhams() {
        sanPhamList = sanPhamService.getSanPhams();
        return sanPhamList;
    }

    public String addSanPham() {
        danhMuc = danhMucService.find(iddm);
        sanPham.setDanhMuc(danhMuc);
        sanPham.setHinhAnh(resume.getFileName());
        sanPhamService.addSanPham(sanPham);
        return "pmn_listproduct?faces-redirect=true";
    }

    public String deleteSanPham(SanPham sp) {
        sanPhamService.deleteSanPham(sp);
        return "pmn_listproduct?faces-redirect=true";
    }

    public String updateSanPham() {
        sanPhamService.updateSanPham(selectedSanPham);
        return "pmn_listproduct?faces-redirect=true";
    }

    public int demSoLuongSanPham(){
        return sanPhamService.getSanPhams().size();
    }
    public int demSoLuongThoiTrangNam(){
        return sanPhamService.getSanPhamsByDanhMuc(1).size();
    }
    public int demSoLuongThoiTrangNu(){
        return sanPhamService.getSanPhamsByDanhMuc(2).size();
    }
    public int demSoLuongPhuKien(){
        return sanPhamService.getSanPhamsByDanhMuc(3).size();
    }

    public String nextPageCreate() {
        return "pmn_listproduct_create?faces-redirect=true";
    }

    public String nextPageDetail() {
        return "pmn_listproduct_detail?faces-redirect=true&includeViewParams=true";
    }


    //    upload hình ảnh folder images của project
    public String uploadResume() throws IOException {

        UploadedFile uploadedPhoto = getResume();
        byte[] bytes = null;
        if (null != uploadedPhoto) {
            bytes = uploadedPhoto.getContent();
            String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(FILE_PATH + filename)));
            stream.write(bytes);
            stream.close();
        }
        return "";
    }
}