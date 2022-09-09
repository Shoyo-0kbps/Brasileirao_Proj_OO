package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dados {
    
    ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    int jgdrs_total = 0;
    ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
    int tcn_total = 0;
    ArrayList<Time> times = new ArrayList<Time>(); 

    public void lerDadosTime(){
        String path = "/home/miza/Documents/Code/Java/proj_OO/src/misc/";
        String file = path + "times.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            
            String line = br.readLine(); // ler linha cabecalho
            line = br.readLine(); 
            while(line != null){

                String[] infos = line.split(","); 
                String nome = infos[0];
                String abrev = infos[1];
                long id = Long.parseLong(infos[2]);
                int pontos = Integer.parseInt(infos[3]);
                int n_jogos = Integer.parseInt(infos[4]);
                int n_emp = Integer.parseInt(infos[5]);
                int n_vit = Integer.parseInt(infos[6]);
                int gols_pro = Integer.parseInt(infos[7]);
                int gols_con = Integer.parseInt(infos[8]);
                int s_gols = Integer.parseInt(infos[9]);
                float aprov =  Float.parseFloat(infos[10]);
                
                Time n_time = new Time(nome, abrev, id, tecnicos, jogadores, pontos, n_jogos, n_emp, n_vit, gols_pro, gols_con, s_gols, aprov);
                times.add(n_time);
                
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro" + e.getMessage());
        }
    }

    ///////////// TIMES //////////////
    public ArrayList<Time> getTimes(){
        return times;
    }
    
    public void setTimes(ArrayList<Time> times){
        this.times = times;
    }

    public int getQntTimes(){
        return times.size();
    }

    public void insereTime(Time time){
        this.times.add(time);
    }
    
    public void editaTime(Time time, int pos){    
        this.times.add(pos, time);
    }

    public void removeTime(int pos){
        times.remove(pos);
    }

    ////////////// TECNICOS //////////////  
    public ArrayList<Tecnico> getTecnicos(int index_time){
        return times.get(index_time).getTecnicos();
    }

    public void setTecnicos(int index_time, ArrayList<Tecnico> tecnicos){
        times.get(index_time).setTecnico(tecnicos);
    }

    public int getQntTotalTecnicos(){
        return tcn_total;
    }

    public int getQntTecnicos(int index_time){
        return times.get(index_time).getQntTecnicos();
    }

    public void insereTecnico(Tecnico tecnico, int index_time){
        tecnicos = times.get(index_time).getTecnicos();
        tecnicos.add(tecnico); 
        times.get(index_time).setTecnico(tecnicos);
        tcn_total++;
    }
    
    public void editaTecnico(Tecnico tecnico, int index_time, int pos){
        tecnicos = times.get(index_time).getTecnicos();
        tecnicos.add(pos, tecnico); 
        times.get(index_time).setTecnico(tecnicos);
    }
    
    public void removeTecnico(int index_time, int pos){
        times.get(index_time).getTecnicos().remove(pos);
    }

    ////////////// JOGADORES //////////////
    public ArrayList<Jogador> getJogadores(int index_time){
        return times.get(index_time).getJogadores();
    }

    public void setJogadores(int index_time, ArrayList<Jogador> jogadores){
        times.get(index_time).setJogadores(jogadores);
    }

    public int getQntTotalJogadores(){
        return jgdrs_total;
    }

    public int getQntJogadores(int index_time){
        return times.get(index_time).getQntJogadores();
    }
    
    public void insereJogador(Jogador jogador, int index_time){
        jogadores = times.get(index_time).getJogadores();
        jogadores.add(jogador); 
        times.get(index_time).setJogadores(jogadores);
        jgdrs_total++;
    }
    
    public void editaJogador(Jogador jogador, int index_time, int pos){
        jogadores = times.get(index_time).getJogadores();
        jogadores.add(pos, jogador); 
        times.get(index_time).setJogadores(jogadores);
    }
    
    public void removeJogador(int index_time, int pos){
        times.get(index_time).getJogadores().remove(pos);
    }
}