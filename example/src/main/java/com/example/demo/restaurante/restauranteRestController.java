package com.example.demo.restaurante;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/restaurante")
@PreAuthorize("hasRole('ADMIN')")
public class restauranteRestController {


    @RequestMapping(method = RequestMethod.GET)
    public String find() {
        return "Restaurante con servicio a domicilio ParaCasa.com \n Escullera Del Port, S/N, 17220 Sant Feliu de Guixols, España \n +34 972 82 26 05";
    }
    
}
