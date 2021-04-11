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
@ToString
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
    @ToString.Exclude
    private List<ChiTietPhieuNhap> chiTietPhieuNhapList;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ChiTietDonHang> chiTietDonHangList;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ChiTietGioHang> chiTietGioHangList;
}
