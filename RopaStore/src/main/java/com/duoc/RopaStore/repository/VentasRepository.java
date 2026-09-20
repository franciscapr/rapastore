package com.duoc.RopaStore.repository;

import com.duoc.RopaStore.model.Ventas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VentasRepository {

    private final List<Ventas> ventas = new ArrayList<>();

    public VentasRepository() {
        ventas.add(new Ventas("BOL-1001", "2026-09-10", 45980, 1L, 1L));
        ventas.add(new Ventas("BOL-1002", "2026-09-10", 29990, 2L, 2L));
        ventas.add(new Ventas("BOL-1003", "2026-09-11", 54980, 3L, 3L));
        ventas.add(new Ventas("BOL-1004", "2026-09-11", 19990, 4L, 1L));
        ventas.add(new Ventas("BOL-1005", "2026-09-12", 72980, 5L, 4L));
    }

    //Listamos todas las ventas
    public List<Ventas> findAll() {
        return ventas;
    }

    //Buscamos por código de boleta
    public Optional<Ventas> findByCodigoBoleta(String codigoBoleta) {
        return ventas.stream()
                .filter(v -> v.getCodigoBoleta().equalsIgnoreCase(codigoBoleta))
                .findFirst();
    }

    //Creamos una venta nuevo (POST)
    public Ventas save(Ventas venta) {
        ventas.add(venta);
        return venta;
    }

    //Actualizamos una venta (PUT)
    public Ventas update(String codigoBoleta, Ventas ventaActualizada) {
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getCodigoBoleta().equalsIgnoreCase(codigoBoleta)) {
                ventaActualizada.setCodigoBoleta(codigoBoleta);
                ventas.set(i, ventaActualizada);
                return ventaActualizada;
            }
        }
        return null;
    }

    //Eliminamos una venta (DELETE)
    public boolean deleteByCodigoBoleta(String codigoBoleta) {
        return ventas.removeIf(v -> v.getCodigoBoleta().equalsIgnoreCase(codigoBoleta));
    }
}