package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "NhaCungCap")
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
    private String tenNhaCungCap;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "diaChi")
    private String diaChi;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private List<PhieuNhap> phieuNhapList;

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNhaCungCap=" + maNhaCungCap +
                ", tenNhaCungCap='" + tenNhaCungCap + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
