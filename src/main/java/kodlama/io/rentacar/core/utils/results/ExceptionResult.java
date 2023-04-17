package kodlama.io.rentacar.core.utils.results;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResult<T>
{
    private LocalDateTime timestamp;
    private String type;
    private String message;

    public ExceptionResult(String type, String message)
    {
        timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }

}
