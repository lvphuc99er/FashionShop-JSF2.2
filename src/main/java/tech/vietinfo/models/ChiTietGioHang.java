package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chitietgiohang")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietGioHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maChiTietGioHang")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maChiTietGioHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maGioHang", referencedColumnName = "maGioHang")
    private GioHang gioHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "phanLoai")
    private String phanLoai;

    @Column(name = "thanhTien")
    private double thanhTien;
}
