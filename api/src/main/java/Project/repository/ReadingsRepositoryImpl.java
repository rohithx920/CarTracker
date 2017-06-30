package Project.repository;

import Project.entity.Readings;
import Project.entity.Tires;
import Project.entity.Vehicles;
import Project.services.ReadingsService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */
@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Readings> findAll() {
        System.out.print("jell");
        TypedQuery<Readings> query = entityManager.createNamedQuery("Readings.findAll", Readings.class);
        List<Readings> resultList=query.getResultList();
        System.out.print("jell");
        return resultList;
        //return null;
    }

    public Readings findOne(String vin) {
        return entityManager.find(Readings.class,vin);
    }

    public Readings create(Readings readings) {
        //System.out.println("99"+vehicles);
        //Tires tires=readings.getTires();
//         System.out.println("************"+readings.getTires().getFrontLeft());
//         Tires tires=new Tires();
//         tires.setVin(readings.getVin());
//         tires.setFrontLeft(readings.getTires().getFrontLeft());
//         tires.setFrontRight(readings.getTires().getFrontRight());
//         tires.setRearLeft(readings.getTires().getRearLeft());
//         tires.setRearRight(readings.getTires().getRearRight());
//         entityManager.persist(tires);
//         readings.setTires(tires);
         entityManager.persist(readings);
        //System.out.println("vehicles");
        return readings;
    }

    public Readings update(Readings readings) {
        return entityManager.merge(readings);
    }

    public void delete(Readings readings) {
        entityManager.remove(readings);

    }
}
