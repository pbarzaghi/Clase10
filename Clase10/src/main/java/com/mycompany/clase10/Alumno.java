/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pbarzaghi
 */
public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    
    public Alumno(String nombre,String legajo){
        this.nombre=nombre;
        this.legajo=legajo;
        this.materiasAprobadas= new ArrayList<>();
     }
    
    
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the legajo
     */
    public String getLegajo() {
        return legajo;
    }

    /**
     * @param legajo the legajo to set
     */
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    /**
     * @return the materiasAprobadas
     */
    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    /**
     * @param materiasAprobadas the materiasAprobadas to set
     */
    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }
    
    
    public void agregarMateriaAprobada(Materia materia){
    
       this.materiasAprobadas.add(materia);
    }
    
    public boolean tenesCorrelativa(Materia materia){
        return this.materiasAprobadas.contains(materia);
    }
    
    

    @Override
    public String toString() {
        return this.nombre;
    }

    
    
}
