package Project.repository;

import Project.entity.Alerts;
import Project.entity.Readings;
import Project.entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rohith on 6/29/2017.
 */
@Repository
public class AlertRepositoryImpl implements AlertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Alerts create(Alerts alerts) {
        entityManager.persist(alerts);
        return alerts;
    }
    public List<Alerts> findAll(){
        TypedQuery<Alerts> query = entityManager.createNamedQuery("Alerts.findAll", Alerts.class);
        List<Alerts> resultList=query.getResultList();
        return resultList;

    }
    public List<Alerts> findOne(String vin) {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("Alerts.findOne", Alerts.class);
        query.setParameter("paramVin",vin);
        List<Alerts> resultList=query.getResultList();
        return resultList;
    }
    public List<Alerts> findOneHighAlerts(String vin) {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("Alerts.findOneHighAlerts", Alerts.class);
        query.setParameter("paramOneHigh",vin);
        List<Alerts> resultList=query.getResultList();
        return resultList;
    }
    public List<Alerts>findAllHigh(){
        TypedQuery<Alerts> query = entityManager.createNamedQuery("Alerts.findHigh", Alerts.class);
        query.setParameter("paramType","HIGH");
        List<Alerts> resultList=query.getResultList();
        return resultList;
    }
}
