/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;

import Dtos.ReporteDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import javax.swing.JFileChooser;

/**
 *
 * @author ReneEzequiel23
 */
public class ReporteLaboratorio {

    public void Reporte(LocalDate fechaInicio, LocalDate fechaFinal, java.util.List<ReporteDTO> lista) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fc.showOpenDialog(fc);
        File name = fc.getSelectedFile();
        String path = name.getAbsolutePath();

        Document document = new Document(PageSize.A4); // Cambiamos a A4 para más espacio
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
            document.open();
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font fontSubTitulo = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC);
            Font fontContenido = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

            // Título del reporte
            Paragraph titulo = new Paragraph("Reporte de laboratorios", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph(" ")); // Espacio en blanco

            // Filtros aplicados
            Paragraph subtitulo = new Paragraph("Filtros aplicados:", fontSubTitulo);
            document.add(subtitulo);

            PdfPTable tableFiltros = new PdfPTable(2);
            tableFiltros.setWidthPercentage(100);
            tableFiltros.addCell(new Phrase("Desde:", fontContenido));
            tableFiltros.addCell(new Phrase(fechaInicio.toString(), fontContenido));
            tableFiltros.addCell(new Phrase("Hasta:", fontContenido));
            tableFiltros.addCell(new Phrase(fechaFinal.toString(), fontContenido));
            document.add(tableFiltros);

            document.add(new Paragraph(" ")); // Espacio en blanco

            // Tabla de pagos
            PdfPTable table = new PdfPTable(5); // columnas para los datos de Pago
            table.setWidthPercentage(100);

            // Encabezados de la tabla
            String[] headers = {"Laboratorio", "Fecha","Tiempo de servicio" , "TiempoSinUso", "TiempoDeUso"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, fontContenido));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);

            }
            // Datos de la tabla

            Long tiempoServicio;
            for (int i = 0; i < lista.size(); i++) {
                
                table.addCell(new Phrase(lista.get(i).getLaboratorio()));
                
                table.addCell(new Phrase(lista.get(i).getFecha().toString()));
                
                tiempoServicio = Duration.between(
                        lista.get(i).getHoraInicio(),
                        lista.get(i).getHoraFin()).toMinutes();
                
                table.addCell(new Phrase(tiempoServicio.toString()));
                
                table.addCell(new Phrase(String.valueOf(lista.get(i).getTiempoSinUso())));
                table.addCell(new Phrase(String.valueOf(lista.get(i).getTiempoDeUso())));
               
            }

            document.add(table);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

    }

    public void createPDF(File pdfNewFile) {
        // Aquí introduciremos el código para crear el PDF.
    }

    public void ruta() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fc.showOpenDialog(fc);
        File name = fc.getSelectedFile();
        String path = name.getAbsolutePath();
        System.out.println(path);
    }
}
