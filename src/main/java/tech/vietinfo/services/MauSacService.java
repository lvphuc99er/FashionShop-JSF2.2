package tech.vietinfo.services;

import tech.vietinfo.models.KichCo;
import tech.vietinfo.models.MauSac;
import tech.vietinfo.models.SanPham;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named("mauSacService")
public class MauSacService implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<MauSac> getMauSacsBySanPham(int masp) {
        String hql = "select sp from MauSac sp where sp.sanPham.maSanPham = " + masp;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public MauSac find(int id) {
        return entityManager.find(MauSac.class, id);
    }

    public void deleteMauSac(MauSac mauSac) {
        entityManager.getTransaction().begin();
        entityManager.remove(mauSac);
        entityManager.getTransaction().commit();
    }

    public void addMauSac(MauSac mauSac) {
        entityManager.getTransaction().begin();
        entityManager.persist(mauSac);
        entityManager.getTransaction().commit();
    }
}
