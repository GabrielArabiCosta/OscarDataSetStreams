package model;

public class OscarModel {

    private int index;
    private int ano;
    private int idade;
    private String nome;
    private String nomeDoFilme;

    public OscarModel(int index, int ano, int idade, String nome, String nomeDoFilme) {
        this.index = index;
        this.ano = ano;
        this.idade = idade;
        this.nome = nome;
        this.nomeDoFilme = nomeDoFilme;
    }

    public int getIndex() {return index;}
    public int getAno() {return ano;}
    public int getIdade() {return idade;}
    public String getNome() {return nome;}
    public String getNomeDoFilme() {return nomeDoFilme;}

    public void setIndex(int index) {this.index = index;}
    public void setAno(int ano) {this.ano = ano;}
    public void setIdade(int idade) {this.idade = idade;}
    public void setNome(String nome) {this.nome = nome;}
    public void setNomeDoFilme(String nomeDoFilme) {this.nomeDoFilme = nomeDoFilme;}


}
