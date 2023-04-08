
import com.mycompany.clase10.Alumno;
import com.mycompany.clase10.Inscripcion;
import com.mycompany.clase10.Materia;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pbarzaghi
 */
public class InscripcionTest {
    private Materia materia1, materia2,materia3, materia4;
    private Alumno alumno1,alumno2,alumno3;
    private List<Materia> correlativas,aprobadas;
   
   
    
   
     @BeforeEach
    public void init(){
    
     materia1=new Materia("Programación I");
     materia2=new Materia("Bases de datos I");
     materia3=new Materia("Bases de datos II");
     materia4=new Materia("Programación II");
     
     alumno1=new Alumno("José Rodríguez", "1111");
     alumno2=new Alumno("Vanesa Sosa", "2222");
     alumno3=new Alumno("Lucia Pérez", "3333");
    
        
    
    }
    
    @Test
    public void materiaSinCorrelativa(){
        correlativas=new ArrayList<>();
         aprobadas=new ArrayList<>(); 
         
        Inscripcion inscripcion= new Inscripcion(alumno1, materia1);
        Assertions.assertTrue(inscripcion.aprobada());
    
      }
    
    
    @Test
    public void materiaConCorrelativaAlumnoTieneAprobada(){
         
        correlativas=new ArrayList<>();
        aprobadas=new ArrayList<>();  
        Inscripcion inscripcion= new Inscripcion(alumno1, materia2);
        alumno1.agregarMateriaAprobada(materia1);
       
        correlativas.add(materia1);
        materia2.setCorrelativas(correlativas);
        
        Assertions.assertTrue(inscripcion.aprobada());
    
      }
    
    
     @Test
    public void materiaConCorrelativaAlumnoNoTieneAprobada(){
         
        correlativas=new ArrayList<>();
     aprobadas=new ArrayList<>();
        Inscripcion inscripcion= new Inscripcion(alumno1, materia3);
        alumno1.agregarMateriaAprobada(materia2);
        correlativas.add(materia1);
        materia3.setCorrelativas(correlativas);
         Assertions.assertFalse(inscripcion.aprobada());
    
      }
}
