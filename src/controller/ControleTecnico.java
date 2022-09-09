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
    
    public long getID(int index){
        return tecnicos.get(index).getID();
    }
    
    public int getNumJogos(int index){
        return tecnicos.get(index).getNumJogos();
    }
    
    public int getNumVitorias(int index){
        return tecnicos.get(index).getNumVitorias();
    }

    public float getTaxaAproveitamento(int index){
        return tecnicos.get(index).getTaxaAproveitamento();
    }
}
