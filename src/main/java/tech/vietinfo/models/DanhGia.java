package tech.vietinfo.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "DanhGia")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhGia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "maDanhGia")
    private int maDanhGia;

    @Column(name = "noiDung")
    @Length(max = 10000)
    private String noiDung;

    @Column(name = "sao")
    @Min(value = 1, message = "Chọn sao")
    private int sao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    @Column(name = "tenKhachHang")
    private String tenKhachHang;

    @Column(name = "thoiGian")
    private String thoiGian;

}
