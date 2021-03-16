package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ChiTietDonHang")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ChiTietDonHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maDonHang", referencedColumnName = "maDonHang")
    private DonHang donHang;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham_DH;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "donGia")
    private double donGia;

    @Column(name = "thanhTien_SP")
    private double thanhTien_SP;

}
