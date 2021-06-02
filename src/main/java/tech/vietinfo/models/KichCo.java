package tech.vietinfo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KichCo")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KichCo implements Serializable {

    @Id
    @Column(name = "maKichCo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int maKichCo;

    @Column(name = "tenKichCo")
    private String tenKichCo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maMau", referencedColumnName = "maMau")
    private MauSac mauSac;

    @Column(name = "soLuong")
    private int soLuong;

}
