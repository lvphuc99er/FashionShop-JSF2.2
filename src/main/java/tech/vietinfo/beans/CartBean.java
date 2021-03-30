package tech.vietinfo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.vietinfo.entities.Item;
import tech.vietinfo.models.SanPham;
import tech.vietinfo.services.SanPhamService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("cartBean")
@SessionScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SanPhamService sanPhamService;

    private List<Item> items = new ArrayList<>();
    private Item item;

    /**
     *
     */
    @PostConstruct
    public void init() {
        item = new Item();
    }

    public List<Item> addToCart(SanPham sanPham) {
        int index = exists(sanPham);
        if (index == -1) {
            items.add(new Item(sanPham, 1));
        } else {
            int quantity = items.get(index).getQuantity() + 1;
            items.get(index).setQuantity(quantity);
        }
        return items;
    }

    public void delete(SanPham sanPham) {
        int index = exists(sanPham);
        items.remove(index);
    }

    public double total() {
        double s = 0;
        for (Item item : items) {
            s += item.getSanPham().getDonGia() * item.getQuantity();
        }
        return s;
    }

    public int exists(SanPham sanPham) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getSanPham().getMaSanPham() == sanPham.getMaSanPham()) {
                return i;
            }
        }
        return -1;
    }

    public int checkSoLuong() {
        if(items.size()==0)
            return 0;
        else
            return 1;
    }

    public String nextPageCart() {
        return "shoppingcart?faces-redirect=true&includeViewParams=true";
    }
    public String nextPagePay() {
        return "pay?faces-redirect=true&includeViewParams=true";
    }

}
