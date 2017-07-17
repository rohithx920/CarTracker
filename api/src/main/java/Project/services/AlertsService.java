package Project.services;

import Project.entity.Alerts;

import java.util.List;

/**
 * Created by Rohith on 6/29/2017.
 */
public interface AlertsService {
    public Alerts create(Alerts alerts);
    public List<Alerts> findAll();
    public List<Alerts> findAllHigh();
    public List<Alerts> findOne(String vin);
    public List<Alerts> findOneHighAlerts(String vin);

}
