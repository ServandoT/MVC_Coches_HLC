package com.hlc.coche_mvc.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.servicio.CocheServicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class CocheControlador {

    @Autowired
    CocheServicio cocheServicio;

    @GetMapping("/")
    public String listarProductos(Model model) {
        model.addAttribute("coches", cocheServicio.listarCoches());
        return "index";
    }
    
    @GetMapping("/coche/nuevo")
    public String mostrarFormularioNuevoCoche(Model model) {
        Coche coche = new Coche();
        model.addAttribute("coche", coche);
        return "coche-form";
    }

    @GetMapping("coche/editar/{id}")
    public String mostrarFormularioEditarCoche(@PathVariable Long id, Model model) {
        Coche coche = cocheServicio.obtenerPorId(id);
        model.addAttribute("coche", coche);
        return "coche-form";
    }

    @PostMapping("/coche")
    public String guardarCoche(@ModelAttribute Coche coche) {
        cocheServicio.guardarCoche(coche);
        return "redirect:/";
    }
    
    @GetMapping("/coche/eliminar/{id}")
    public String getMethodName(@PathVariable Long id) {
        cocheServicio.eliminarCoche(id);
        return "redirect:/";
    }
    
}
