package com.musak.business.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

/**
 * Created by musak on 2/5/19.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class ReservationBusinessServicesApplication {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("RoomReservation").select()
				.apis(RequestHandlerSelectors.basePackage("com.musak.business.reservation"))
				.paths(any()).build().apiInfo(new ApiInfo("Room Reservation Services",
						"A set of services to provide business processes for the Room and Reservations domains", "1.0.0", null,
						new Contact("Musak Istvan", "https://twitter.com/musakistvan", null),null, null));
	}

	public static void main(String[] args) {
		SpringApplication.run(ReservationBusinessServicesApplication.class, args);
	}
}
