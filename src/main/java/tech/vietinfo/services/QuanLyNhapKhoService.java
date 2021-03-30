package tech.vietinfo.services;

import jdk.jfr.Name;
import tech.vietinfo.models.ChiTietPhieuNhap;
import tech.vietinfo.models.NhaCungCap;
import tech.vietinfo.models.PhieuNhap;
import tech.vietinfo.models.SanPham;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Name("quanLyNhapKhoService")
public class QuanLyNhapKhoService implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<PhieuNhap> getPhieuNhaps() {
        Query query = entityManager.createQuery("SELECT e FROM PhieuNhap e", PhieuNhap.class);
        return query.getResultList();
    }

    public void addPhieuNhap(PhieuNhap phieuNhap) {
        entityManager.getTransaction().begin();
        entityManager.persist(phieuNhap);
        entityManager.getTransaction().commit();
    }

    public List<ChiTietPhieuNhap> getChiTietPhieuNhaps(int ma){
        String hql = "select sp from ChiTietPhieuNhap sp where sp.phieuNhap.maPhieuNhap = "+ma;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public void addChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
        entityManager.getTransaction().begin();
        entityManager.persist(chiTietPhieuNhap);
        entityManager.getTransaction().commit();
    }

    public void deletePhieuNhap(PhieuNhap phieuNhap){
        entityManager.getTransaction().begin();
        entityManager.remove(phieuNhap);
        entityManager.getTransaction().commit();
    }

    public void deleteChiTietPhieuNhap(int ma){
        entityManager.getTransaction().begin();
        String hql = "delete from ChiTietPhieuNhap sp where sp.phieuNhap.maPhieuNhap = "+ma;
        Query query = entityManager.createQuery(hql);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
