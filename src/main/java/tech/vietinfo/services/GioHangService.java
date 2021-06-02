package tech.vietinfo.services;

import tech.vietinfo.models.*;

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

    public List<ChiTietGioHang> getChiTietGioHangs(int magh) {
        String hql = "select sp from ChiTietGioHang sp where sp.gioHang.maGioHang = " + magh;
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
}
