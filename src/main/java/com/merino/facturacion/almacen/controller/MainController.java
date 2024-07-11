package com.merino.facturacion.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/categorias") // www.localhost:8080/categorias
    public String getCategorias(Model model) {
        // Aquí podrías agregar lógica para cargar datos de categorías al modelo, si es necesario
        return "categoria"; // Devuelve el nombre de la vista (plantilla Thymeleaf) para categorías
    }
    
    @GetMapping("/clientes") // www.localhost:8080/clientes
    public String getClientes(Model model) {
        // Aquí podrías agregar lógica para cargar datos de clientes al modelo, si es necesario
        return "cliente"; // Devuelve el nombre de la vista (plantilla Thymeleaf) para clientes
    }
    
    @GetMapping("/pagos") // www.localhost:8080/pagos
    public String getPagos(Model model) {
        // Aquí podrías agregar lógica para cargar datos de pagos al modelo, si es necesario
        return "pago"; // Devuelve el nombre de la vista (plantilla Thymeleaf) para pagos
    }
}

