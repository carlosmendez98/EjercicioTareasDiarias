
package EjercicioTareasDiarias.web;

import EjercicioTareasDiarias.TareasDiariasService.ExcelService;
import EjercicioTareasDiarias.TareasDiariasService.TareasDiariasService;
import EjercicioTareasDiarias.domain.Tarea;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//CONTROLADOR PARA CREAR ARCHIVO EXCEL
@Controller
@RequestMapping("/excel")
public class ExcelControlador {
    @Autowired(required = true)
    private ExcelService excelservice;
    
    @Autowired(required = true)
    private TareasDiariasService tareaservice;
    
    // ENDPOINT PARA DESCARGAR ARCHIVO EXCEL 
    @GetMapping("/descargar")
    @ResponseBody
    public byte[] descargarExcel() throws IOException {
        List<Tarea> tareaslista =  tareaservice.listadotareas();
         // Generar el archivo Excel
        return excelservice.generarArchivoExcel(tareaslista);
    }
}
