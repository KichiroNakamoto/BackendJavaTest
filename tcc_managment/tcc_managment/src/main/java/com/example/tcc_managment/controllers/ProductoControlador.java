package com.example.tcc_managment.controllers;
import com.example.tcc_managment.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tcc_managment.servicios.ProductoServicio;
import static com.example.tcc_managment.controllers.GeneradorCodigoBarras.generarCodigoBarras;
import java.util.Date;

import java.util.List;




@RestController
@RequestMapping("servicioalmacenaje/productos")
public class ProductoControlador {

    @Autowired
    protected ProductoServicio productoServicio;

    @PostMapping
    public ResponseEntity<Producto> registrar(@RequestBody Producto datosARegistrar) {
        try {
            String codigoBarras = generarCodigoBarras(10);
            datosARegistrar.setCodigoBarras(codigoBarras);

            datosARegistrar.setFechaEntrada(new Date());

            Producto productoRegistrado = productoServicio.registrarProducto(datosARegistrar);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productoRegistrado);
        } catch (Exception error) {
            String mensaje = "No se pudo Registrar la mercancia" + error.getMessage();
            Producto productoError = new Producto();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productoError);
        }
    }

    @GetMapping
    public ResponseEntity<List<Producto>> buscarTodos() {
        try {
            List<Producto> productos = productoServicio.buscarTodo();
            return ResponseEntity.status(HttpStatus.OK).body(productos);

        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id) {

        try {
            Producto productoEncontrado = productoServicio.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(productoEncontrado);

        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


    }
}