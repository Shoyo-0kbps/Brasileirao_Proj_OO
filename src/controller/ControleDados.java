package controller;
import java.util.ArrayList;

import javax.lang.model.type.ArrayType;

import model.*;

public class ControleDados {
    
    private Dados dados = new Dados();

    //// DADOS
    public ControleDados(){
        dados.lerDadosTime();
    }

    public Dados getDados(){
        return dados;
    }

    public void setDados(Dados dados){
        this.dados = dados;
    }

    /////////////// TIMES ///////////////
    
    public ArrayList<Time> getTimes(){
        return dados.getTimes();
    }

    public int getQntTotalTimes(){
        return dados.getQntTimes();
    }

    public boolean insereEditaTime(String[] d_time, int pos, boolean flag){
        
        for(int i = 2; i < 10; i++){
            if(!d_time[i].matches("[0-9]+|[0-9]+(\\.[0-9]+)")){
                return false;
            }
        }

        Time aux = new Time(d_time[0], d_time[1], Long.parseLong(d_time[2]), 
                            Integer.parseInt(d_time[3]), Integer.parseInt(d_time[4]),
                            Integer.parseInt(d_time[5]), Integer.parseInt(d_time[6]), 
                            Integer.parseInt(d_time[7]), Integer.parseInt(d_time[8]), 
                            Integer.parseInt(d_time[9]), Float.parseFloat(d_time[10]));
    
        if(flag){
            dados.insereTime(aux);
            return true;
        } else {
            dados.editaTime(aux, pos);
            return true;   
        }
    }
    
    public boolean removeTime(int pos){

        if(pos > dados.getQntTimes() || pos < 0){
            return false;
        }
        else{
            dados.removeTime(pos);
            return true;
        }
    }
    
    /////////////// TECNICOS ///////////////
    public ArrayList<Tecnico> getTecnicos(int index_time){
        return dados.getTecnicos(index_time);
    }

    public int getQntTotalTecnicos(){
        return dados.getQntTotalTecnicos();
    }

    public boolean insereEditaTecnico(String[] d_tecnico, int index_time, int pos, boolean flag){
        
        for(int i = 1; i < 4; i++){
            if(!d_tecnico[i].matches("[0-9]+")){
                return false;
            }
        }

        Tecnico aux = new Tecnico(d_tecnico[0], Long.parseLong(d_tecnico[1]), 
                            Integer.parseInt(d_tecnico[2]), Integer.parseInt(d_tecnico[3]));
    
        if(flag){
            dados.insereTecnico(aux, index_time);
            return true;
        } else {
            dados.editaTecnico(aux, index_time, pos);
            return true;   
        }
    }
    
    public boolean removeTecnico(int index_time, int pos){

        if(index_time > dados.getQntTimes() || index_time < 0){
            return false;
        } else if(pos > dados.getQntTecnicos(index_time) || pos < 0){
            return false;
        }
        else{
            dados.removeTecnico(index_time, pos);
            return true;
        }
    }
    
    /////////////// JOGADORES //////////////
    public ArrayList<Jogador> getJogadores(int index_time){
        return dados.getJogadores(index_time);
    }

    public int getQntTotalJogadores(){
        return dados.getQntTotalJogadores();
    }
    
    public boolean insereEditaJogador(String[] d_jogador, int index_time, int pos, boolean flag){
        
        for(int i = 2; i < 5; i++){
            if(!d_jogador[i].matches("[0-9]+")){
                return false;
            }
        }

        Jogador aux = new Jogador(d_jogador[0], d_jogador[1], Long.parseLong(d_jogador[2]), 
                            Integer.parseInt(d_jogador[3]), Integer.parseInt(d_jogador[4]));
    
        if(flag){
            dados.insereJogador(aux, index_time);
            return true;
        } else {
            dados.editaJogador(aux, index_time, pos);
            return true;   
        }
    }
        
    public boolean removeJogador(int index_time, int pos){

        if(index_time > dados.getQntTimes() || index_time < 0){
            return false;
        } else if(pos > dados.getQntJogadores(index_time) || pos < 0){
            return false;
        }
        else{
            dados.removeJogador(index_time, pos);
            return true;
        }
    }
}
