package controller;
import model.*;
import java.util.ArrayList;
/**
 * Classe ControleTecnico reune, obtem e compila os dados de um tecnico ou dos tecnicos de um time para a camada de visualizacao  
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public class ControleTecnico {

    private ArrayList<Tecnico> tecnicos;
    private int qnt_tecnicos;
    /**
     * Contrutor CoontroleTecnico
     * @param dados dados do tipo ControleDados que contem a lista de times
     * @param index_time posicao do time na lista de times que se deseja obter os dados dos tecnicos
     */
    public ControleTecnico(ControleDados dados, int index_time){
        tecnicos = dados.getTecnicos(index_time);
        qnt_tecnicos = dados.getTecnicos(index_time).size();
    }

    public String[] getNomeTecnicos(){
        String[] aux = new String[qnt_tecnicos];
        for(int i = 0; i< qnt_tecnicos; i++){
            aux[i] = tecnicos.get(i).getNome();
        }
        return aux;
    }

    public String getNome(int index){
        return tecnicos.get(index).getNome();
    }
    
    public String getID(int index){
        return String.valueOf(tecnicos.get(index).getID());
    }
    
    public String getNumJogos(int index){
        return String.valueOf(tecnicos.get(index).getNumJogos());
    }
    
    public String getNumVitorias(int index){
        return String.valueOf(tecnicos.get(index).getNumVitorias());
    }

    public String getTaxaAproveitamento(int index){
        return String.valueOf(tecnicos.get(index).getTaxaAproveitamento());
    }
}
