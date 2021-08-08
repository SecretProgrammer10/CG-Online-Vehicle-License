package com.capgemini.onlinevehiclelicense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class OnlineVehicleLicenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineVehicleLicenseApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
