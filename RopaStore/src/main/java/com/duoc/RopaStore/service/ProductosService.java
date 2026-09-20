package com.duoc.RopaStore.service;

import com.duoc.RopaStore.exception.ProductoNoEncontradoException;
import com.duoc.RopaStore.model.Productos;
import com.duoc.RopaStore.repository.ProductosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosService {

    private final ProductosRepository repository;

    public ProductosService(ProductosRepository repository) {
        this.repository = repository;
    }

    // Obtenemos todos los productos
    public List<Productos> obtenerProductos() {
        return repository.findAll();
    }

    // Obtenemos productos por orden alfabético
    public List<Productos> ordenarPorNombre() {
        List<Productos> lista = new ArrayList<>(repository.findAll());

        lista.sort((p1, p2) ->
                p1.getNombre().compareToIgnoreCase(p2.getNombre())
        );

        return lista;
    }

    // Buscamos producto por ID
    public Productos obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    // Creamos un nuevo producto
    public Productos guardarProducto(Productos producto) {
        return repository.save(producto);
    }

    // Actualizamos un producto
    public Productos actualizarProducto(Long id, Productos producto) {

        Productos actualizado = repository.update(id, producto);

        if (actualizado == null) {
            throw new ProductoNoEncontradoException(id);
        }

        return actualizado;
    }

    // Eliminamos un producto
    public void eliminarProducto(Long id) {

        boolean eliminado = repository.deleteById(id);

        if (!eliminado) {
            throw new ProductoNoEncontradoException(id);
        }
    }
}