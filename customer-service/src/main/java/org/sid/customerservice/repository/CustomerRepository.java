package org.sid.customerservice.repository;

import lombok.extern.java.Log;
import org.sid.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//spring data fair reference repoository pour gerer l'acces au donner
//annotation est suffisant pour mettre en place un web service restfull qui ^permet de gerer les produits
@RepositoryRestResource

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
