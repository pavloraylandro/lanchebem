package br.com.lanchebem.modelos;

import java.util.Calendar;

public abstract class Pessoa  {

    private int id;

    private String nome;

    private String cpf;

    private Calendar datadenascimento;

    public String getDadosPessoais() {
        return null;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the datadenascimento
     */
    public Calendar getDatadenascimento() {
        return datadenascimento;
    }

    /**
     * @param datadenascimento the datadenascimento to set
     */
    public void setDatadenascimento(Calendar datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

}
