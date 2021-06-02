package tech.vietinfo.services;

import tech.vietinfo.models.ChiTietDonHang;
import tech.vietinfo.models.DonHang;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Named("donHangService")
public class DonHangService implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<DonHang> getDonHangs() {
        Query query = entityManager.createQuery("SELECT e FROM DonHang e", DonHang.class);
        return query.getResultList();
    }

    public List<ChiTietDonHang> getChiTietDonHangs(int ma) {
        String hql = "select sp from ChiTietDonHang sp where sp.donHang.maDonHang = " + ma;
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
        entityManager.getTransaction().begin();
        entityManager.remove(donHang);
        entityManager.getTransaction().commit();
    }

    public void deleteChiTietDonHang(ChiTietDonHang chiTietDonHang){
        entityManager.getTransaction().begin();
        entityManager.remove(chiTietDonHang);
        entityManager.getTransaction().commit();
    }

    public List<ChiTietDonHang> getChiTietDonHangsByDonHang(int ma) {
        String hql = "select sp from ChiTietDonHang sp where sp.donHang.maDonHang = " + ma;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}
