package tech.vietinfo.services;

import tech.vietinfo.models.*;

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

    public List<HinhAnh> getHinhAnhsBySanPham(int masp) {
        String hql = "select ha from HinhAnh ha where ha.sanPham.maSanPham =" + masp ;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public List<DanhGia> getDanhGiasBySanPham(int masp) {
        String hql = "select ha from DanhGia ha where ha.sanPham.maSanPham =" + masp ;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
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

    public void deleteSanPham(SanPham sanPham) {
        entityManager.getTransaction().begin();
        entityManager.remove(sanPham);
        entityManager.getTransaction().commit();
    }

    public void addDanhGia(DanhGia danhGia) {
        entityManager.getTransaction().begin();
        entityManager.persist(danhGia);
        entityManager.getTransaction().commit();
    }

    public void deleteDanhGia(DanhGia danhGia) {
        entityManager.getTransaction().begin();
        entityManager.remove(danhGia);
        entityManager.getTransaction().commit();
    }

    public SanPham find(int id) {
        return entityManager.find(SanPham.class, id);
    }

    public void deleteKichCo(KichCo kichCo) {
        entityManager.getTransaction().begin();
        entityManager.remove(kichCo);
        entityManager.getTransaction().commit();
    }

    public void addKichCo(KichCo kichCo) {
        entityManager.getTransaction().begin();
        entityManager.persist(kichCo);
        entityManager.getTransaction().commit();
    }

    public void addHinhAnh(HinhAnh hinhAnh) {
        entityManager.getTransaction().begin();
        entityManager.persist(hinhAnh);
        entityManager.getTransaction().commit();
    }
}
