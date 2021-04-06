package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DonHang")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maDonHang")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maDonDang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;

    @Column(name = "tenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "sdtNguoiNhan")
    private String sdtNguoiNhan;

    @Column(name = "diaChiNguoiNhan")
    private String diaChiNguoiNhan;

    @Column(name = "ngayDatHang")
    private String ngayDatHang;

    @Column(name = "ngayNhanHang")
    private String ngayNhanHang;

    @Column(name = "donViVanChuyen")
    private String donViVanChuyen;

    @Column(name = "phuongThucThanhToan")
    private String phuongThucThanhToan;

    @Column(name = "thanhTien")
    private double thanhTien;

    @Column(name = "trangThai")
    private String trangThai;

    @OneToMany(mappedBy = "donHang",fetch = FetchType.LAZY)
    private List<ChiTietDonHang> chiTietDonHangList;

    @Override
    public String toString() {
        return "DonHang{" +
                "maDonDang=" + maDonDang +
                ", khachHang=" + khachHang +
                ", tenNguoiNhan='" + tenNguoiNhan + '\'' +
                ", sdtNguoiNhan='" + sdtNguoiNhan + '\'' +
                ", diaChiNguoiNhan='" + diaChiNguoiNhan + '\'' +
                ", ngayDatHang='" + ngayDatHang + '\'' +
                ", ngayNhanHang='" + ngayNhanHang + '\'' +
                ", donViVanChuyen='" + donViVanChuyen + '\'' +
                ", phuongThucThanhToan='" + phuongThucThanhToan + '\'' +
                ", thanhTien=" + thanhTien +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
