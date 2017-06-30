package Project.repository;

import Project.entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */

@Repository
public class VehiclesRepositoryImpl implements VehiclesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicles> findAll() {
        System.out.print("jell");
        TypedQuery<Vehicles> query = entityManager.createNamedQuery("Vehicles.findAll", Vehicles.class);
        List<Vehicles> resultList=query.getResultList();
        System.out.print("jell");
        return resultList;
        //return null;
    }

    public Vehicles findOne(String vin) {
        return entityManager.find(Vehicles.class,vin);
    }

    public Vehicles create(Vehicles vehicles) {
        System.out.println("99"+vehicles);
        entityManager.persist(vehicles);
        System.out.println("vehicles");
        return vehicles;
    }

    public Vehicles update(Vehicles vehicles) {
        return entityManager.merge(vehicles);
    }

    public void delete(Vehicles vehicles) {
        entityManager.remove(vehicles);

    }
}
