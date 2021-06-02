package tech.vietinfo.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import tech.vietinfo.models.KhachHang;
import tech.vietinfo.models.NhanVien;
import tech.vietinfo.services.KhachHangService;
import tech.vietinfo.services.NhanVienService;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;

@Named("login")
@SessionScoped
@Getter
@Setter
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String ADMIN = "admin";
    private final String PASS = "admin";

    @NotBlank(message = "Tên đăng nhập không đúng")
    private String username;

    @NotBlank(message = "Mật khẩu không đúng")
    private String password;

    private int integer;

    @Inject
    private KhachHangService khachHangService;
    private List<KhachHang> khachHangs;
    private KhachHang khachHang;

    @Inject
    private NhanVienService nhanVienService;
    private List<NhanVien> nhanViens;
    private NhanVien nhanVien;

    HttpSession session = SessionUtil.getSession();
    private int err;
    private String messSai = "Tên tài khoản hoặc mật khẩu không chính xác";

    /*
     * kiểm tra xem đã đăng nhập hay chưa
     */
    public void grantPermission() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object adminLoggedIn = session.getAttribute("name");
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        if (adminLoggedIn == null) {
            try {
                context.redirect("login.xhtml?faces-redirect=true");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String logout() {
        session = SessionUtil.getSession();
        session.invalidate();
        return "trang-chu?faces-redirect=true";
    }

    public int checkRole() {
        Object userLoggedIn = session.getAttribute("name");
        if (userLoggedIn == "admin") {
            return 1;
        } else if (userLoggedIn == "user") {
            return 2;
        } else if (userLoggedIn == "nhanvien") {
            return 3;
        }
        return 0;
    }

    public String validateLogin() {
        if (username.equals(ADMIN) && password.equals(PASS)) {
            session.setAttribute("name", "admin");
            return "admin-page?faces-redirect=true";
        } else if (username.contains("nhanvien@")) {
            nhanViens = nhanVienService.getNhanViens();
            for (NhanVien nv : nhanViens) {
                if (username.equals("nhanvien@" + nv.getSoDienThoai()) && password.equals(nv.getMatKhau())) {
                    nhanVien = nv;
                    session.setAttribute("name", "nhanvien");
                    return "trang-chu?faces-redirect=true&includeViewParams=true";
                }
            }
        } else {
            int dem = 0;
            khachHangs = khachHangService.getKhachHangs();
            for (KhachHang kh : khachHangs) {
                if (username.equals(kh.getSoDienThoai()) && password.equals(kh.getMatKhau())) {
                    if (kh.getTrangThai().equals("KHÓA")) {
                        err = 2;
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Thông báo", "Tài khoản " +
                                "của bạn đã bị khóa do vi phạm chính sách người dùng. Vui lòng liên hệ 0123456789 để giải đáp thắc" +
                                "mắc và khiếu nại.");
                        PrimeFaces.current().dialog().showMessageDynamic(message);
                        load();
                        return "login";
                    } else {
                        khachHang = kh;
                        session.setAttribute("name", "user");
                        return "trang-chu?faces-redirect=true&includeViewParams=true";
                    }
                } else {
                    dem++;
                }
            }
            if (dem == khachHangs.size()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Thông báo", "Tên" +
                        "đăng nhập hoặc tài khoản không đúng.");
                PrimeFaces.current().dialog().showMessageDynamic(message);
                load();
            }
        }
        return "login";
    }

    public String updateKhachHang() {
        khachHangService.updateKhachHang(khachHang);
        return "thong-tin-ca-nhan?faces-redirect=true";
    }

    public String load() {
        username = "";
        password = "";
        err = 0;
        return "login?faces-redirect=true";
    }
}
