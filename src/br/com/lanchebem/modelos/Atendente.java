package br.com.lanchebem.modelos;

import java.util.Calendar;

public class Atendente extends Pessoa {

    private double salario;

    private String tipoDeFuncionario;

    private Calendar dataDeCadastro;

    public String getDadosPessoais() {
        String alerta = "O Atendente: " + this.getNome() + " foi adicionado como: " + this.tipoDeFuncionario;
        return alerta;

    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the tipoDeFuncionario
     */
    public String getTipoDeFuncionario() {
        return tipoDeFuncionario;
    }

    /**
     * @param tipoDeFuncionario the tipoDeFuncionario to set
     */
    public void setTipoDeFuncionario(String tipoDeFuncionario) {
        this.tipoDeFuncionario = tipoDeFuncionario;
    }

    /**
     * @return the dataDeCadastro
     */
    public Calendar getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * @param dataDeCadastro the dataDeCadastro to set
     */
    public void setDataDeCadastro(Calendar dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

}
