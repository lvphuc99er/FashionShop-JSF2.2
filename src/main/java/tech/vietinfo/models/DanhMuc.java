package tech.vietinfo.models;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "DanhMuc")
@Data
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DanhMuc implements Serializable, Comparable<DanhMuc> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maDanhMuc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDanhMuc;

    @Column(name = "tenDanhMuc")
    private String tenDanhmuc;

    @OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY)
    private List<SanPham> sanPhamList;

    @Override
    public int compareTo(@NotNull DanhMuc o) {
        return tenDanhmuc.compareTo(o.tenDanhmuc);
    }

    @Override
    public String toString() {
        return "DanhMuc{" +
                "maDanhMuc=" + maDanhMuc +
                ", tenDanhmuc='" + tenDanhmuc + '\'' +
                '}';
    }
}
