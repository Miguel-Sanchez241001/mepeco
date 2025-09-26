package pe.com.bn;

public class NotaDetalle {
    private String numeroNota;
    private String codCuenta;
    private String beneficiario;
    private String importe;

    public NotaDetalle(String numeroNota, String codCuenta, String beneficiario, String importe) {
        this.numeroNota = numeroNota;
        this.codCuenta = codCuenta;
        this.beneficiario = beneficiario;
        this.importe = importe;
    }

    public String getNumeroNota() { return numeroNota; }
    public String getCodCuenta() { return codCuenta; }
    public String getBeneficiario() { return beneficiario; }
    public String getImporte() { return importe; }
}
