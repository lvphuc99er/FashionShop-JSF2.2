package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PhieuNhap")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class PhieuNhap implements Serializable {

    @Id
    @Column(name = "maPhieuNhap")
    private int maPhieuNhap;

    @Column(name = "ngayLapPhieu")
    private Date ngayLapPhieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maNhaCungCap",referencedColumnName = "maNhaCungCap")
    private NhaCungCap nhaCungCap;

    @Column(name = "thanhTien_PN")
    private double thanhTien_PN;

    @OneToMany(mappedBy = "phieuNhap", fetch = FetchType.LAZY)
    private List<ChiTietPhieuNhap> chiTietPhieuNhapList;

}
