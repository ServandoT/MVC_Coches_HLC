package com.hlc.coche_mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.servicio.CocheServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
    @Autowired
    private CocheServicio cocheServicio;

    @PostConstruct
    public void init() {
        if (cocheServicio.listarCoches().iterator().hasNext()) {
            return; // Si ya hay datos no inicializamos los datos en la BBDD
        }

        Coche coche1 = new Coche();
        coche1.setMarca("Mercedes");
        coche1.setMatricula("1234-AAA");
        coche1.setColor("Rojo");
        cocheServicio.guardarCoche(coche1);

        Coche coche2 = new Coche();
        coche2.setMarca("BMW");
        coche2.setMatricula("5678-BBB");
        coche2.setColor("Rojo");
        cocheServicio.guardarCoche(coche2);
    }
}
