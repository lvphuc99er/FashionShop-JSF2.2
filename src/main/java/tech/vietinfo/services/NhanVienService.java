package tech.vietinfo.services;

import tech.vietinfo.models.KhachHang;
import tech.vietinfo.models.NhanVien;
import tech.vietinfo.models.SanPham;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Named("nhanVienService")
public class NhanVienService implements Serializable {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<NhanVien> getNhanViens() {
        Query query = entityManager.createQuery("SELECT e FROM NhanVien e", NhanVien.class);
        return query.getResultList();
    }

    public void addNhanVien(NhanVien nhanVien) {
        entityManager.getTransaction().begin();
        entityManager.persist(nhanVien);
        entityManager.getTransaction().commit();
    }

    public void updateNhanVien(NhanVien nhanVien) {
        entityManager.getTransaction().begin();
        entityManager.merge(nhanVien);
        entityManager.getTransaction().commit();
    }

    public void deleteNhanVien(NhanVien nhanVien) {
        entityManager.getTransaction().begin();
        entityManager.remove(nhanVien);
        entityManager.getTransaction().commit();
    }
}
