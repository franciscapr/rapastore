package com.duoc.RopaStore.controller;

import com.duoc.RopaStore.model.Clientes;
import com.duoc.RopaStore.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    //Obtenemos todos los clientes (http://localhost:8083/clientes)
    @GetMapping
    public List<Clientes> listaClientes() {
        return clientesService.obtenerClientes();
    }

    //Obtenemos clientes ordenados  (http://localhost:8083/clientes/ordenadas)
    @GetMapping("/ordenadas")
    public List<Clientes> listaClientesOrdenados() {
        return clientesService.ordenarPorNombre();
    }

    //Buscamos por ID (http://localhost:8083/clientes/{id})
    @GetMapping("/{id}")
    public Optional<Clientes> buscarPorId(@PathVariable Long id) {
        return clientesService.obtenerPorId(id);
    }

    //Creamos un nuevo cliente (http://localhost:8083/clientes)
    @PostMapping
    public Clientes agregarCliente(@RequestBody Clientes cliente) {
        return clientesService.guardarCliente(cliente);
    }

    //Modificamos un cliente (http://localhost:8083/clientes/{id})
    @PutMapping("/{id}")
    public Clientes editarCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        return clientesService.actualizarCliente(id, cliente);
    }

    //Eliminamos una cliente (http://localhost:8083/clientes/{id})
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clientesService.eliminarCliente(id);
    }
}