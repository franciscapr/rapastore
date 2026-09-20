package com.duoc.RopaStore.controller;

import com.duoc.RopaStore.model.Ventas;
import com.duoc.RopaStore.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    //Obtenemos todas las ventas  (http://localhost:8083/ventas)
    @GetMapping
    public List<Ventas> listaVentas() {
        return ventasService.obtenerVentas();
    }


    //Buscamos por codigo de boleta  (http://localhost:8083/ventas/{codigoBoleta})
    @GetMapping("/{codigoBoleta}")
    public Optional<Ventas> buscarPorCodigoBoleta(@PathVariable String codigoBoleta) {
        return ventasService.obtenerPorCodigoBoleta(codigoBoleta);
    }

    //Creamos una nueva venta (http://localhost:8083/ventas)
    @PostMapping
    public Ventas agregarVenta(@RequestBody Ventas venta) {
        return ventasService.guardarVenta(venta);
    }

    //Modificamos una venta  (http://localhost:8083/ventas/{codigoBoleta})
    @PutMapping("/{codigoBoleta}")
    public Ventas editarVenta(@PathVariable String codigoBoleta, @RequestBody Ventas venta) {
        return ventasService.actualizarVenta(codigoBoleta, venta);
    }

    //Eliminamos una venta (http://localhost:8083/ventas/{codigoBoleta})
    @DeleteMapping("/{codigoBoleta}")
    public void eliminarVenta(@PathVariable String codigoBoleta) {
        ventasService.eliminarVenta(codigoBoleta);
    }
}
