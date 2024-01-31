/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioTareasDiarias.web;

import EjercicioTareasDiarias.TareasDiariasService.TareasDiariasService;
import EjercicioTareasDiarias.domain.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Valencia
 */
@RestController
public class otroControladorRest {

    @Autowired
    private TareasDiariasService tareasService;

    @GetMapping(value = "/otraRuta/{codigo}", produces = "application/json")
    public ResponseEntity<Tarea> obtenerOtraTarea(@PathVariable int codigo) {
        Tarea tarea = tareasService.buscarTareaPorId(new Tarea(codigo));

        if (tarea != null) {
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   
    @PostMapping("/modificarTarea")
    public ResponseEntity<String> modificarTarea(@RequestBody Tarea tarea) {
        try {
        System.out.println("ID: " + tarea.getCod_tareas());
        System.out.println("Titulo: " + tarea.getTitulo());
        System.out.println("Descripcion: " + tarea.getDescripcion());
        System.out.println("Estado: " + tarea.getEstado());

        tareasService.modificarTarea(tarea);
        return ResponseEntity.ok("Tarea modificada con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar la tarea");
        }
    }
}

