package tech.vietinfo.services;

import tech.vietinfo.models.DanhMuc;
import tech.vietinfo.models.SanPham;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named("danhMucService")
public class DanhMucService implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fashionshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<DanhMuc> getDanhMucs() {
        Query query = entityManager.createQuery("SELECT e FROM DanhMuc e", DanhMuc.class);
        return query.getResultList();
    }
    public DanhMuc find(int id) {
        return entityManager.find(DanhMuc.class, id);
    }

    private Map<Integer, DanhMuc> danhMucsAsMap;

    public Map<Integer, DanhMuc> getDanhMucsAsMap() {
        if (danhMucsAsMap == null) {
            danhMucsAsMap = getDanhMucs().stream().collect(Collectors.toMap(DanhMuc::getMaDanhMuc, danhMuc -> danhMuc));
        }
        return danhMucsAsMap;
    }
}
