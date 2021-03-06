package greatlirik.training.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private int StatusCode;
    private Date timestamp;
    private String message;
    private String description;

}
