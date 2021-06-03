package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "phieunhap")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PhieuNhap implements Serializable {

    @Id
    @Column(name = "maPhieuNhap")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maPhieuNhap;

    @Column(name = "ngayLapPhieu")
    @NotBlank(message = "Chọn ngày lập phiếu")
    private String ngayLapPhieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maNhaCungCap",referencedColumnName = "maNhaCungCap")
    private NhaCungCap nhaCungCap;

    @Column(name = "tenNhanVien")
    private String tenNhanVien;

    @Column(name = "thanhTien")
    private double thanhTien;

    @OneToMany(mappedBy = "phieuNhap", fetch = FetchType.LAZY)
    private List<ChiTietPhieuNhap> chiTietPhieuNhapList;

}
