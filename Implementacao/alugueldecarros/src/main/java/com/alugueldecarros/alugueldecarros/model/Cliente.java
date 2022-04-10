package com.alugueldecarros.alugueldecarros.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cliente {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String profissao;
    private String empregador;
    private int rendimento_1;
    private int rendimento_2;
    private int rendimento_3;

    @Deprecated
    protected  Cliente(){ }

    public Cliente(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmpregador() {
        return empregador;
    }

    public void setEmpregador(String empregador) {
        this.empregador = empregador;
    }

    public int getRendimento_1() {
        return rendimento_1;
    }

    public void setRendimento_1(int rendimento_1) {
        this.rendimento_1 = rendimento_1;
    }

    public int getRendimento_2() {
        return rendimento_2;
    }

    public void setRendimento_2(int rendimento_2) {
        this.rendimento_2 = rendimento_2;
    }

    public int getRendimento_3() {
        return rendimento_3;
    }

    public void setRendimento_3(int rendimento_3) {
        this.rendimento_3 = rendimento_3;
    }



}
