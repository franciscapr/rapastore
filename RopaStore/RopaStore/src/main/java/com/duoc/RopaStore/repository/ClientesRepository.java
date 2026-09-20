package com.duoc.RopaStore.repository;

import com.duoc.RopaStore.model.Clientes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientesRepository {

    private final List<Clientes> clientes = new ArrayList<>();

    public ClientesRepository() {
        clientes.add(new Clientes(1L, "Carlos", "Soto", "carlos.soto@gmail.com", "28"));
        clientes.add(new Clientes(2L, "Camila", "Silva", "camila.silva@gmail.com", "24"));
        clientes.add(new Clientes(3L, "Andres", "Muñoz", "andres.munoz@gmail.com", "30"));
        clientes.add(new Clientes(4L, "Valentina", "Rojas", "valentina.rojas@gmail.com", "22"));
        clientes.add(new Clientes(5L, "Matias", "Castro", "matias.castro@gmail.com", "35"));
    }

    //Listamos todos
    public List<Clientes> findAll() {
        return clientes;
    }

    //Buscamos por ID
    public Optional<Clientes> findById(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    //Creamos un cliente nuevo (POST)
    public Clientes save(Clientes cliente) {
        if (cliente.getId() == null) {
            long nuevoId = clientes.stream()
                    .mapToLong(Clientes::getId)
                    .max()
                    .orElse(0L) + 1L;
            cliente.setId(nuevoId);
        }
        clientes.add(cliente);
        return cliente;
    }

    //Actualizamos un cliente (PUT)
    public Clientes update(Long id, Clientes clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                clienteActualizado.setId(id);
                clientes.set(i, clienteActualizado);
                return clienteActualizado;
            }
        }
        return null;
    }

    //Eliminamos un cliente (DELETE)
    public boolean deleteById(Long id) {
        return clientes.removeIf(c -> c.getId().equals(id));
    }
}