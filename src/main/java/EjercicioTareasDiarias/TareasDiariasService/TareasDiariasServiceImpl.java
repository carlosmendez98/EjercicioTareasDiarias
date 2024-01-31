package EjercicioTareasDiarias.TareasDiariasService;

import EjercicioTareasDiarias.domain.Tarea;
import EjercicioTareasDiarias.TareasDiariasDAO.TareasDAO;
import java.util.List;
import java.util.Optional;
;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class TareasDiariasServiceImpl implements TareasDiariasService {

    @Autowired(required = true)
    private TareasDAO tareasdao;

    @Override // listado de tareas
    @Transactional(readOnly = true)
    public List<Tarea> listadotareas() {
        return tareasdao.findAll();
    }

    @Override  // ayuda a modificar y a insertar
    @Transactional()
    public void insertarTareas(Tarea tareas) {
        tareasdao.save(tareas);

    }

    @Override  // Eliminar tareas
    @Transactional()
    public void eliminarTareas(Tarea tarea) {
        tareasdao.deleteById(tarea.getCod_tareas());

    }

    @Override
    public Tarea buscarTareaPorId(Tarea tarea) {
        return tareasdao.findById(tarea.getCod_tareas()).orElse(null);

    }

    @Override
    @Transactional
    public void modificarTarea(Tarea tarea) {
        Tarea tareaExistente = tareasdao.findById(tarea.getCod_tareas()).orElse(null);

        if (tareaExistente != null) {
            if (tarea.getTitulo() != null) {
                tareaExistente.setTitulo(tarea.getTitulo());
            }
            if (tarea.getDescripcion() != null) {
                tareaExistente.setDescripcion(tarea.getDescripcion());
            }
            if (tarea.getEstado() != null) {
                tareaExistente.setEstado(tarea.getEstado());
            }

            tareasdao.save(tareaExistente);
        }
    }
}
