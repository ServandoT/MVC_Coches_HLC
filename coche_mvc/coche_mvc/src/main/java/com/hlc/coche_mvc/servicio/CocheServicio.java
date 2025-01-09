package com.hlc.coche_mvc.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.repositorio.CocheRepositorio;

@Service
public class CocheServicio {

    @Autowired
    private CocheRepositorio cocheRepositorio;

    public CocheServicio(CocheRepositorio cocheRepositorio) {
        this.cocheRepositorio = cocheRepositorio;
    }

    public Iterable<Coche> listarCoches() {
        return cocheRepositorio.findAll();
    }

    public Coche guardarCoche(Coche coche) {
        return cocheRepositorio.save(coche);
    }

    public Coche obtenerPorId(Long id) {
        return cocheRepositorio.findById(id).orElseThrow(
            () -> new IllegalArgumentException("No se encuentra el coche con id: " + id)
        );
    }

    public void eliminarCoche(Long id) {
        cocheRepositorio.deleteById(id);
    }
}
