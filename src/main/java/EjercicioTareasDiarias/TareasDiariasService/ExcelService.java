package EjercicioTareasDiarias.TareasDiariasService;

import EjercicioTareasDiarias.domain.Tarea;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

//CAPA SERVICIO PARA LA CREACION DEL ARCHIVO EXCEL
@Service
public class ExcelService {

    public byte[] generarArchivoExcel(List<Tarea> tarea) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Tareas Diarias");
            
// Crear el estilo para la celda con negrilla 
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);
        // Crear el Borde en un color Negro
        headerCellStyle.setBorderTop(BorderStyle.THICK);
        headerCellStyle.setBorderBottom(BorderStyle.THICK);
        headerCellStyle.setBorderLeft(BorderStyle.THICK);
        headerCellStyle.setBorderRight(BorderStyle.THICK);
            
            
             Row headerRow = sheet.createRow(0);
     // Crear la celda para "Titulo" con el estilo de negrilla
        Cell cellTitulo = headerRow.createCell(0);
        cellTitulo.setCellValue("Titulo");
        cellTitulo.setCellStyle(headerCellStyle);

        // Crear la celda para "Descripcion" con el estilo de negrilla
        Cell cellDescripcion = headerRow.createCell(1);
        cellDescripcion.setCellValue("Descripcion");
        cellDescripcion.setCellStyle(headerCellStyle);

        // Crear la celda para "Estado" con el estilo de negrilla
        Cell cellEstado = headerRow.createCell(2);
        cellEstado.setCellValue("Estado");
        cellEstado.setCellStyle(headerCellStyle);
            // Llenar el resto de las filas con datos
            for (int i = 0; i < tarea.size(); i++) {
                Row row = sheet.createRow(i + 1);
               row.createCell(0).setCellValue(tarea.get(i).getTitulo()); 
               row.createCell(1).setCellValue(tarea.get(i).getDescripcion()); 
               row.createCell(2).setCellValue(tarea.get(i).getEstado()); 
               
               
            }

            // Convertir el libro de trabajo a bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

}

