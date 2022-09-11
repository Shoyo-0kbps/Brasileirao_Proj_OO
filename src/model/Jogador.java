package model;

import java.util.*;
/**
 * Classe Time simula o comportamento de um jogador e extende a Classe abstrata Pessoa
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public class Jogador extends Pessoa {
    
    private int saldo_gols;
    private int numero_camisa;
    /**
     * Construtor Jogador
     */
    public Jogador(){
        super();
    }
    /**
     * Constutor Jogador
     * @param nome nome do jogador
     * @param posicao posicao em que joga
     */
    public Jogador(String nome, String posicao){
        super(nome, posicao);       
    }
    /**
     * Construtor Jogador
     * @param nome nome do jogador 
     * @param posicao posicao em que joga
     * @param id identificador no sistema
     */
    public Jogador(String nome, String posicao, long id){
        super(nome, posicao, id);
        saldo_gols = 0;       
    }
    /**
     * Construtor Jogador
     * @param nome nome do jogador
     * @param posicao posicao em que joga
     * @param id identificador no sistema 
     * @param saldo_gols saldo de gols
     * @param numero_camisa numero da camisa 
     */
    public Jogador(String nome, String posicao, long id, int saldo_gols, int numero_camisa){
        super(nome, posicao, id);       
        this.saldo_gols = saldo_gols;
        this.numero_camisa = numero_camisa;
    }

    public int getSaldoGols(){
        return saldo_gols;
    }

    public void setSaldoGols(int gols){
        saldo_gols = gols;
    }

    public void incrementaGol(){
        this.saldo_gols += 1; 
    }
    
    public int getNumCamisa(){
        return numero_camisa;
    }

    public void setNumCamisa(int num){
        numero_camisa = num;
    }

}
