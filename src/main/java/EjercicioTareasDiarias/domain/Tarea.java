package EjercicioTareasDiarias.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private int cod_tareas;
    
    @Column(name = "titulo")
    @JsonProperty("Titulo")
    private String Titulo; 
    
    @Column(name = "descripcion")
    @JsonProperty("Descripcion")
    private String Descripcion;
    
    @Column(name = "estado")
    @JsonProperty("Estado")
    private String Estado; 
    

    public Tarea() {
    }

    public Tarea(int cod_tareas) {
        this.cod_tareas = cod_tareas;
    }
    
    

    public Tarea(String Titulo, String Descripcion, String Estado) {
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public Tarea(int cod_tareas, String Titulo, String Descripcion, String Estado) {
        this.cod_tareas = cod_tareas;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
   
    
    
            
            
           
    
}
