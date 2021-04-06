package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ChiTietPhieuNhap")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhap implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maPhieuNhap", referencedColumnName = "maPhieuNhap")
    private PhieuNhap phieuNhap;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    @Column(name = "soLuongNhap")
    private int soLuongNhap;

    @Column(name = "thanhTien")
    private double thanhTien;
}
