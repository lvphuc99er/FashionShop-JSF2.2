package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.models.NhaCungCap;
import tech.vietinfo.services.NhaCungCapService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("nhaCungCapBean")
@ViewScoped
@Getter
@Setter
public class NhaCungCapBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private NhaCungCapService nhaCungCapService;

    private List<NhaCungCap> nhaCungCapList = new ArrayList<>();

    private NhaCungCap nhaCungCap;

    public List<NhaCungCap> getNhaCungCaps() {
        nhaCungCapList = nhaCungCapService.getNhaCungCaps();
        return nhaCungCapList;
    }

    @PostConstruct
    public void init() {
        nhaCungCap = new NhaCungCap();
    }

    public void init_update(int id) {
        nhaCungCap = nhaCungCapService.find(id);
    }



    public String add_NCC() {
        nhaCungCapService.add_NCC(nhaCungCap);
        return "smn_listsupplier";
    }

    public String delete_NCC(NhaCungCap ncc) {
        nhaCungCapService.delete_NCC(ncc);
        return "smn_listsupplier?faces-redirect=true";
    }

    public String update_NCC() {
        nhaCungCapService.update_NCC(nhaCungCap);
        return "smn_listsupplier?faces-redirect=true";
    }

    public String nextPageUdate() {
        return "smn_listsupplier_update?faces-redirect=true&includeViewParams=true";
    }

    public String nextPageCreate() {
        return "smn_listsupplier_create?faces-redirect=true";
    }

}
