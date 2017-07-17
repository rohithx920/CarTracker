package Project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Rohith on 6/24/2017.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResorceNotFoundException extends RuntimeException {
    public ResorceNotFoundException(String message){
        super(message);
    }

}
