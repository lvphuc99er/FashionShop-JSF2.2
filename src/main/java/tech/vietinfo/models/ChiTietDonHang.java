package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ChiTietDonHang")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maDonHang", referencedColumnName = "maDonHang")
    private DonHang donHang;

    @ManyToOne(fetch = FetchType.EAGER)
    private SanPham sanPham;

    @Id
    @Column(name = "maSanPham")
    private int maSanPham;

    @Column(name = "tenSanPham")
    private String tenSanPham;

    @Column(name = "xuatXu")
    private String xuatXu;

    @Column(name = "donGia")
    private double donGia;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "thanhTien")
    private double thanhTien;

}
