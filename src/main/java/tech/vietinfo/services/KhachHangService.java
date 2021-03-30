package tech.vietinfo.services;

import tech.vietinfo.models.KhachHang;
import tech.vietinfo.models.NhaCungCap;
import tech.vietinfo.models.SanPham;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Named("khacHangService")
public class KhachHangService implements Serializable {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<KhachHang> getKhachHangs() {
        Query query = entityManager.createQuery("SELECT e FROM KhachHang e", KhachHang.class);
        return query.getResultList();
    }

    public void addKhachHang(KhachHang khachHang) {
        entityManager.getTransaction().begin();
        entityManager.persist(khachHang);
        entityManager.getTransaction().commit();
    }

    public void updateKhachHang(KhachHang khachHang) {
        entityManager.getTransaction().begin();
        entityManager.merge(khachHang);
        entityManager.getTransaction().commit();
    }

    public KhachHang find(int id){
        return entityManager.find(KhachHang.class,id);
    }

    public List<KhachHang> getSanPhamsBySDT(String sdt){
        String hql = "select kh from KhachHang kh where kh.soDienThoai_KH = '"+sdt+"'";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}
