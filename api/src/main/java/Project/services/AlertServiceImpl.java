package Project.services;

import Project.entity.Alerts;
import Project.entity.Readings;
import Project.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Rohith on 6/29/2017.
 */
@Service
public class AlertServiceImpl implements AlertsService{
    @Autowired
    AlertRepository alertRepository;
    @Transactional
    public Alerts create(@RequestBody Alerts alerts) {
        Alerts alert =alertRepository.create(alerts);
        return alert;
    }

    public List<Alerts> findAll(){
        return alertRepository.findAll();
    }

    public List<Alerts> findAllHigh() {
        return alertRepository.findAllHigh();
    }

    public List<Alerts> findOne(String vin) {
        return alertRepository.findOne(vin);
    }
    public List<Alerts> findOneHighAlerts(String vin) {
        return alertRepository.findOne(vin);
    }

}
