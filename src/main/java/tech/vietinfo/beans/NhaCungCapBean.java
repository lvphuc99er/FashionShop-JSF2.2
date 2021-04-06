package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import tech.vietinfo.models.NhaCungCap;
import tech.vietinfo.services.NhaCungCapService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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

    @PostConstruct
    public void init(){
        nhaCungCap = new NhaCungCap();
    }

    public List<NhaCungCap> getNhaCungCaps() {
        nhaCungCapList = nhaCungCapService.getNhaCungCaps();
        return nhaCungCapList;
    }

    public String addNhaCungCap() {
        nhaCungCapService.addNhaCungCap(nhaCungCap);
        return "smn_listsupplier?faces-redirect=true";
    }

    public String deleteNhaCungCap() {
        nhaCungCapService.deleteNhaCungCap(nhaCungCap);
        return "smn_listsupplier?faces-redirect=true";
    }

    public String updateNhaCungCap() {
        nhaCungCapService.updateNhaCungCap(nhaCungCap);
        return "smn_listsupplier?faces-redirect=true";
    }

    public String nextPageCreate() {
        return "smn_listsupplier_create?faces-redirect=true";
    }

}
