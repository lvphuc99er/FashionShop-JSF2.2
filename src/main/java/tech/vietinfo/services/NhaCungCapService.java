package tech.vietinfo.services;

import tech.vietinfo.models.KhachHang;
import tech.vietinfo.models.NhaCungCap;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("nhaCungCapService")
public class NhaCungCapService implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<NhaCungCap> getNhaCungCaps() {
        Query query = entityManager.createQuery("SELECT e FROM NhaCungCap e", NhaCungCap.class);
        return query.getResultList();
    }

    public void delete_NCC(NhaCungCap nhaCungCap) {
        entityManager.getTransaction().begin();
        entityManager.remove(nhaCungCap);
        entityManager.getTransaction().commit();
    }

    public void update_NCC(NhaCungCap nhaCungCap) {
        entityManager.getTransaction().begin();
        entityManager.merge(nhaCungCap);
        entityManager.getTransaction().commit();
    }

    public void add_NCC(NhaCungCap nhaCungCap) {
        entityManager.getTransaction().begin();
        entityManager.persist(nhaCungCap);
        entityManager.getTransaction().commit();
    }

    public NhaCungCap find(int id) {
        return entityManager.find(NhaCungCap.class, id);
    }
}
