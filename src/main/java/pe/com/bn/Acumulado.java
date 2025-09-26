package pe.com.bn;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Acumulado { public static void main(String[] args) {
    try {
        // 1. Crear lista de objetos
        List<NotaAcumuladaDTO> notas = new ArrayList<>();

        // Agregar objetos con sus valores
        notas.add(new NotaAcumuladaDTO("25/09/2025", "$16,792.78"));
        notas.add(new NotaAcumuladaDTO("26/09/2025", "$20,450.00"));
        notas.add(new NotaAcumuladaDTO("27/09/2025", "$9,320.50"));

        // 2. Parámetros del reporte
        Map<String, Object> params = new HashMap<>();
        params.put("fechaProceso", "25/09/2025");
        params.put("agencia", "Agencia Central22");
        params.put("archivoOrigen", "archivo122.txt");
        params.put("usuario", "msanchez22");
        params.put("fechaImpresion", "25/09/20252");
        params.put("valorTotal", "$ 36,792.78");
        params.put("mostrarFechaImpresion", Boolean.TRUE);
        params.put("lista", notas);

        // 3) Cargar .jasper desde resources
        InputStream is = Main.class.getResourceAsStream("/notas_acumuladas.jasper");
        if (is == null) throw new IllegalStateException("No se encontró notas_acumuladas.jasper en /resources");

        // 4) Llenar (maestro con JREmptyDataSource)
        JasperPrint jp = JasperFillManager.fillReport(is, params, new JREmptyDataSource(1));

        // 5) Exportar PDF
        JasperExportManager.exportReportToPdfFile(jp, "out/reporte_notas_acumuladas.pdf");

        // 6) Exportar XLSX
        JRXlsxExporter xlsx = new JRXlsxExporter();
        xlsx.setExporterInput(new SimpleExporterInput(jp));
        xlsx.setExporterOutput(new SimpleOutputStreamExporterOutput("out/reporte_notas_acumuladas.xlsx"));
        SimpleXlsxReportConfiguration xlsxCfg = new SimpleXlsxReportConfiguration();
        xlsxCfg.setOnePagePerSheet(false);
        xlsxCfg.setDetectCellType(true);
        xlsxCfg.setRemoveEmptySpaceBetweenRows(true);
        xlsxCfg.setRemoveEmptySpaceBetweenColumns(true);
        xlsxCfg.setWhitePageBackground(false);
        xlsxCfg.setIgnoreGraphics(true);

        xlsx.setConfiguration(xlsxCfg);
        xlsx.exportReport();

        // 7) Exportar XLS (si lo necesitas)
        JRXlsExporter xls = new JRXlsExporter();
        xls.setExporterInput(new SimpleExporterInput(jp));
        xls.setExporterOutput(new SimpleOutputStreamExporterOutput("out/reporte_notas_acumuladas.xls"));
        SimpleXlsReportConfiguration xlsCfg = new SimpleXlsReportConfiguration();
        xlsCfg.setOnePagePerSheet(false);
        xlsCfg.setDetectCellType(true);
        xlsCfg.setRemoveEmptySpaceBetweenRows(true);
        xlsCfg.setRemoveEmptySpaceBetweenColumns(true);
        xlsCfg.setWhitePageBackground(false);
        xlsCfg.setIgnoreGraphics(true);

        xls.setConfiguration(xlsCfg);
        xls.exportReport();

        System.out.println("✅ Generados: out/reporte_notas_acumuladas.pdf, .xlsx y .xls");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
