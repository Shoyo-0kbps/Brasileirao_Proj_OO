package model;

public abstract class Pessoa {
    
    private String nome;
    private String posicao;
    private long id;
    
    public Pessoa() {
        super();
    }

    public Pessoa(String nome, String posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public Pessoa(String nome, String posicao, long id) {
        this.nome = nome;
        this.posicao = posicao;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao){
        this.posicao = posicao;
    }

    public long getID(){
        return id;
    }

    public void setID(long id){
        this.id = id;
    }

}
