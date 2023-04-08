/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exception;

/**
 *
 * @author pbarzaghi
 */
public class AlumnoNoExisteException extends RuntimeException {
    
    private String mensaje;
    public AlumnoNoExisteException(String nombre){
     this.mensaje=nombre;
   }
    
}
