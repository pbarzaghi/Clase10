/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase10;

import java.time.LocalDate;

/**
 *
 * @author pbarzahi
 */
public class Inscripcion {
    private Alumno alunmo;
    private Materia materia;
    private LocalDate fecha;
    
    
    public Inscripcion(Alumno alumno,Materia materia){
            this.alunmo=alumno;
            this.materia=materia;
            this.fecha=LocalDate.now();
    }
    

    /**
     * @return the alunmo
     */
    public Alumno getAlunmo() {
        return alunmo;
    }

    /**
     * @param alunmo the alunmo to set
     */
    public void setAlunmo(Alumno alunmo) {
        this.alunmo = alunmo;
    }

    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
       
    
    public boolean aprobada(){
        return ! this.materia.tenesCorrelativa()||
                this.materia.puedeCursar(alunmo);
    
    
    
    }
    
    public String leyendaEstado() {
        if (alunmo.getLegajo()== null)
            return "No existe el/la alumno/a";
        return this.aprobada()? "Aprobada" : "Rechazada";
    }

    
}
