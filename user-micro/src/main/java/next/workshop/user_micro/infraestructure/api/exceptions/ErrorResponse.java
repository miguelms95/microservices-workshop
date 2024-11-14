package next.workshop.user_micro.infraestructure.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse extends RuntimeException {
    private String errorCode;
    private String message;
}
