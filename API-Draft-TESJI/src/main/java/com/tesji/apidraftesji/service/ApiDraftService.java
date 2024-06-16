package com.tesji.apidraftesji.service;

import com.tesji.apidraftesji.model.DatosApiDraft;

import java.util.ArrayList;
import java.util.Optional;

// Definir los metodos abstractos para cada end-point (peticiones)
public interface ApiDraftService {

    ArrayList<DatosApiDraft>mostrarTodosJugadores();
    Optional<DatosApiDraft>mostrarJugadorPorId(long id);
    DatosApiDraft registrarJugador(DatosApiDraft jugar); // registra y actualiza
    boolean borrarJugador(long id);

}
