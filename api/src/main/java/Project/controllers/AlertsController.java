package Project.controllers;

import Project.entity.Alerts;
import Project.entity.Readings;
import Project.services.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rohith on 6/29/2017.
 */
@RestController
public class AlertsController {
    @Autowired
    AlertsService alertService;
//    @RequestMapping(method= RequestMethod.GET , value = "/alerts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<Readings> findAll(){
//        //System.out.println("hi");
//        return alertService.findAll();
//    }
//    @RequestMapping(method= RequestMethod.GET , value = "/readings/{vin}")
//    public Readings findOne(@PathVariable("vin") String vin) {
//        return alertService.findOne(vin);
//    }

    public Alerts create(Alerts alerts) {
        Alerts alert =alertService.create(alerts);
        return alert;
    }

    @RequestMapping(method= RequestMethod.GET , value = "/alerts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findAll(){
        return alertService.findAll();
    }
    @RequestMapping(method= RequestMethod.GET , value = "/alerts/{vin}")
    public List<Alerts> findOne(@PathVariable("vin") String vin) {
        return alertService.findOne(vin);
    }
    @RequestMapping(method= RequestMethod.GET , value = "/highalerts/{vin}")
    public List<Alerts> findOneHighAlerts(@PathVariable("vin") String vin) {
        return alertService.findOneHighAlerts(vin);
    }
    @RequestMapping(method= RequestMethod.GET , value = "/alertshigh/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findAllHigh(){
        return alertService.findAllHigh();
    }


}
