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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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

    @Column(name = "diaChi_KH")
    private String diaChi_KH;

    @Column(name = "soDienThoai_KH")
    private String soDienThoai_KH;

    @Column(name = "email_KH")
    private String email_KH;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "trangThai")
    private String trangThai;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<DonHang> donHangList;

}
