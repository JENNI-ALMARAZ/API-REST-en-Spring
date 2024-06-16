package com.tesji.apidraftesji.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// JPA utiliza esta clase para convertirla en una tabla en la BD
@Entity
public class DatosApiDraft {
    // DEfinir los atributos (serán los campos de la tabla)
    @Id    // Convirte el atributo a llave primaria (solo afecta a la linea que esta debajo de el)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Es autoincrementable
    private long id;
    private String nombreJUgador;
    private String equipoActual;
    private double costoCarta;

    // Metodos constructores se pueden sobrecargar
    // Puede haber muchos con el mismo nombre pero distintos atributos

    public DatosApiDraft(){

    }

    public DatosApiDraft(String nombreJUgador, String equipoActual, double costoCarta) {
        this.nombreJUgador = nombreJUgador;
        this.equipoActual = equipoActual;
        this.costoCarta = costoCarta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreJUgador() {
        return nombreJUgador;
    }

    public void setNombreJUgador(String nombreJUgador) {
        this.nombreJUgador = nombreJUgador;
    }

    public String getEquipoActual() {
        return equipoActual;
    }

    public void setEquipoActual(String equipoActual) {
        this.equipoActual = equipoActual;
    }

    public double getCostoCarta() {
        return costoCarta;
    }

    public void setCostoCarta(double costoCarta) {
        this.costoCarta = costoCarta;
    }
}
