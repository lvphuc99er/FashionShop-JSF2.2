package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import tech.vietinfo.models.ChiTietDonHang;
import tech.vietinfo.models.DonHang;
import tech.vietinfo.services.DonHangService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.*;

@Named("quanLyDonHangBean")
@ViewScoped
@Getter
@Setter
public class QuanLyDonHangBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DonHangService donHangService;

    private List<DonHang> donHangList = new ArrayList<>();
    private List<ChiTietDonHang> chiTietDonHangList;
    private DonHang donHang;
    private ChiTietDonHang chiTietDonHang;

    public List<DonHang> getDonHangs(){
        return donHangService.getDonHangs();
    }

//    public List<DonHang> getDonHangsByTimKiem(String tu){
//        donHangList = new ArrayList<>();
//        donHangList = donHangService.getDonHangs();
//        for (DonHang dh : donHangList) {
//            try {
//                Integer.parseInt(tu);
//
//            } catch (Exception e) {
//
//            }
//        }
//    }
}
