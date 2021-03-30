package tech.vietinfo.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import tech.vietinfo.models.KhachHang;
import tech.vietinfo.services.KhachHangService;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("login")
@SessionScoped
@Getter
@Setter
@NoArgsConstructor
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String ADMIN = "admin";
    private final String PASS = "admin";

    private String username;
    private String password;

    @Inject
    private KhachHangService khachHangService;
    private List<KhachHang> khachHangs;
    private KhachHang khachHang;

    HttpSession session = SessionUtil.getSession();

    //    check da dang nhap chua
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

    //    dang xuat
    public String logout() {
        session = SessionUtil.getSession();
        session.invalidate();
        return "dashboard?faces-redirect=true";
    }

    //    check role
    public int checkRole() {
        Object userLoggedIn = session.getAttribute("name");
        if (userLoggedIn == "admin") {
            return 1;
        }
        if (userLoggedIn == "user") {
            return 2;
        }
        return 0;
    }

    //    check dang nhap
    public String validateLogin() {
        if (username.equals(ADMIN) && password.equals(PASS)) {
            session.setAttribute("name", "admin");
            return "dashboard?faces-redirect=true&includeViewParams=true";
        } else {
            khachHangs = khachHangService.getKhachHangs();
            for (KhachHang kh : khachHangs) {
                if (username.equals(kh.getSoDienThoai_KH()) && password.equals(kh.getMatKhau())) {
                    session.setAttribute("name", "user");
                    return "dashboard?faces-redirect=true&includeViewParams=true";
                }
            }
        }
        return "login";
    }

    public KhachHang getKhachHang(){
        khachHang = khachHangService.getSanPhamsBySDT(username).get(0);
        return khachHang;
    }

    public String update_user(){
        khachHangService.updateKhachHang(khachHang);
        return "u_information?faces-redirect=true";
    }


}
