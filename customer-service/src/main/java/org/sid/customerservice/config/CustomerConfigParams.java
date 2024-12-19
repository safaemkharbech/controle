package org.sid.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//deuxieme methode
@ConfigurationProperties("customer.params")
//pour connaitre annotaion configurationProperties il faut dans le main ajouter une annotation @enableconfigurationProperties(nom_class)
public record CustomerConfigParams(int x , int y) {
}
