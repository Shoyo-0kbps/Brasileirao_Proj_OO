package model;

import java.util.*;

public class Jogador extends Pessoa {
    
    private int saldo_gols;
    private int numero_camisa;

    public Jogador(){
        super();
    }

    public Jogador(String nome, String posicao){
        super(nome, posicao);       
    }

    public Jogador(String nome, String posicao, long id){
        super(nome, posicao, id);
        saldo_gols = 0;       
    }
    
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
