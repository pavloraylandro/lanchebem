package br.com.lanchebem.modelos;

import java.util.Calendar;

public class Cliente extends Pessoa {

    private String tipoDeCliente;

    private Calendar datadecadastro;

    public String getDadosPessoais() {
        String alerta = "O Cliente: " + this.getNome() + " foi adicionado como " + this.tipoDeCliente;
        return alerta;
    }

    /**
     * @return the tipoDeCliente
     */
    public String getTipoDeCliente() {
        return tipoDeCliente;
    }

    /**
     * @param tipoDeCliente the tipoDeCliente to set
     */
    public void setTipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    /**
     * @return the datadecadastro
     */
    public Calendar getDatadecadastro() {
        return datadecadastro;
    }

    /**
     * @param datadecadastro the datadecadastro to set
     */
    public void setDatadecadastro(Calendar datadecadastro) {
        this.datadecadastro = datadecadastro;
    }

}
