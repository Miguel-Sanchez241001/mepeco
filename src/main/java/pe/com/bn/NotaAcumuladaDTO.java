package pe.com.bn;

/**
 * DTO para manejar los campos del reporte:
 * - fechaEnvio
 * - importeAcumulado
 */
public class NotaAcumuladaDTO {

    private String fechaEnvio;
    private String importeAcumulado;

    public NotaAcumuladaDTO() {
        // Constructor vacío
    }

    public NotaAcumuladaDTO(String fechaEnvio, String importeAcumulado) {
        this.fechaEnvio = fechaEnvio;
        this.importeAcumulado = importeAcumulado;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getImporteAcumulado() {
        return importeAcumulado;
    }

    public void setImporteAcumulado(String importeAcumulado) {
        this.importeAcumulado = importeAcumulado;
    }

    @Override
    public String toString() {
        return "NotaAcumuladaDTO{" +
                "fechaEnvio='" + fechaEnvio + '\'' +
                ", importeAcumulado='" + importeAcumulado + '\'' +
                '}';
    }
}

