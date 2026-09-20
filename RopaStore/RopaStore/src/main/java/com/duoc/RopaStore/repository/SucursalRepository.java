package com.duoc.RopaStore.repository;


import com.duoc.RopaStore.model.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SucursalRepository {

    private final List<Sucursal> sucursales = new ArrayList<>();

    public SucursalRepository() {
        sucursales.add(new Sucursal ( 1L, "Lira Store", "lira 333", "+56999999999", 40));
        sucursales.add(new Sucursal(2L, "Costanera Store", "Av. Andrés Bello 2425", "+56992223333", 85));
        sucursales.add(new Sucursal(3L, "Parque Arauco Store", "Av. Kennedy 5413", "+56993334444", 60));
        sucursales.add(new Sucursal(4L, "Plaza Vespucio Store", "Vicuña Mackenna 7110", "+56994445555", 70));
        sucursales.add(new Sucursal(5L, "Plaza Oeste Store", "Américo Vespucio 1501", "+56995556666", 50));

    }


    //Listamos todos
    public List<Sucursal> findAll() {
        return sucursales;
    }

    //Buscamos por ID
    public Optional<Sucursal> findById(Long id) {
        return sucursales.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    // Creamos una sucursal nueva (POST)
    public Sucursal save(Sucursal sucursal) {
        if (sucursal.getId() == null) {
            long nuevoId = sucursales.stream()
                    .mapToLong(Sucursal::getId)
                    .max()
                    .orElse(0L) + 1L;
            sucursal.setId(nuevoId);
        }
        sucursales.add(sucursal);
        return sucursal;
    }

    // Actualizamos una sucursal (PUT)
    public Sucursal update(Long id, Sucursal sucursalActualizada) {
        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i).getId().equals(id)) {
                sucursalActualizada.setId(id);
                sucursales.set(i, sucursalActualizada);
                return sucursalActualizada;
            }
        }
        return null;
    }

    // Eliminamos una sucursal (DELETE)
    public boolean deleteById(Long id) {
        return sucursales.removeIf(s -> s.getId().equals(id));
    }


}
