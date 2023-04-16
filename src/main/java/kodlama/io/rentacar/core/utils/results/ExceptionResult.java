package kodlama.io.rentacar.core.utils.results;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResult<T extends Exception>
{
    private String type;
    private String message;

    public ExceptionResult(Class<T> type, String message)
    {
        this.type = convertToUpperCaseWithUnderscores(type.getSimpleName());
        this.message = message;
    }

    private String convertToUpperCaseWithUnderscores(String camelCaseString)
    {
        return camelCaseString.replaceAll("(.)(\\p{Upper})", "$1_$2").toUpperCase();
    }
}
