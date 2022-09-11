package controller;
import model.*;
import java.util.ArrayList;
/**
 * Classe ControleJogador reune, obtem e compila os dados de um jogador ou dos jogadores de um time para a camada de visualizacao  
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public class ControleJogador {
    private ArrayList<Jogador> jogadores;
    private int qnt_jogadores;
    
    /**
     * Contrutor CoontroleJogador
     * @param dados dados do tipo ControleDados que contem a lista de times
     * @param index_time posicao do time na lista de times que se deseja obter os dados dos jogadores
     */
    public ControleJogador(ControleDados dados, int index_time){
        jogadores = dados.getJogadores(index_time);
        qnt_jogadores = dados.getJogadores(index_time).size();
    }
    /**
     * Agrega o nome de todos os jogadores de um time
     * @return Lista de nomes de jogadores 
     */
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
