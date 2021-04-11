package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "GioHang")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GioHang implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maGioHang")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maGioHang;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKhachHang",referencedColumnName = "maKhachHang")

    private KhachHang khachHang;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ChiTietGioHang> chiTietGioHangList;

    @Column(name = "thanhTien")
    private double thanhTien;

}
