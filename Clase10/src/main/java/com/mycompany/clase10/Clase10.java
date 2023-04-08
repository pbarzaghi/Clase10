/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase10;

import com.mycompany.exception.AlumnoNoExisteException;
import com.mycompany.exception.ArchivoEducativoException;
import com.mycompany.exception.MateriaNoExisteException;
import com.mycompany.file.CargarArchivo;
import java.util.List;

/**
 *
 * @author pbarzaghi
 */
public class Clase10 {

    public static void main(String[] args) {
     
        
        try {
            CargarArchivo file=new CargarArchivo();
            List<Inscripcion> inscripciones=  file.getInscripciones( args[0],args[1],args[2]);
            
            for (Inscripcion inscripcion : inscripciones) {
                //if( inscripcion.aprobada())
                       System.out.println(inscripcion.getAlunmo().toString()+" " +inscripcion.getMateria().toString() +" "+inscripcion.leyendaEstado());
            }
            
        } catch (MateriaNoExisteException ex) {
            System.err.println("MATERIAS"+ ex.toString());
        } catch (AlumnoNoExisteException ex) {
              System.err.println("ALUMNOS"+ ex.toString());
        } catch (ArchivoEducativoException ex) {
            System.err.println(" NO SE "+ex.getMessage());
        }
    }
}
