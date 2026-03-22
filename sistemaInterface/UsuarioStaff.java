package sistemaInterface;

public class UsuarioStaff {
    private String nomeStaff;
    private String emailStaff;
    private int codigoStaff;
    private String cpfStaff;
    private String senhaStaff;

    public UsuarioStaff (String nomeStaff, String emailStaff, int codigoStaff, String cpfStaff, String senhaStaff) {
        this.nomeStaff = nomeStaff;
        this.emailStaff = emailStaff;
        this.codigoStaff = codigoStaff;
        this.cpfStaff = cpfStaff;
        this.senhaStaff = senhaStaff;
    }

    public String getNomeStaff() {
        return nomeStaff;
    }

    public void setNomeStaff(String nomeStaff) {
        this.nomeStaff = nomeStaff;
    }

    public String getEmailStaff() {
        return emailStaff;
    }

    public void setEmailStaff(String emailStaff) {
        this.emailStaff = emailStaff;
    }

    public int getCodigoStaff() {
        return codigoStaff;
    }

    public void setIdStaff(int idStaff) {
        this.codigoStaff = idStaff;
    }

    public String getCpfStaff() {
        return cpfStaff;
    }

    public void setCpfStaff(String cpfStaff) {
        this.cpfStaff = cpfStaff;
    }

    public String getSenhaStaff() {
        return senhaStaff;
    }

    public void setSenhaStaff(String senhaStaff) {
        this.senhaStaff = senhaStaff;
    }
    


}
