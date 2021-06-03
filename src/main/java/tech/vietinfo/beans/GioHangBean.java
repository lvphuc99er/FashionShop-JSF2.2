package tech.vietinfo.beans;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import tech.vietinfo.models.*;
import tech.vietinfo.services.DonHangService;
import tech.vietinfo.services.GioHangService;
import tech.vietinfo.services.KhachHangService;
import tech.vietinfo.services.SanPhamService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Named("cartBean")
@ViewScoped
@Getter
@Setter
public class GioHangBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private final double SHIPCOST = 30000;

    @Inject
    private SanPhamService sanPhamService;

    @Inject
    private GioHangService gioHangService;

    @Inject
    private DonHangService donHangService;

    @Inject
    private KhachHangService khachHangService;

    private List<ChiTietGioHang> chiTietGioHangList = new ArrayList<>();
    private List<DonHang> donHangList = new ArrayList<>();
    private List<DonHang> selectedDonHangList = new ArrayList<>();
    private List<ChiTietDonHang> chiTietDonHangList = new ArrayList<>();

    private KhachHang khachHang;
    private SanPham sanPham;
    private GioHang gioHang;
    private ChiTietGioHang chiTietGioHang;
    private DonHang donHang;
    private DonHang selectedDonHang;
    private ChiTietDonHang chiTietDonHang;
    private LocalDateTime ngayDatHang = LocalDateTime.now();
    private int soLuong;

    @NotNull(message = "Chọn kích cỡ")
    private String kichCo;

    @NotNull(message = "Chọn màu sắc")
    private String mau;

    @PostConstruct
    public void init() {
        donHang = new DonHang();
        gioHang = new GioHang();
        selectedDonHang = new DonHang();
        chiTietGioHang = new ChiTietGioHang();
        chiTietDonHang = new ChiTietDonHang();
    }

    public List<ChiTietGioHang> getChiTietGioHangs(int makh) {
        gioHang = gioHangService.getGioHangs(makh).get(0);
        chiTietGioHangList = gioHang.getChiTietGioHangList();
        return chiTietGioHangList;
    }

    public int giamSoLuong(ChiTietGioHang ct) {
        if (ct.getSoLuong() > 1) {
            ct.setSoLuong(ct.getSoLuong() - 1);
            ct.setThanhTien(ct.getThanhTien() - ct.getSanPham().getDonGia());
            gioHangService.updateChiTietGioHang(ct);
            sanPham = sanPhamService.find(ct.getSanPham().getMaSanPham());
            sanPham.setSoLuongCoSan(sanPham.getSoLuongCoSan() + 1);
            sanPhamService.updateSanPham(sanPham);
        }
        return ct.getSoLuong();
    }

    public String getThongTin(KhachHang kh) {
        donHang.setTenNguoiNhan(kh.getTenKhachHang());
        donHang.setSdtNguoiNhan(kh.getSoDienThoai());
        donHang.setDiaChiNguoiNhan(kh.getDiaChi());
        return "pay?faces-redirect=true";
    }

    public int tangSoLuong(ChiTietGioHang ct) {
        ct.setSoLuong(ct.getSoLuong() + 1);
        ct.setThanhTien(ct.getThanhTien() + ct.getSanPham().getDonGia());
        gioHangService.updateChiTietGioHang(ct);
        sanPham = sanPhamService.find(ct.getSanPham().getMaSanPham());
        sanPham.setSoLuongCoSan(sanPham.getSoLuongCoSan() - 1);
        sanPhamService.updateSanPham(sanPham);
        return ct.getSoLuong();
    }

    public String addSanPhamVaoGioHang(int masp) {
        if (!checkTrungSanPham(masp)) {
            chiTietGioHang.setSanPham(sanPham);
            chiTietGioHangList.add(chiTietGioHang);

            gioHang.setChiTietGioHangList(chiTietGioHangList);
            chiTietGioHang.setSoLuong(soLuong);
            chiTietGioHang.setGioHang(gioHang);
            chiTietGioHang.setThanhTien(sanPham.getDonGia() * soLuong);
            chiTietGioHang.setPhanLoai(kichCo + " - " + mau);

            gioHangService.addChiTietGioHang(chiTietGioHang);
        } else {
            for (ChiTietGioHang ct : chiTietGioHangList) {
                if (ct.getSanPham().getMaSanPham() == sanPham.getMaSanPham()) {
                    ct.setSoLuong(ct.getSoLuong() + soLuong);
                    ct.setThanhTien(ct.getThanhTien() + ct.getSanPham().getDonGia());
                    gioHangService.updateChiTietGioHang(ct);
                }
            }
        }
        sanPham.setSoLuongCoSan(sanPham.getSoLuongCoSan() - soLuong);
        sanPhamService.updateSanPham(sanPham);
        gioHangService.updateGioHang(gioHang);
        return "shoppingcart?faces-redirect=true";
    }

    public String deleteSanPhamKhoiGioHang(ChiTietGioHang ct) {
        sanPham = sanPhamService.find(ct.getSanPham().getMaSanPham());
        int sl = sanPham.getSoLuongCoSan();
        sanPham.setSoLuongCoSan(sl + ct.getSoLuong());
        sanPhamService.updateSanPham(sanPham);
        gioHangService.deleteChiTietGioHang(ct);
        return "shoppingcart?faces-redirect=true";
    }

    public void xoaSanPhamSauKhiThanhToan(int makh) {
        gioHang = gioHangService.getGioHangs(makh).get(0);
        chiTietGioHangList = gioHang.getChiTietGioHangList();
        for (ChiTietGioHang ct : chiTietGioHangList) {
            gioHangService.deleteChiTietGioHang(ct);
        }
    }

    public boolean checkTrungSanPham(int masp) {
        sanPham = sanPhamService.find(masp);
        chiTietGioHangList = gioHang.getChiTietGioHangList();
        for (ChiTietGioHang ct : chiTietGioHangList) {
            if (ct.getSanPham().getMaSanPham() == sanPham.getMaSanPham() && ct.getPhanLoai().equals(kichCo + " - " + mau)) {
                return true;
            }
        }
        return false;
    }

    public double totalSanPham() {
        double s = 0;
        for (ChiTietGioHang ct : chiTietGioHangList) {
            s += ct.getThanhTien();
        }
        return s;
    }

    public double totalDonHang() {
        return totalSanPham() + SHIPCOST;
    }

    public String addDonHang(KhachHang kh, int dieuHuong) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        donHang.setKhachHang(kh);
        if (dieuHuong != 8) {
            donHang.setTenNguoiNhan(kh.getTenKhachHang());
            donHang.setSdtNguoiNhan(kh.getSoDienThoai());
            donHang.setDiaChiNguoiNhan(kh.getDiaChi());
        }
        donHang.setNgayDatHang(ngayDatHang.format(formatter));
        donHang.setNgayNhanHang(ngayDatHang.plusDays(3).format(formatter1));
        donHang.setDonViVanChuyen("Nhân viên LIVE LOUNGE");
        donHang.setTrangThai("Chờ xác nhận");
        donHang.setThanhTien(totalDonHang());
        donHangService.addDonHang(donHang);

        for (ChiTietGioHang ct : chiTietGioHangList) {
            addChiTietDonHang(ct);
        }
        xoaSanPhamSauKhiThanhToan(kh.getMaKhachHang());
        if (!kh.getEmail().equals("")) {
            sendMail(kh, donHang);
        }
        return "";
    }

    public void sendMail(KhachHang khachHang, DonHang donHang) {

        final String username = "liveloungeshop@gmail.com";
        final String password = "alt0134hom150719";

        chiTietDonHangList = donHangService.getChiTietDonHangsByDonHang(donHang.getMaDonHang());

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.mime.charset", "utf-8");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(khachHang.getEmail()));
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setSubject("LIVE LOUNGE SHOP - Đặt hàng thành công", "UTF-8");

            String hoaDon = "Cảm ơn bạn đã đặt hàng tại LIVE LOUNGE SHOP <br/>" +
                    "<i>(Đơn hàng sẽ được hoàn tất chuyển giao trong vòng 3 ngày làm việc," +
                    "vui lòng theo dõi đơn hàng của bạn để nhận hàng)</i><br/>" +
                    "<h1>THÔNG TIN HÓA ĐƠN - MÃ HÓA ĐƠN: " + donHang.getMaDonHang() + "</h1>" +
                    "<table>" +

                    "<tr> " +
                    "<td> Tên khách hàng: </td>" +
                    "<td> <b>" + donHang.getTenNguoiNhan() + "</b></td>" +
                    "</tr>" +

                    "<tr>" +
                    "<td> Số điện thoại: </td>" +
                    "<td> <b>" + donHang.getSdtNguoiNhan() + "</b> </td>" +
                    "</tr>" +

                    "<tr>" +
                    "<td> Ngày đặt hàng: </td>" +
                    "<td> <b>" + donHang.getNgayDatHang() + "</b> </td>" +
                    "</tr>" +

                    "<tr>" +
                    "<td> Ngày nhận dự kiến: </td>" +
                    "<td> <b>" + donHang.getNgayNhanHang() + "</b> </td>" +
                    "</tr>" +

                    "<tr>" +
                    "<td> Hình thức thanh toán: </td>" +
                    "<td> <b>" + donHang.getPhuongThucThanhToan() + "</b> </td>" +
                    "</tr>" +

                    "<tr>" +
                    "<td> Địa chỉ nhận hàng: </td>" +
                    "<td> <b>" + donHang.getDiaChiNguoiNhan() + "</b> </td>" +
                    "</tr>" +

                    "<tr>" +
                    "<td> Tổng tiền đơn hàng: </td>" +
                    "<td> <h2>" + donHang.getThanhTien() + "</h2></td>" +
                    "</tr>" +
                    "</table>";

            message.setContent(hoaDon, "text/html; charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void addChiTietDonHang(ChiTietGioHang ct) {
        chiTietDonHang = new ChiTietDonHang();
        chiTietDonHang.setTenNoiSanXuat(ct.getSanPham().getTenNoiSanXuat());
        chiTietDonHang.setTenSanPham(ct.getSanPham().getTenSanPham());
        chiTietDonHang.setDonGia(ct.getSanPham().getDonGia());
        chiTietDonHang.setSoLuong(ct.getSoLuong());
        chiTietDonHang.setDonHang(donHang);
        chiTietDonHang.setPhanLoai(ct.getPhanLoai());
        chiTietDonHang.setMaSanPham(ct.getSanPham().getMaSanPham());
        chiTietDonHang.setThanhTien(ct.getSanPham().getDonGia() * ct.getSoLuong());
        donHangService.addChiTietDonHang(chiTietDonHang);
    }

    public List<DonHang> getDonHangs() {
        donHangList = donHangService.getDonHangs();
        return donHangList;
    }

    public List<DonHang> getDonHangsTheoTrangThai(int ma) {
        selectedDonHangList = new ArrayList<>();
        donHangList = donHangService.getDonHangs();
        if (ma == 1) {
            return donHangList;
        }
        if (ma == 2) {
            for (DonHang dh : donHangList) {
                if (dh.getTrangThai().equals("Chờ xác nhận")) {
                    selectedDonHangList.add(dh);
                }
            }
        }
        if (ma == 3) {
            for (DonHang dh : donHangList) {
                if (dh.getTrangThai().equals("Chờ lấy hàng")) {
                    selectedDonHangList.add(dh);
                }
            }
        }
        if (ma == 4) {
            for (DonHang dh : donHangList) {
                if (dh.getTrangThai().equals("Đang giao hàng")) {
                    selectedDonHangList.add(dh);
                }
            }
        }
        if (ma == 5) {
            for (DonHang dh : donHangList) {
                if (dh.getTrangThai().equals("Đã nhận hàng")) {
                    selectedDonHangList.add(dh);
                }
            }
        }
        if (ma == 6) {
            for (DonHang dh : donHangList) {
                if (dh.getTrangThai().equals("Đã hủy")) {
                    selectedDonHangList.add(dh);
                }
            }
        }
        return selectedDonHangList;
    }

    public List<DonHang> getDonHangsByKhachHang(int makh, int maDonHang) {
        selectedDonHangList = new ArrayList<>();
        donHangList = donHangService.getDonHangs();
        for (DonHang dh : donHangList) {
            if (dh.getKhachHang().getMaKhachHang() == makh) {
                selectedDonHangList.add(dh);
            }
        }
        donHangList = new ArrayList<>();
        if (maDonHang == 1) {
            donHangList.addAll(selectedDonHangList);
        }
        if (maDonHang == 2) {
            for (DonHang dh : selectedDonHangList) {
                if (dh.getTrangThai().equals("Chờ xác nhận")) {
                    donHangList.add(dh);
                }
            }
        }
        if (maDonHang == 3) {
            for (DonHang dh : selectedDonHangList) {
                if (dh.getTrangThai().equals("Chờ lấy hàng")) {
                    donHangList.add(dh);
                }
            }
        }
        if (maDonHang == 4) {
            for (DonHang dh : selectedDonHangList) {
                if (dh.getTrangThai().equals("Đang giao hàng")) {
                    donHangList.add(dh);
                }
            }
        }
        if (maDonHang == 5) {
            for (DonHang dh : selectedDonHangList) {
                if (dh.getTrangThai().equals("Đã nhận hàng")) {
                    donHangList.add(dh);
                }
            }
        }
        if (maDonHang == 6) {
            for (DonHang dh : selectedDonHangList) {
                if (dh.getTrangThai().equals("Đã hủy")) {
                    donHangList.add(dh);
                }
            }
        }
        return donHangList;
    }

    public List<ChiTietDonHang> getChiTietDonHangs(int madh) {
        chiTietDonHangList = donHangService.getChiTietDonHangs(madh);
        return chiTietDonHangList;
    }

    public String deleteDonHang(DonHang dh) {
        chiTietDonHangList = donHangService.getChiTietDonHangsByDonHang(dh.getMaDonHang());
        for (ChiTietDonHang ctdh : chiTietDonHangList) {
            donHangService.deleteChiTietDonHang(ctdh);
        }
        donHangService.deleteDonHang(dh);
        return "";
    }

    public String huyDonHang(DonHang dh) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = LocalDateTime.parse(dh.getNgayDatHang(), formatter);
        if (time.plusMinutes(1).isAfter(now)) {
            dh.setTrangThai("Đã hủy");
            donHangService.updateDonHang(dh);
            return "don-hang-ca-nhan?faces-redirect=true";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Thông báo", "Đã quá 30 " +
                    "phút, không thể hủy. Vui lòng theo dõi và nhận đơn hàng.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            PrimeFaces.current().executeScript("PF('dlghuy').hide();");
        }
        return "";
    }

    public String choXacNhan(DonHang dh) {
        dh.setTrangThai("Chờ lấy hàng");
        donHangService.updateDonHang(dh);
        return "";
    }

    public String dangGiaoHang(DonHang dh) {
        dh.setTrangThai("Đang giao hàng");
        donHangService.updateDonHang(dh);
        return "";
    }

    public String daGiaoHang(DonHang donHang) {
        donHang.setTrangThai("Đã giao hàng");
        donHangService.updateDonHang(donHang);
        return "";
    }

    public int demSoLuongTrongGioHang(int makh) {
        int dem = 0;
        gioHang = gioHangService.getGioHangs(makh).get(0);
        chiTietGioHangList = gioHang.getChiTietGioHangList();
        for(ChiTietGioHang ct : chiTietGioHangList){
            dem = dem + ct.getSoLuong();
        }
        return dem;
    }

    public List<DonHang> getDonHangsByTrangThai(String tt) {
        selectedDonHangList = new ArrayList<>();
        donHangList = donHangService.getDonHangs();
        for (DonHang dh : donHangList) {
            if (dh.getTrangThai().equals(tt)) {
                selectedDonHangList.add(dh);
            }
        }
        return selectedDonHangList;
    }
}
