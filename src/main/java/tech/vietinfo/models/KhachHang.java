package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "KhachHang")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "gioHang")
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maKhachHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;

    @Column(name = "tenKhachHang")
    private String tenKhachHang;

    @Column(name = "ngaySinh")
    private String ngaySinh;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "trangThai")
    private String trangThai;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<DonHang> donHangList;

    @OneToOne(mappedBy = "khachHang")
    private GioHang gioHang;

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang=" + maKhachHang +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
