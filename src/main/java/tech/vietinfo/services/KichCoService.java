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

@Named("kichCoService")
public class KichCoService implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<KichCo> getKichCosByMauSac(int mams) {
        String hql = "select sp from KichCo sp where sp.mauSac.maMau = " + mams;
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public KichCo find(int id) {
        return entityManager.find(KichCo.class, id);
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
}
