package com.springlesson.clinicadmin;


import com.springlesson.clinicadmin.examples.profils.SettingsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SettingsService.class)
public class ClinicAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicAdminApplication.class, args);
    }

}
