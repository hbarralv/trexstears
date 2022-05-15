package com.example.demo.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminRestController {


    @RequestMapping(method = RequestMethod.GET)
    public String find() {
        return "Este recurso esta protegido para administradores de la aplicación ParaCasa.com";
    }
    
}

