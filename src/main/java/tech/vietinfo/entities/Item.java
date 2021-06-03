package tech.vietinfo.entities;

import lombok.*;
import tech.vietinfo.models.SanPham;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private SanPham sanPham;
    private int quantity;
//    private String phanLoai;
}
