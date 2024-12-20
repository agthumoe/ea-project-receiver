package edu.miu.cs544.moe.eaprojectreceiver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@OpenAPIDefinition(info = @Info(
        title = "Patient Report Receiver",
        description = "This application receives patient reports from EA Project",
        version = "${app.version}",
        contact = @Contact(name = "Aung Thu Moe", email = "amoe@miu.edu")
))
public class EaProjectReceiverApplication {
    public static void main(String[] args) {
        SpringApplication.run(EaProjectReceiverApplication.class, args);
    }
}
