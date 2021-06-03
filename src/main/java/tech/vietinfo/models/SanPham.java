package tech.vietinfo.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sanpham")
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
    @Pattern(regexp = "^([\\p{L}0-9]+(\\s)*)+",message = "Nhập tên không chứa ký tự đặc biệt")
    private String tenSanPham;

    @Column(name = "moTaSanPham")
    @Length(max = 10000)
    private String moTaSanPham;

    @Column(name = "tenNoiSanXuat")
    private String tenNoiSanXuat;

    @Column(name = "donGia")
    @Min(value = 1000, message = "Đơn giá nhỏ nhất là 1.000 VNĐ")
    private double donGia;

    @Column(name = "soLuongCoSan")
    private int soLuongCoSan;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "tenLoaiSanPham")
    private String tenLoaiSanPham;

    @Column(name = "loai")
    private String loai;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ChiTietGioHang> chiTietGioHangList;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<MauSac> mauSacList;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<HinhAnh> hinhAnhList;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<DanhGia> danhGiaList;
}
