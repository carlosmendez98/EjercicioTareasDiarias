package EjercicioTareasDiarias.web;


import EjercicioTareasDiarias.TareasDiariasService.TareasDiariasService;
import EjercicioTareasDiarias.domain.Tarea;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



// controlador 

@Controller
@RequestMapping(value = "" )
public class Controlador {
    
    @Autowired(required = true)
    private TareasDiariasService tareas_service; // interfaz de tareas service ( tareas service ) 
    
    // mostrar listado de tareas
    @GetMapping("/")
    public String listaTareas(Model model){
    List<Tarea> tareas = tareas_service.listadotareas();
    model.addAttribute("tareas", tareas);
       return "index";
    }
    
    
    // redirecciona a la pagina de agregar
    @GetMapping("/agregar")
    public String agregar(){
      return "agregar";
    }
    
    // guardar tarea
    @PostMapping("/guardar")
    public String guardar(Tarea tarea){
       tareas_service.insertarTareas(tarea);
        return "redirect:/";
    
    }
    // eliminar tarea
    @GetMapping("/eliminar/{cod_tareas}")
    public String eliminar(Tarea tarea){
       tareas_service.eliminarTareas(tarea);
         return "redirect:/";
    }
    
 
}


