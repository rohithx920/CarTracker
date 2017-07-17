package Project.entity;

import javafx.scene.control.Alert;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.UUID;

/**
 * Created by Rohith on 6/29/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name="Alerts.findAll",query="SELECT ale from Alerts ale ORDER BY ale.vin DESC "),
        @NamedQuery(name="Alerts.findHigh",query="SELECT ale from Alerts ale where ale.type=:paramType ORDER BY ale.vin DESC "),
        @NamedQuery(name="Alerts.findOne",query="SELECT ale from Alerts ale WHERE ale.vin=:paramVin"),
        @NamedQuery(name="Alerts.paramOneHigh",query="SELECT ale from Alerts ale WHERE ale.vin=:paramVin AND ale.type=:paramType")

})

public class Alerts {
    @Id
    private String id;
    private String type;
    private String vin;

    private String info;


    public Alerts(){
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }




}
