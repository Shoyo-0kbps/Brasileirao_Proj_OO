package controller;
import model.*;
import java.util.ArrayList;

public class ControleTecnico {

    private ArrayList<Tecnico> tecnicos;
    private int qnt_tecnicos;

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
    
    public String getPosicao(int index){
        return tecnicos.get(index).getPosicao();
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
