package controller;
import model.*;
import java.util.ArrayList;

public class ControleJogador {
    private ArrayList<Jogador> jogadores;
    private int qnt_jogadores;

    public ControleJogador(ControleDados dados, int index_time){
        jogadores = dados.getJogadores(index_time);
        qnt_jogadores = dados.getJogadores(index_time).size();
    }

    public String[] getNomeJogadores(){
        String[] aux = new String[qnt_jogadores];
        for(int i = 0; i< qnt_jogadores; i++){
            aux[i] = jogadores.get(i).getNome();
        }
        return aux;
    }

    public String getNome(int index){
        return jogadores.get(index).getNome();
    }
    
    public String getPosicao(int index){
        return jogadores.get(index).getPosicao();
    }
    
    public long getID(int index){
        return jogadores.get(index).getID();
    }
    
    public int getSaldGols(int index){
        return jogadores.get(index).getSaldoGols();
    }
    
    public int getNumCamisa(int index){
        return jogadores.get(index).getNumCamisa();
    }
}
