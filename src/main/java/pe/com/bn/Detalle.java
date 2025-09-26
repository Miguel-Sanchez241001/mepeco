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

public class Detalle { public static void main(String[] args) {
    try {
        // 1. Crear lista de objetos
        List<NotaDetalleDTO> notas = new ArrayList<>();

        notas.add(new NotaDetalleDTO("18426359", "25/09/2025", "00068315964", "$16,792.78", "msanchez"));
        notas.add(new NotaDetalleDTO("18426360", "25/09/2025", "00068315965", "$20,450.00", "jperez"));
        notas.add(new NotaDetalleDTO("18426361", "26/09/2025", "00068315966", "$5,320.50", "arojas"));

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
        InputStream is = Main.class.getResourceAsStream("/notas_detalle.jasper");
        if (is == null) throw new IllegalStateException("No se encontró notas_detalle.jasper en /resources");

        // 4) Llenar (maestro con JREmptyDataSource)
        JasperPrint jp = JasperFillManager.fillReport(is, params, new JREmptyDataSource(1));

        // 5) Exportar PDF
        JasperExportManager.exportReportToPdfFile(jp, "out/reporte_notas_detalle.pdf");

        // 6) Exportar XLSX
        JRXlsxExporter xlsx = new JRXlsxExporter();
        xlsx.setExporterInput(new SimpleExporterInput(jp));
        xlsx.setExporterOutput(new SimpleOutputStreamExporterOutput("out/reporte_notas_detalle.xlsx"));
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
        xls.setExporterOutput(new SimpleOutputStreamExporterOutput("out/reporte_notas_detalle.xls"));
        SimpleXlsReportConfiguration xlsCfg = new SimpleXlsReportConfiguration();
        xlsCfg.setOnePagePerSheet(false);
        xlsCfg.setDetectCellType(true);
        xlsCfg.setRemoveEmptySpaceBetweenRows(true);
        xlsCfg.setRemoveEmptySpaceBetweenColumns(true);
        xlsCfg.setWhitePageBackground(false);
        xlsCfg.setIgnoreGraphics(true);

        xls.setConfiguration(xlsCfg);
        xls.exportReport();

        System.out.println("✅ Generados: out/reporte_notas_detalle.pdf, .xlsx y .xls");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

