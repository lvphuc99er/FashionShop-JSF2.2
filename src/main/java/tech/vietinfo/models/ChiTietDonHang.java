package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ChiTietDonHang")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maDonHang", referencedColumnName = "maDonHang")
    private DonHang donHang;

    @Id
    @Column(name = "maSanPham")
    private int maSanPham;

    @Column(name = "tenSanPham")
    private String tenSanPham;

    @Column(name = "tenNoiSanXuat")
    private String tenNoiSanXuat;

    @Column(name = "phanLoai")
    private String phanLoai;

    @Column(name = "donGia")
    private double donGia;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "thanhTien")
    private double thanhTien;

}
