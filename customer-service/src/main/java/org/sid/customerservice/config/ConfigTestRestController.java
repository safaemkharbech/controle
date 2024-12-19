package org.sid.customerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//premier mthode
//deuxieme methode c'est in injectet customerconfigParams testconfig2
@RefreshScope
//indique a spring que le controller va etre instancier a chque fois quand refraichit la config
//actuator va refraichit la config donc automatiquement il doit reinstencier le controller
public class ConfigTestRestController {
    //pour injecter les valeur on utilise value
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Autowired
    private CustomerConfigParams customerConfigParams;
    @GetMapping("/testConfig1")
    public Map<String,String> configTest()
    {
        return Map.of("p1",p1,"p2",p2);
    }

    @GetMapping("/testConfig2")
    public CustomerConfigParams configTest2()
    {
     return customerConfigParams;
    }

}
