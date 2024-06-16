package com.tesji.apidraftesji.service;

import com.tesji.apidraftesji.model.DatosApiDraft;
import com.tesji.apidraftesji.repository.CrudApiDraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class ApiDraftServiceImplementar implements ApiDraftService{
    // Inyectar un objeto de la clase Repository que tiene las operaciones CRUD

    @Autowired  // Ya no se necesita instanciar
    CrudApiDraftRepository crudApiDraftRepository;

    @Override
    public ArrayList<DatosApiDraft> mostrarTodosJugadores() {
        return (ArrayList<DatosApiDraft>)crudApiDraftRepository.findAll();
    }

    @Override
    public Optional<DatosApiDraft> mostrarJugadorPorId(long id) {
        return crudApiDraftRepository.findById(id);
    }

    @Override
    public DatosApiDraft registrarJugador(DatosApiDraft jugar) {
        return crudApiDraftRepository.save(jugar);
    }

    public DatosApiDraft actualizarJugador(DatosApiDraft jugador) {
        return crudApiDraftRepository.save(jugador);
    }

    @Override
    public boolean borrarJugador(long id) {
        // Buscamos jugador
        try {
            Optional<DatosApiDraft> jugador = mostrarJugadorPorId(id);
            crudApiDraftRepository.delete(jugador.get());
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
