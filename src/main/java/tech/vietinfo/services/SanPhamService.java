package tech.vietinfo.services;

import tech.vietinfo.models.SanPham;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Named("sanPhamService")
public class SanPhamService implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<SanPham> getSanPhams() {
        Query query = entityManager.createQuery("SELECT e FROM SanPham e", SanPham.class);
        return query.getResultList();
    }

    public List<SanPham> getSanPhamsByDanhMuc(int ma){
        String hql = "select sp from SanPham sp where sp.danhMuc.maDanhMuc = "+ma;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public void deleteSanPham(SanPham sanPham) {
        entityManager.getTransaction().begin();
        entityManager.remove(sanPham);
        entityManager.getTransaction().commit();
    }

    public void updateSanPham(SanPham sanPham) {
        entityManager.getTransaction().begin();
        entityManager.merge(sanPham);
        entityManager.getTransaction().commit();
    }

    public void addSanPham(SanPham sanPham) {
        entityManager.getTransaction().begin();
        entityManager.persist(sanPham);
        entityManager.getTransaction().commit();
    }

    public SanPham find(int id) {
        return entityManager.find(SanPham.class, id);
    }
}
