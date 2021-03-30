package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DonHang")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DonHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maDonHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDonDang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;

    @Column(name = "ngayLapDonHang")
    private Date ngayLapDonHang;

    @Column(name = "thanhTien_DH")
    private double thanhTien_DH;

    @OneToMany(mappedBy = "donHang",fetch = FetchType.LAZY)
    private List<ChiTietDonHang> chiTietDonHangList;

}
