package com.duoc.RopaStore.repository;

import com.duoc.RopaStore.model.Productos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductosRepository {

    private final List<Productos> productos = new ArrayList<>();

    public ProductosRepository() {
        productos.add(new Productos(1L, "Polera", "Polera de algodon", 15990));
        productos.add(new Productos(2L, "Jeans", "Pantalón azul elasticado", 29990));
        productos.add(new Productos(3L, "Poleron", "Poleron con capucha y bolsillo delantero", 34990));
        productos.add(new Productos(4L, "Chaqueta", "Chaqueta clasica", 42990));
        productos.add(new Productos(5L, "Camisa Cuadros", "Camisa leñadora manga larga", 19990));
    }

    // Listamos todos los productos
    public List<Productos> findAll() {
        return productos;
    }

    // Buscamos un producto por ID
    public Optional<Productos> findById(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Creamos un producto nuevo
    public Productos save(Productos producto) {

        if (producto.getId() == null) {

            long nuevoId = productos.stream()
                    .mapToLong(Productos::getId)
                    .max()
                    .orElse(0L) + 1L;

            producto.setId(nuevoId);
        }

        productos.add(producto);

        return producto;
    }

    // Actualizamos un producto
    public Productos update(Long id, Productos productoActualizado) {

        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getId().equals(id)) {

                productoActualizado.setId(id);

                productos.set(i, productoActualizado);

                return productoActualizado;
            }
        }

        return null;
    }

    // Eliminamos un producto
    public boolean deleteById(Long id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }
}