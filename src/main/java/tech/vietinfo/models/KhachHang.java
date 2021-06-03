package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "khachhang")
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
    @Pattern(regexp = "^([\\p{L}]+(\\s)*)+",message = "Vui lòng nhập tên (không chứa ký tự đặc biệt và số)")
    private String tenKhachHang;

    @Column(name = "ngaySinh")
    private String ngaySinh;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "soDienThoai")
    @Pattern(regexp = "^(032|033|034|035|036|037|038|039|056|058|070|076|077|078|079|081|082|083|084|085|088|089|090|091|092|093|094|096|097|098)+([0-9]{7})\\b",message = "Số điện thoại không tồn tại")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "matKhau")
    @Size(min = 4, max = 36, message = "Mật khẩu từ 4 - 36 ký tự")
    private String matKhau;

    @Column(name = "trangThai")
    private String trangThai;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<DonHang> donHangList;

    @OneToOne(mappedBy = "khachHang")
    @ToString.Exclude
    private GioHang gioHang;

}
