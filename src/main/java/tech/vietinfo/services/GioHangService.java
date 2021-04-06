package tech.vietinfo.services;

import tech.vietinfo.models.ChiTietDonHang;
import tech.vietinfo.models.ChiTietGioHang;
import tech.vietinfo.models.DonHang;
import tech.vietinfo.models.GioHang;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Named("gioHangService")
public class GioHangService implements Serializable {
    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Xử lý giỏ hàng
     *
     * @param makh: mã khách hàng
     * @return chuyển đến trang kế tiếp
     */
    public List<GioHang> getGioHangs(int makh) {
        String hql = "select sp from GioHang sp where sp.khachHang.maKhachHang = " + makh;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public void addGioHang(GioHang gioHang) {
        entityManager.getTransaction().begin();
        entityManager.persist(gioHang);
        entityManager.getTransaction().commit();
    }

    public void updateGioHang(GioHang gioHang) {
        entityManager.getTransaction().begin();
        entityManager.merge(gioHang);
        entityManager.getTransaction().commit();
    }

    public void addChiTietGioHang(ChiTietGioHang chiTietGioHang) {
        entityManager.getTransaction().begin();
        entityManager.persist(chiTietGioHang);
        entityManager.getTransaction().commit();
    }

    public void updateChiTietGioHang(ChiTietGioHang chiTietGioHang) {
        entityManager.getTransaction().begin();
        entityManager.merge(chiTietGioHang);
        entityManager.getTransaction().commit();
    }

    public void deleteChiTietGioHang(ChiTietGioHang chiTietGioHang) {
        entityManager.getTransaction().begin();
        entityManager.remove(chiTietGioHang);
        entityManager.getTransaction().commit();
    }

    /**
     * Xử lý thanh toán - tạo hóa đơn cho đơn hàng
     *
     * @return chuyển đến trang kế tiếp
     */
    public List<DonHang> getDonHangs() {
        Query query = entityManager.createQuery("SELECT e FROM DonHang e", DonHang.class);
        return query.getResultList();
    }

    public List<ChiTietDonHang> getChiTietDonHangs(int ma) {
        String hql = "select sp from ChiTietDonHang sp where sp.donHang.maDonDang = " + ma;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public void addDonHang(DonHang donHang) {
        entityManager.getTransaction().begin();
        entityManager.persist(donHang);
        entityManager.getTransaction().commit();
    }

    public void addChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        entityManager.getTransaction().begin();
        entityManager.persist(chiTietDonHang);
        entityManager.getTransaction().commit();
    }

    public void updateDonHang(DonHang donHang) {
        entityManager.getTransaction().begin();
        entityManager.merge(donHang);
        entityManager.getTransaction().commit();
    }

    public void deleteDonHang(DonHang donHang){

    }

    public void deleteChiTietDonHang(ChiTietDonHang chiTietDonHang){

    }

    /**
     * Xử lý lấy thông tin đơn hàng theo khách hàng
     */
    public List<DonHang> getDonHangsByKhachHang(int makh) {
        String hql = "select sp from DonHang sp where sp.khachHang.maKhachHang = " + makh;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public List<ChiTietDonHang> getChiTietDonHangsByDonHang(int ma) {
        String hql = "select sp from ChiTietDonHang sp where sp.donHang.maDonDang = " + ma;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

}
