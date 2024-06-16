package com.tesji.apidraftesji.controller;

// Define el acceso a la API por medio de una URL(URI)
// Definir los end-points (peticiones http)

import com.tesji.apidraftesji.model.DatosApiDraft;
import com.tesji.apidraftesji.service.ApiDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.Optional;

@RestController // Expone como un servicio de API REST
@RequestMapping("/api-draftesji")
public class ApiDraftTesji {

    // Inyectar un objeto de SERVICE que tiene las operaciones CRUD
    @Autowired
    ApiDraftService apiDraftService;

    // Definir los end-points
    @GetMapping("/get-prueba")
    public String getPrueba(){
        return "¡FUNCIONA! Bienvenido API DRAFT TESJI";
    }

    @GetMapping("/ver-todosJugadores")
    public ArrayList<DatosApiDraft> verTodosJugadores(){
        return apiDraftService.mostrarTodosJugadores();
    }

    @GetMapping("/ver-jugador/{idjugador}")
    public Optional<DatosApiDraft> verJugador(@PathVariable("idjugador") long id){
        return apiDraftService.mostrarJugadorPorId(id);
    }

    @PostMapping("/registrar-jugador")
    public DatosApiDraft registrarJugador(@RequestBody DatosApiDraft jugador){
        return apiDraftService.registrarJugador(jugador);
    }

    @DeleteMapping("/eliminarJugador/{idjugador}")
    public boolean eliminarJugador(@PathVariable("idjugador") long id){
        return apiDraftService.borrarJugador(id);
    }

    @PutMapping("/actualizar-jugador/{id}")
    public ResponseEntity<DatosApiDraft> actualizarJugador(@PathVariable Long id, @RequestBody DatosApiDraft jugadorActualizado) {
        Optional<DatosApiDraft> jugadorExistente = apiDraftService.mostrarJugadorPorId(id);
        if (jugadorExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar los campos del jugador existente con los nuevos datos
        DatosApiDraft jugadorActualizadoData = jugadorExistente.get();
        jugadorActualizadoData.setNombreJUgador(jugadorActualizado.getNombreJUgador());
        jugadorActualizadoData.setEquipoActual(jugadorActualizado.getEquipoActual());
        jugadorActualizadoData.setCostoCarta(jugadorActualizado.getCostoCarta());

        // Guardar el jugador actualizado
        DatosApiDraft jugadorGuardado = apiDraftService.registrarJugador(jugadorActualizadoData);
        return ResponseEntity.ok(jugadorGuardado);
    }


}
