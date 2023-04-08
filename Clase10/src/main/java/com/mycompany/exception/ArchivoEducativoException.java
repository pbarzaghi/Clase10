/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exception;

import java.io.IOException;

/**
 *
 * @author pbarzaghi
 */
public class ArchivoEducativoException extends IOException{ 
    
     private String mensaje;
    public ArchivoEducativoException(String nombre){
        this.mensaje=nombre;
    }
    
}
