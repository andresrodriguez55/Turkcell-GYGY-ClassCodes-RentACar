package kodlama.io.rentacar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(RentACarApplication.class, args);
	}

	/*
	* Invoice
	* id, carId, modelName, branchName, modelYear, dailyPrice, totalPrice, rentedForDays, rentedAt
	* validation, her alan doldurmalı, 2023 >= modelyear > 1999, ...
	* CRUD */
}
