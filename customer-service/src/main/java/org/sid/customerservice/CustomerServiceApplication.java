package org.sid.customerservice;

import org.sid.customerservice.config.CustomerConfigParams;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    //chaque methode qui utilise  annotation bean cest une methode qui va s'executer au demarrage c-a-d il va retourner un boject de type comandelinnerunner
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration restConfiguration)
    {
        return  args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Safae").email("Safae@gmail.com").build(),
                            Customer.builder().name("Hatim").email("Hatim@gmail.com").build(),
                            Customer.builder().name("Sabrine").email("Sabrine@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(
                    customer -> System.out.println(customer)
            );


        };

    }
}
