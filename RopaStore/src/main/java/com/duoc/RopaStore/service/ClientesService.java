package com.duoc.RopaStore.service;

import com.duoc.RopaStore.model.Clientes;
import com.duoc.RopaStore.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private final ClientesRepository repository;

    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    //Obtenemos todos los clientes
    public List<Clientes> obtenerClientes() {
        return repository.findAll();
    }

    //Obtenemos clientes por orden alfabetico
    public List<Clientes> ordenarPorNombre() {
        List<Clientes> lista = new ArrayList<>(repository.findAll());
        lista.sort((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
        return lista;
    }

    // Buscarmos clientes por ID
    public Optional<Clientes> obtenerPorId(Long id) {
        return repository.findById(id);
    }


    //Creamos un nuevo cliente
    public Clientes guardarCliente(Clientes cliente) {
        return repository.save(cliente);
    }

    // Actualizamos un cliente
    public Clientes actualizarCliente(Long id, Clientes cliente) {
        return repository.update(id, cliente);
    }

    // Eliminamos un cliente
    public boolean eliminarCliente(Long id) {
        return repository.deleteById(id);
    }
}