package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "NhanVien")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maNhanVien")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhanVien;

    @Column(name = "tenNhanVien")
    @Pattern(regexp = "^([\\p{L}]+(\\s)*)+",message = "Vui lòng nhập tên (không chứa ký tự đặc biệt và số)")
    private String tenNhanVien;

    @Column(name = "ngaySinh")
    private String ngaySinh;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "soDienThoai")
    @Pattern(regexp = "^(032|033|034|035|036|037|038|039|056|058|070|076|077|078|079|081|082|083|084|085|088|089|090|091|092|093|094|096|097|098)+([0-9]{7})\\b",message = "Số điện thoại không tồn tại")
    private String soDienThoai;

    @Column(name = "email")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",message = "Email có định dạng: nhanvienA@abcxyz.com")
    private String email;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "matKhau")
    @Size(min = 4, max = 36, message = "Mật khẩu từ 8 - 36 ký tự")
    private String matKhau;

    @Column(name = "viTri")
    private String viTri;
}
