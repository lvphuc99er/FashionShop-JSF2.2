package tech.vietinfo.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("login")
@ViewScoped
@Getter
@Setter
@NoArgsConstructor
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String ADMIN = "admin";
    private final String PASS = "admin";
    private final String USER = "user";
    private final String PASS_USER = "user";

    private String username;
    private String password;

    HttpSession session = SessionUtil.getSession();

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
        return "dashboard?faces-redirect=true";
    }

    public int checkRole() {
        Object userLoggedIn = session.getAttribute("name");
        if (userLoggedIn == "admin") {
            return 1;
        }
        if (userLoggedIn == "user") {
            return 2;
        }
        if (userLoggedIn == "none") {
            return 0;
        }
        return 0;
    }

    public String validateLogin() {
        if (username.equals(ADMIN) && password.equals(PASS)) {
            session.setAttribute("name", "admin");
            return "dashboard?faces-redirect=true";
        } else {
            if (username.equals(USER) && password.equals(PASS_USER)) {
                session.setAttribute("name", "user");
                return "dashboard?faces-redirect=true";
            } else {
                String message = "Sai tài khoản hoặc mật khẩu";
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
                return "login.xhtml";
            }
        }
    }
}
