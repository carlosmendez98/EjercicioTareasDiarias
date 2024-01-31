package EjercicioTareasDiarias.TareasDiariasService;

import EjercicioTareasDiarias.domain.Tarea;
import java.util.List;



// para pasar tareas en español
public interface TareasDiariasService {
    
    // listar tareas 
    public List<Tarea> listadotareas(); 
    
    // modificar tareas
    public void insertarTareas(Tarea tareas);
    
    // eliminar tareas
    public void eliminarTareas(Tarea tareas);
    
    public Tarea buscarTareaPorId(Tarea tarea);
    
    public void modificarTarea(Tarea tarea);
    
}
