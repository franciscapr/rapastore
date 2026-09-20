package com.duoc.RopaStore.controller;



import com.duoc.RopaStore.model.Sucursal;
import com.duoc.RopaStore.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    //Obtenemos todas las surcusales
    @GetMapping
    public List<Sucursal> listaSucursal(){
        return sucursalService.obtenerSucursales();

    }

    //Obtenemos sucursales ordenadas
    @GetMapping("/ordenadas")
    public List<Sucursal> listaSucursalOrdenadas(){
        return sucursalService.ordenarPorNombre();

    }

    //Buscamos por ID -> http://localhost:8083/sucursales/{id}
    @GetMapping("/{id}")
    public Optional<Sucursal> buscarPorId(@PathVariable Long id) {
        return sucursalService.obtenerPorId(id);
    }

    //Creamos nueva sucursal -> http://localhost:8083/sucursales
    @PostMapping
    public Sucursal agregarSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.guardarSucursal(sucursal);
    }

    //Modificamos una sucursal -> http://localhost:8083/sucursales/{id}
    @PutMapping("/{id}")
    public Sucursal editarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        return sucursalService.actualizarSucursal(id, sucursal);
    }

    //Eliminamos una sucursal
    @DeleteMapping("/{id}")
    public void eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }

}
