package com.example.schenavictor.services.Entity;

/**
 * Created by 2015102617 on 29/03/2017.
 */
public class Cadastro {

    private int id;
    private String nome;
    private String telefone;
    private String senha;
    private String datacriacao;

    public Cadastro(int Id) {
    id=Id;
    }
    public Cadastro() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cadastro)) return false;

        Cadastro cadastro = (Cadastro) o;

        if (getId() != cadastro.getId()) return false;
        if (getNome() != null ? !getNome().equals(cadastro.getNome()) : cadastro.getNome() != null)
            return false;
        if (getTelefone() != null ? !getTelefone().equals(cadastro.getTelefone()) : cadastro.getTelefone() != null)
            return false;
        if (getSenha() != null ? !getSenha().equals(cadastro.getSenha()) : cadastro.getSenha() != null)
            return false;
        return getDatacriacao() != null ? getDatacriacao().equals(cadastro.getDatacriacao()) : cadastro.getDatacriacao() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        result = 31 * result + (getDatacriacao() != null ? getDatacriacao().hashCode() : 0);
        return result;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Cadastro(int id, String nome, String telefone, String senha, String datacriacao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.datacriacao = datacriacao;
    }

    public Cadastro(String nome, String telefone, String senha, String datacriacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.datacriacao = datacriacao;
    }


    @Override
    public String toString() {
        return "Cadastro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", datacriacao='" + datacriacao + '\'' +
                '}';
    }
}
