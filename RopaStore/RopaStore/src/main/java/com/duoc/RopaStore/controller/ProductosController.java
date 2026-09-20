package com.duoc.RopaStore.controller;

import com.duoc.RopaStore.model.Productos;
import com.duoc.RopaStore.service.ProductosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Productos> listaProductos() {
        return productosService.obtenerProductos();
    }

    @GetMapping("/ordenados")
    public List<Productos> listaProductosOrdenados() {
        return productosService.ordenarPorNombre();
    }

    @GetMapping("/{id}")
    public Productos buscarPorId(@PathVariable Long id) {
        return productosService.obtenerPorId(id);
    }

    @PostMapping
    public Productos agregarProducto(@RequestBody Productos producto) {
        return productosService.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public Productos editarProducto(
            @PathVariable Long id,
            @RequestBody Productos producto) {

        return productosService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productosService.eliminarProducto(id);
    }
}