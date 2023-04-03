package kodlama.io.rentacar.business.dto.responses.get;

import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCarsResponse
{
    private int id;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
    private int modelId;

    /*
        isim değişikliği mümkün etmek istersek business layerde ilişkili
        olunan objeye ulaşıp istenilen atributenin değeri ordan alınmalı
    */
    //private String modelName;
    //private String modelBrandName;
}

