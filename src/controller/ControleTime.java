package controller;
import java.util.ArrayList;
import model.*;

public class ControleTime {
    private ArrayList<Time> times;  
    private int qnt_times;

    public ControleTime(ControleDados dados){
        times = dados.getTimes();
        qnt_times = dados.getQntTotalTimes();
    }

    public String[] getNomeTimes(){
        String[] aux = new String[qnt_times];
        for(int i = 0; i < qnt_times; i++){
            aux[i] = times.get(i).getName();
        }
        return aux;
    }

    //public int[] getPontosTimes(){
    //    int[] aux = new int[qntTimes];
    //    for(int i = 0; i < qntTimes; i++){
    //        aux[i] = times.get(i).getPontos();
    //    }
    //    return aux;
    //}


    public String getNome(int index_time){
        return times.get(index_time).getName();
    }
    
    public String getAbrev(int index_time){
        return times.get(index_time).getAbrev();
    }
    
    public long getID(int index_time){
        return times.get(index_time).getID();
    }
    
    public int getPontos(int index_time){
        return times.get(index_time).getPontos();
    }
    
    public int getNumJogos(int index_time){
        return times.get(index_time).getNumJogos();
    }
    
    public int getNumEmpates(int index_time){
        return times.get(index_time).getNumEmpates();
    }
    
    public int getNumVitorias(int index_time){
        return times.get(index_time).getNumVitorias();
    }
    
    public int getGolsPro(int index_time){
        return times.get(index_time).getGolsPro();
    }

    public int getGolsCon(int index_time){
        return times.get(index_time).getGolsCon();
    }

    public int getSaldGols(int index_time){
        return times.get(index_time).getSaldGols();   
    }

    public float getAprov(int index_time){
        return times.get(index_time).getTaxaAproveitamento();
    }
}
