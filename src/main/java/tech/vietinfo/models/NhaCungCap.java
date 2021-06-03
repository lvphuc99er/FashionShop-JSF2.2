package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "nhacungcap")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap implements Serializable {

    @Id
    @Column(name = "maNhaCungCap")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maNhaCungCap;

    @Column(name = "tenNhaCungCap")
    @Pattern(regexp = "^([\\p{L}0-9]+(\\s)*)+",message = "Vui lòng nhập tên (không chứa ký tự đặc biệt)")
    private String tenNhaCungCap;

    @Column(name = "soDienThoai")
    @Pattern(regexp = "^(032|033|034|035|036|037|038|039|056|058|070|076|077|078|079|081|082|083|084|085|088|089|090|091|092|093|094|096|097|098)+([0-9]{7})\\b",message = "Số điện thoại không tồn tại")
    private String soDienThoai;

    @Column(name = "email")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",message = "Email có định dạng: congtyA@abcxyz.com")
    private String email;

    @Column(name = "diaChi")
    @Pattern(regexp = "^([\\p{L}0-9,.+-]+(\\s)*)+",message = "Vui lòng nhập địa chỉ (không chứa ký tự đặc biệt)")
    private String diaChi;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private List<PhieuNhap> phieuNhapList;
}
