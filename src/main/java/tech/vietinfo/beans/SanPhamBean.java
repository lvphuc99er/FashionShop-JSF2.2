package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;

import lombok.SneakyThrows;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;
import org.primefaces.shaded.commons.io.FilenameUtils;
import tech.vietinfo.models.*;
import tech.vietinfo.services.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Named("sanPhamBean")
@ViewScoped
@Getter
@Setter
public class SanPhamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SanPhamService sanPhamService;

    @Inject
    private MauSacService mauSacService;

    @Inject
    private KichCoService kichCoService;

    @Inject
    private NoiSanXuatService noiSanXuatService;

    @Inject
    private KhachHangService khachHangService;

    private List<SanPham> sanPhamList = new ArrayList<>();
    private List<HinhAnh> hinhAnhList = new ArrayList<>();
    private List<HinhAnh> hinhAnhList2 = new ArrayList<>();
    private List<MauSac> mauSacList = new ArrayList<>();
    private List<KichCo> kichCoList = new ArrayList<>();
    private List<DanhGia> danhGiaList = new ArrayList<>();
    private List<SanPham> selectedSanPhamList = new ArrayList<>();
    private List<SanPham> selectedSanPhamListTheoGia = new ArrayList<>();
    private List<SanPham> selectedSanPhamListTheoMau = new ArrayList<>();
    private List<String> kichCoAoList = new ArrayList<>();
    private List<String> kichCoQuanList = new ArrayList<>();
    private List<String> mauSacListString = new ArrayList<>();
    private List<String> kichCoListString = new ArrayList<>();

    private SanPham sanPham;
    private MauSac mauSac;
    private HinhAnh hinhAnh;
    private KichCo kichCo;
    private DanhGia danhGia;
    private UploadedFiles resume;
    private String tuTimKiem;
    private static final String FILE_PATH = "T:\\IUH\\4_Senior\\Semester 2" +
            "\\TTDN\\MyProject_Vietinfo\\Project\\WebsiteOnline\\src\\main\\webapp\\images\\";

    @PostConstruct
    public void init() {
        sanPham = new SanPham();
        mauSac = new MauSac();
        danhGia = new DanhGia();
        hinhAnh = new HinhAnh();
        kichCoAoList.add("S");
        kichCoAoList.add("M");
        kichCoAoList.add("L");
        kichCoAoList.add("XL");
        kichCoQuanList.add("26");
        kichCoQuanList.add("27");
        kichCoQuanList.add("28");
        kichCoQuanList.add("29");
        kichCoQuanList.add("30");
        kichCoQuanList.add("31");
        kichCoQuanList.add("32");
        kichCoQuanList.add("33");
    }

    public List<SanPham> getSanPhams() {
        sanPhamList = sanPhamService.getSanPhams();
        return sanPhamList;
    }

    public List<SanPham> getSanPhamsByTuKhoa(String tuKhoa) {
        sanPhamList = sanPhamService.getSanPhams();
        selectedSanPhamList = new ArrayList<>();
        String[] tuKhoaTach = tuKhoa.split(" ");
        for (SanPham sp : sanPhamList) {
            int dem = 0;
            String[] tenSanPhamTach = sp.getTenSanPham().split(" ");
            for (String str1 : tuKhoaTach) {
                for (String str2 : tenSanPhamTach) {
                    if (str1.equalsIgnoreCase(str2)) {
                        dem++;
                    }
                }
            }
            if (dem == tuKhoaTach.length) {
                selectedSanPhamList.add(sp);
            }
        }
        return selectedSanPhamList;
    }

    public List<SanPham> getSanPhamsByGia(int maGia, int maHeader) {
        selectedSanPhamListTheoGia = new ArrayList<>();
        sanPhamList = getSanPhamsTheoLoai(maHeader);
        if (maGia == 5) {
            return sanPhamList;
        }
        for (SanPham sp : sanPhamList) {
            if (maGia == 1) {
                if (sp.getDonGia() > 0 && sp.getDonGia() < 100000) {
                    selectedSanPhamListTheoGia.add(sp);
                }
            }
            if (maGia == 2) {
                if (sp.getDonGia() >= 100000 && sp.getDonGia() < 300000) {
                    selectedSanPhamListTheoGia.add(sp);
                }
            }
            if (maGia == 3) {
                if (sp.getDonGia() >= 300000 && sp.getDonGia() < 800000) {
                    selectedSanPhamListTheoGia.add(sp);
                }
            }
            if (maGia == 4) {
                if (sp.getDonGia() >= 800000) {
                    selectedSanPhamListTheoGia.add(sp);
                }
            }
        }
        return selectedSanPhamListTheoGia;
    }

    public List<SanPham> getSanPhamsByMauSac(int maGia, int maHeader, int maMau) {
        selectedSanPhamListTheoMau = new ArrayList<>();
        sanPhamList = getSanPhamsTheoLoai(maHeader);
        if(maGia != 0){
            selectedSanPhamListTheoGia = getSanPhamsByGia(maGia, maHeader);
            if(maMau == 1){
                return selectedSanPhamListTheoGia;
            }
            if(maGia == 4){
                for (SanPham sp : selectedSanPhamListTheoGia){
                    mauSacList = new ArrayList<>();
                    mauSacList = mauSacService.getMauSacsBySanPham(sp.getMaSanPham());
                    for (MauSac ms : mauSacList){
                        if(ms.getTenMau().equals("V??ng")){
                            selectedSanPhamListTheoMau.add(sp);
                        }
                    }
                }
            }
        }
        else{
            if(maMau == 1){
                return sanPhamList;
            }
            if(maGia == 4){
                for (SanPham sp : sanPhamList){
                    mauSacList = new ArrayList<>();
                    mauSacList = mauSacService.getMauSacsBySanPham(sp.getMaSanPham());
                    for (MauSac ms : mauSacList){
                        if(ms.getTenMau().equals("V??ng")){
                            selectedSanPhamListTheoMau.add(sp);
                        }
                    }
                }
            }
        }
        return selectedSanPhamListTheoMau;
    }

    public List<SanPham> getSanPhamsTheoLoai(int ma) {
        sanPhamList = sanPhamService.getSanPhams();
        selectedSanPhamList = new ArrayList<>();
        if (ma == 1) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N IN H??NH") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N TR??N") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N C?? C???") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N CROPTOP") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY D??I IN H??NH") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY D??I CROPTOP") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY D??I LEN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 2) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("S?? MI N??? TAY NG???N") ||
                        sp.getTenLoaiSanPham().equals("S?? MI N??? TAY D??I")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 3) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N SHORT N??? JEAN") ||
                        sp.getTenLoaiSanPham().equals("QU???N SHORT N??? KAKI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 4) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I N??? JEAN") ||
                        sp.getTenLoaiSanPham().equals("QU???N D??I N??? THUN") ||
                        sp.getTenLoaiSanPham().equals("QU???N D??I N??? KAKI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 5) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("V??Y ?????M")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 6) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("CH??N V??Y")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 7) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N TR??N") ||
                        sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N IN H??NH") ||
                        sp.getTenLoaiSanPham().equals("THUN NAM TAY D??I LEN") ||
                        sp.getTenLoaiSanPham().equals("THUN NAM TAY D??I IN H??NH") ||
                        sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N C?? C???")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 8) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("S?? MI NAM TAY NG???N") ||
                        sp.getTenLoaiSanPham().equals("S?? MI NAM TAY D??I")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 9) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N SHORT NAM JEAN") ||
                        sp.getTenLoaiSanPham().equals("QU???N SHORT NAM KAKI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 10) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I NAM JEAN") ||
                        sp.getTenLoaiSanPham().equals("QU???N D??I NAM KAKI") ||
                        sp.getTenLoaiSanPham().equals("QU???N D??I NAM THUN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 11) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("BA L??") ||
                        sp.getTenLoaiSanPham().equals("T??I X??CH") ||
                        sp.getTenLoaiSanPham().equals("D??Y N???CH") ||
                        sp.getTenLoaiSanPham().equals("TH???T L??NG") ||
                        sp.getTenLoaiSanPham().equals("?????NG H???") ||
                        sp.getTenLoaiSanPham().equals("V??") ||
                        sp.getTenLoaiSanPham().equals("N??N L?????I TRAI") ||
                        sp.getTenLoaiSanPham().equals("N??N SNAPBACK") ||
                        sp.getTenLoaiSanPham().equals("N??N BUCKET")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 12) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N IN H??NH") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N TR??N") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N C?? C???") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N CROPTOP")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 13) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY D??I IN H??NH") ||
                        sp.getTenLoaiSanPham().equals("THUN N??? TAY D??I CROPTOP")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 14) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N TR??N") ||
                        sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N IN H??NH") ||
                        sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N C?? C???")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 15) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY D??I LEN") ||
                        sp.getTenLoaiSanPham().equals("THUN NAM TAY D??I IN H??NH")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 16) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("N??N L?????I TRAI") ||
                        sp.getTenLoaiSanPham().equals("N??N SNAPBACK") ||
                        sp.getTenLoaiSanPham().equals("N??N BUCKET")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 17) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N TR??N")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 18) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N IN H??NH")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 19) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N C?? C???")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 20) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY NG???N CROPTOP")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 21) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY D??I IN H??NH")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 22) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN N??? TAY D??I CROPTOP")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 23) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("??O S?? MI N??? TAY NG???N")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 24) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("??O S?? MI N??? TAY D??I")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 25) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N SHORT N??? JEAN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 26) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N SHORT N??? KAKI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 27) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I N??? JEAN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 28) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I N??? THUN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 29) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I N??? KAKI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 30) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N TR??N")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 31) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N IN H??NH")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 33) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY NG???N C?? C???")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 34) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY D??I IN H??NH")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 35) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("THUN NAM TAY D??I LEN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 36) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("??O S?? MI NAM TAY D??I")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 37) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N SHORT NAM JEAN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 38) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N SHORT NAM KAKI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 39) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I NAM JEAN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 40) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I NAM KAKI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 41) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("QU???N D??I NAM THUN")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 42) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("BA L??")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 43) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("D??Y N???CH")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 44) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("?????NG H???")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 45) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("TH???T L??NG")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 46) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("V??")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 47) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("N??N L?????I TRAI")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 48) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("N??N SNAPBACK")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 49) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("N??N BUCKET")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        if (ma == 50) {
            for (SanPham sp : sanPhamList) {
                if (sp.getTenLoaiSanPham().equals("??O S?? MI NAM TAY NG???N")) {
                    selectedSanPhamList.add(sp);
                }
            }
        }
        return selectedSanPhamList;
    }

    public List<HinhAnh> getHinhAnhBySanPham(int masp) {
        hinhAnhList = sanPhamService.getHinhAnhsBySanPham(masp);
        hinhAnhList2 = new ArrayList<>();
        for (HinhAnh ha : hinhAnhList) {
            if (!ha.getTenHinhAnh().contains("demo")) {
                hinhAnhList2.add(ha);
            }
        }
        return hinhAnhList2;
    }

    public List<DanhGia> getDanhGiaBySanPham(int masp) {
        danhGiaList = new ArrayList<>();
        danhGiaList = sanPhamService.getDanhGiasBySanPham(masp);
        return danhGiaList;
    }

    public List<MauSac> getMauSacBySanPham(int masp) {
        mauSacList = mauSacService.getMauSacsBySanPham(masp);
        return mauSacList;
    }

    public List<String> getMauSacBySanPhamString(int masp) {
        mauSacList = mauSacService.getMauSacsBySanPham(masp);
        mauSacListString = new ArrayList<>();
        for (MauSac ms : mauSacList) {
            mauSacListString.add(ms.getTenMau());
        }
        return mauSacListString;
    }

    public List<KichCo> getKichCoByMauSac(int mam) {
        kichCoList = kichCoService.getKichCosByMauSac(mam);
        return kichCoList;
    }

    public Map<String, String> getNoiSanXuats() {
        return noiSanXuatService.getNoiSanXuats();
    }

    public String deleteSanPham() {
        sanPhamService.deleteSanPham(sanPham);
        return "";
    }

    public String saveSanPham() {
        if (sanPham.getMaSanPham() == 0) {
            sanPhamService.addSanPham(sanPham);
            uploadN();
            if (sanPham.getLoai().equals("1")) {
                addMauSacBySanPham("1");
            } else if (sanPham.getLoai().equals("2")) {
                addMauSacBySanPham("2");
            }
        } else {
            if (resume == null) {
                sanPhamService.updateSanPham(sanPham);
            } else {
                uploadN();
                sanPhamService.updateSanPham(sanPham);
            }
        }
        return "";
    }

    public String openDialog() {
        PrimeFaces current = PrimeFaces.current();
        current.executeScript("PF('dlg-hinh-anh').show();");
        return "";
    }

    public String nextPageDetail(int masp) {
        sanPham = sanPhamService.find(masp);
        return "chi-tiet-san-pham?faces-redirect=true&includeViewParams=true";
    }

    public void addKichCoAoByMauSac(MauSac ms) {
        for (String str : kichCoAoList.subList(0, 4)) {
            kichCo = new KichCo();
            kichCo.setMauSac(ms);
            kichCo.setSoLuong(0);
            kichCo.setTenKichCo(str);
            kichCoService.addKichCo(kichCo);
        }
    }

    public void addKichCoQuanByMauSac(MauSac ms) {
        for (String str : kichCoQuanList.subList(0, 8)) {
            kichCo = new KichCo();
            kichCo.setMauSac(ms);
            kichCo.setSoLuong(0);
            kichCo.setTenKichCo(str);
            kichCoService.addKichCo(kichCo);
        }
    }

    public void addMauSacBySanPham(String loai) {
        for (String str : mauSacListString) {
            mauSac = new MauSac();
            mauSac.setTenMau(str);
            mauSac.setSanPham(sanPham);
            mauSac.setSoLuong(0);
            mauSacService.addMauSac(mauSac);
            if (loai.equals("1")) {
                addKichCoAoByMauSac(mauSac);
            } else {
                if (loai.equals("2")) {
                    addKichCoQuanByMauSac(mauSac);
                }
            }
        }
    }

    public HinhAnh getHinhAnhDemo(int masp) {
        hinhAnhList = sanPhamService.getHinhAnhsBySanPham(masp);
        hinhAnh = new HinhAnh();
        for (HinhAnh ha : hinhAnhList) {
            if (ha.getTenHinhAnh().contains("demo")) {
                hinhAnh = ha;
            }
        }
        return hinhAnh;
    }

    public void uploadN() {
        if (resume != null)
            for (UploadedFile f : resume.getFiles()) {
                upload1(f);
                hinhAnh = new HinhAnh();
                hinhAnh.setTenHinhAnh(f.getFileName());
                hinhAnh.setSanPham(sanPham);
                sanPhamService.addHinhAnh(hinhAnh);
            }
        else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Th??ng b??o", "Ch???n " +
                    "t???i thi???u 1 h??nh ???nh cho s???n ph???m");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }
    }

    @SneakyThrows
    public void upload1(UploadedFile f) {
        byte[] bytes;
        bytes = f.getContent();
        String filename = FilenameUtils.getName(f.getFileName());
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(FILE_PATH + filename)));
        stream.write(bytes);
        stream.close();
    }

    public String saveDanhGia(String tekh, int masp) {
        sanPham = new SanPham();
        sanPham = sanPhamService.find(masp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        danhGia.setTenKhachHang(tekh);
        danhGia.setThoiGian(formatter.format(LocalDateTime.now()));
        danhGia.setSanPham(sanPham);
        sanPhamService.addDanhGia(danhGia);
        return "";
    }

    public String tinhTrungBinhSao(int masp){
        double tongSao = 0;
        danhGiaList = getDanhGiaBySanPham(masp);
        DecimalFormat formatter = new DecimalFormat("#0.0");
        if(danhGiaList.size() == 0){
            return "5";
        }else{
            for (DanhGia danhGia : danhGiaList) {
                tongSao += danhGia.getSao();
            }
            return formatter.format(tongSao/danhGiaList.size());
        }
    }
}