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
    
    public String getID(int index){
        return String.valueOf(jogadores.get(index).getID());
    }
    
    public String getSaldGols(int index){
        return String.valueOf(jogadores.get(index).getSaldoGols());
    }
    
    public String getNumCamisa(int index){
        return String.valueOf(jogadores.get(index).getNumCamisa());
    }
}
