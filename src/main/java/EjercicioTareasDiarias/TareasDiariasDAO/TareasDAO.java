package EjercicioTareasDiarias.TareasDiariasDAO;


import EjercicioTareasDiarias.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TareasDAO extends JpaRepository<Tarea, Integer>  {
    
}
