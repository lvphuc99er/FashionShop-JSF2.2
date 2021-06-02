package tech.vietinfo.models;

import lombok.*;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MauSac")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MauSac implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maMau")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maMau;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
    private SanPham sanPham;

    @Column(name = "tenMau")
    private String tenMau;

    @Column(name = "soLuong")
    private int soLuong;

    @OneToMany(mappedBy = "mauSac", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<KichCo> kichCoList;
}
