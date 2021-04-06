package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "SanPham")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maSanPham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSanPham;

    @Column(name = "tenSanPham")
    private String tenSanPham;

    @Column(name = "moTaSanPham")
    private String moTaSanPham;

    @Column(name = "xuatXu")
    private String xuatXu;

    @Column(name = "donGia")
    private double donGia;

    @Column(name = "soLuongCoSan")
    private int soLuongCoSan;

    @Column(name = "hinhAnh")
    private String hinhAnh;

    @Column(name = "trangThai")
    private String trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maDanhMuc", referencedColumnName = "maDanhMuc")
    private DanhMuc danhMuc;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    private List<ChiTietPhieuNhap> chiTietPhieuNhap;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    private List<ChiTietDonHang> chiTietDonHangList;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    private List<ChiTietGioHang> chiTietGioHangList;

    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham=" + maSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", moTaSanPham='" + moTaSanPham + '\'' +
                ", xuatXu='" + xuatXu + '\'' +
                ", donGia=" + donGia +
                ", soLuongCoSan=" + soLuongCoSan +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", danhMuc=" + danhMuc +
                '}';
    }
}
