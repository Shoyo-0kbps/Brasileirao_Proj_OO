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
        for(int i = 0; i < qnt_times; i++)
            aux[i] = times.get(i).getName();
        return aux;
    }

    public String[] getPontosTimes(){
        String[] aux = new String[qnt_times];
        for(int i = 0; i < qnt_times; i++)
            aux[i] = String.valueOf(times.get(i).getPontos()); 
        return aux;
    }    

    public String[] getNJogos(){
        String[] aux = new String[qnt_times];
        for(int i = 0; i < qnt_times; i++)
            aux[i] = String.valueOf(times.get(i).getNumJogos()); 
        return aux;
    }    
    
    public String[] getNVitorias(){
        String[] aux = new String[qnt_times];
        for(int i = 0; i < qnt_times; i++)
            aux[i] = String.valueOf(times.get(i).getNumVitorias()); 
        return aux;
    }    
    
    public String[] getNEmpates(){
        String[] aux = new String[qnt_times];
        for(int i = 0; i < qnt_times; i++)
            aux[i] = String.valueOf(times.get(i).getNumEmpates()); 
        return aux;
    }    

    public String getNome(int index_time){
        return times.get(index_time).getName();
    }
    
    public String getAbrev(int index_time){
        return times.get(index_time).getAbrev();
    }
    
    public String getID(int index_time){
        return String.valueOf(times.get(index_time).getID());
    }
    
    public String getPontos(int index_time){
        return String.valueOf(times.get(index_time).getPontos());
    }
    
    public String getNumJogos(int index_time){
        return String.valueOf(times.get(index_time).getNumJogos());
    }
    
    public String getNumEmpates(int index_time){
        return String.valueOf(times.get(index_time).getNumEmpates());
    }
    
    public String getNumVitorias(int index_time){
        return String.valueOf(times.get(index_time).getNumVitorias());
    }
    
    public String getGolsPro(int index_time){
        return String.valueOf(times.get(index_time).getGolsPro());
    }

    public String getGolsCon(int index_time){
        return String.valueOf(times.get(index_time).getGolsCon());
    }

    public String getSaldGols(int index_time){
        return String.valueOf(times.get(index_time).getSaldGols());   
    }

    public String getAprov(int index_time){
        return String.valueOf(times.get(index_time).getTaxaAproveitamento());
    }
}
