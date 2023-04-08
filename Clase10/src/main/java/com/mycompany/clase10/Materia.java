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
public class Materia {
    private int id;
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre){
    
      this.nombre=nombre;
      this.correlativas=new ArrayList();
    
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
     * @return the correlativas
     */
    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    /**
     * @param correlativas the correlativas to set
     */
    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    boolean puedeCursar(Alumno alumno) {
        return this.correlativas.stream().allMatch(correlativa -> alumno.tenesCorrelativa(correlativa) );
  }
    
    public boolean tenesCorrelativa(){
         return ! this.correlativas.isEmpty();
    }
    
   

    @Override
    public String toString() {
        return this.nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
 public void agregarMateriaCorrelativa(Materia materia){
    
       this.correlativas.add(materia);
    }
    
    
}
