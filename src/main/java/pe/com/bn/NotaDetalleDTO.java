package pe.com.bn;


/**
 * DTO para el detalle de notas transmitidas
 */
public class NotaDetalleDTO {

    private String numeroNota;
    private String fechaEmision;
    private String codCuenta;
    private String importe;
    private String usuario;

    public NotaDetalleDTO() {
        // Constructor vacío requerido por JasperReports
    }

    public NotaDetalleDTO(String numeroNota, String fechaEmision, String codCuenta, String importe, String usuario) {
        this.numeroNota = numeroNota;
        this.fechaEmision = fechaEmision;
        this.codCuenta = codCuenta;
        this.importe = importe;
        this.usuario = usuario;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "NotaDetalle{" +
                "numeroNota='" + numeroNota + '\'' +
                ", fechaEmision='" + fechaEmision + '\'' +
                ", codCuenta='" + codCuenta + '\'' +
                ", importe='" + importe + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
