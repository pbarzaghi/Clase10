/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.file;

import com.mycompany.clase10.Alumno;
import com.mycompany.clase10.Inscripcion;
import com.mycompany.clase10.Materia;
import com.mycompany.exception.AlumnoNoExisteException;
import com.mycompany.exception.ArchivoEducativoException;
import com.mycompany.exception.MateriaNoExisteException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author pbarzaghi
 */
public class CargarArchivo {
    
   private  HashMap objCreacion;
    
     public CargarArchivo(){
      
      if(objCreacion == null)
         objCreacion=new HashMap();
      
    }    
    
     
     
      private  List<Inscripcion> leerArchivoInscripciones(String path)throws  AlumnoNoExisteException,
                                                               MateriaNoExisteException,
                                                               ArchivoEducativoException{
         
         List<Inscripcion> inscripcionesLista=new ArrayList<>();
      
       try {
           Path pathInscripcion= Paths.get(path);
           List<String> listaInscripcion=null;
           boolean primeraLineaArchivo=true;
           listaInscripcion= Files.readAllLines(pathInscripcion);
         
           for (String lineaInscripcion :listaInscripcion) {
           
               String[] campo=lineaInscripcion.split(",");
               if(primeraLineaArchivo)
                   primeraLineaArchivo=false;
               else{
                   
                   if(campo[0].isEmpty())
                       throw  new AlumnoNoExisteException("No cargo el Alumno ");
                   if(campo[1].isEmpty())
                       throw  new MateriaNoExisteException("No cargo la Materia ");
                   
                   Alumno alumno=(Alumno) objCreacion.get(Alumno.class+campo[0]);
                   
                   Materia materia=(Materia)objCreacion.get(Materia.class+campo[1]);
                   
                   if(alumno == null)
                       alumno= new Alumno(campo[0],null);
                    //   throw  new AlumnoNoExisteException("No cargo el Alumno ");
                   
                   if(materia== null)
                      materia=new Materia("No exite materia");
                     //  throw  new MateriaNoExisteException("No cargo la Materia ");
                   
                   
                   
                   Inscripcion inscripcion= new Inscripcion(alumno, materia);
                   
                   
                   inscripcionesLista.add(inscripcion);
               }
               
           }
           return inscripcionesLista;
       } catch (IOException ex) {
           throw new ArchivoEducativoException(ex.getMessage());
       }
   }
     
  
     
     
     
     
     
     
     private void leerArchivoMaterias(String path)throws MateriaNoExisteException,ArchivoEducativoException{
         
       try {
           Path pathMateria= Paths.get(path);
           List<String> listaMaterias=null;
           boolean primeraLineaArchivo=true;
           listaMaterias= Files.readAllLines(pathMateria);
           for (String lineaMateria : listaMaterias) {
               
               String[] campo=lineaMateria.split(",");
               if(primeraLineaArchivo)
                   primeraLineaArchivo=false;
               else{
                   
                if(campo.length!=1){
                    
                   int codigo;
                    Materia materia=(Materia)objCreacion.get(Materia.class+campo[0]);
                   if(materia == null){
                       codigo=Integer.parseInt(campo[0]);
                       materia=new Materia(campo[1]);
                       materia.setId(codigo);
                       if(campo.length ==3){
                        String[] materiasCorrelativas=campo[2].split("-");
                        for (String correlativa : materiasCorrelativas) {
                            
                            Materia matCorrelativa=(Materia)objCreacion.get(Materia.class+correlativa);
                           if(matCorrelativa!=null)
                             materia.agregarMateriaCorrelativa(matCorrelativa);
                           else
                               throw new MateriaNoExisteException("CORRELATIVA NO EXISTE");
                        }
                       }
                  objCreacion.put(Materia.class+String.valueOf(codigo),materia);
                   } 
                }
               }
           }
       } catch (IOException ex) {
          throw new ArchivoEducativoException(ex.getMessage());
       }
    }
    
  
 private  void leerArchivoAlumnos(String path)throws AlumnoNoExisteException,ArchivoEducativoException{
         
       try {
           Path pathAlumno= Paths.get(path);
           List<String> listaAlumnos=null;
           boolean primeraLineaArchivo=true;
           listaAlumnos= Files.readAllLines(pathAlumno);
           for (String lineaAlumnos : listaAlumnos) {
               
               String[] campo=lineaAlumnos.split(",");
               if(primeraLineaArchivo)
                   primeraLineaArchivo=false;
               else{
                   Alumno alumno= new Alumno(campo[0],campo[1]);
                 
                   String[] materiasAprobadas=campo[2].split("-");
                   
                   for (String materiaAprobada : materiasAprobadas) {
                       Materia materia =(Materia) objCreacion.get(Materia.class+materiaAprobada);
                       if(materia!= null){
                           alumno.agregarMateriaAprobada(materia);
                       }
                   } 
                   objCreacion.put(Alumno.class+alumno.getLegajo(),alumno);
               }
           }
       } catch (IOException ex) {
          throw new ArchivoEducativoException(ex.getMessage());
       }
    }
     
     
     
     public List<Inscripcion> getInscripciones(String pathAlumno,String pathInscripcion,String pathMateria)
                throws MateriaNoExisteException,AlumnoNoExisteException, ArchivoEducativoException{
     
         this.leerArchivoMaterias(pathMateria);
         this.leerArchivoAlumnos(pathAlumno);
         return this.leerArchivoInscripciones(pathInscripcion);
     
     }
    
}
