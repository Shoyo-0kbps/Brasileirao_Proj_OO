package model;
/**
 * Classe Abstrata Pessoa que simula o comportamento de uma pessoa no sistema proposto
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public abstract class Pessoa {
    
    private String nome;
    private String posicao;
    private long id;
    /*
     * Constutor Pessoa
     */
    public Pessoa() {
        super();
    }
    /**
     * Construtor Pessoa
     * @param nome nome da pessoa
     * @param posicao posicao em que joga
     */
    public Pessoa(String nome, String posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }
    /**
     * Construtor Pessoa
     * @param nome nome da pessoa
     * @param posicao posicao em que joga
     * @param id identificador no sistema
     */
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
