package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HinhAnh")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HinhAnh implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maHinhAnh")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maHinhAnh;

    @Column(name = "tenHinhAnh")
    private String tenHinhAnh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;
}
