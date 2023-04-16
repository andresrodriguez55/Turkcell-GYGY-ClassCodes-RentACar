package kodlama.io.rentacar.core.configuration.exceptions;

import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.core.utils.results.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //listener of beans
public class RestExceptionHandler
{
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ExceptionResult<BusinessException> handleBusinessException(BusinessException exception)
    {
        return new ExceptionResult<>(BusinessException.class, exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ExceptionResult<RuntimeException> handleRuntimeException(BusinessException exception)
    {
        return new ExceptionResult<>(RuntimeException.class, exception.getMessage());
    }
}
