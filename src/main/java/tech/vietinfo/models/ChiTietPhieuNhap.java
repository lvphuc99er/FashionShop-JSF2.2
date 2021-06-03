package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chitietphieunhap")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhap implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maPhieuNhap", referencedColumnName = "maPhieuNhap")
    private PhieuNhap phieuNhap;

    @Id
    @Column(name = "maSanPham")
    private int maSanPham;

    @Column(name = "tenSanPham")
    private String tenSanPham;

    @Column(name = "tenNoiSanXuat")
    private String tenNoiSanXuat;

    @Column(name = "donGia")
    private double donGia;

    @Column(name = "soLuongNhap")
    private int soLuongNhap;

    @Column(name = "thanhTien")
    private double thanhTien;
}
