package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NhaCungCap")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class NhaCungCap {

    @Id
    @Column(name = "maNhaCungCap")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maNhaCungCap;

    @Column(name = "tenNhaCungCap")
    private String tenNhaCungCap;

    @Column(name = "soDienThoai_NCC")
    private String soDienThoai_NCC;

    @Column(name = "email_NCC")
    private String email_NCC;

    @Column(name = "diaChi_NCC")
    private String diaChi_NCC;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private List<PhieuNhap> phieuNhapList;

}
