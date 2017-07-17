package Project.entity.Priority;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by Rohith on 6/28/2017.
 */
//@Entity
public class High {
   // @Id
    private String id;
    private String engineRpm;
    private String readLineRpm;

    public High(){
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(String engineRpm) {
        this.engineRpm = engineRpm;
    }

    public String getReadLineRpm() {
        return readLineRpm;
    }

    public void setReadLineRpm(String readLineRpm) {
        this.readLineRpm = readLineRpm;
    }
}
