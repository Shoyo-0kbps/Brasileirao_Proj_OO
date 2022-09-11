package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Classe Dados se responsabiliza por criar, alocar, manupular e obter todas as estruturas de dados do sistema
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public class Dados {
    
    ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    int jgdrs_total = 0;
    ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
    int tcn_total = 0;
    ArrayList<Time> times = new ArrayList<Time>(); 
    /**
     * Metodo responsavel por ler os dados de um arquivo, e criar as estruturas do times em formato de lista
     */
    public void lerDadosTime(){
        String path = "src/misc/";
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
    /**
     * Metodo responsavel por inserir um novo time na lista
     * @param time Um novo tima a ser inserido
     */
    public void insereTime(Time time){
        this.times.add(time);
    }
    /**
     * Edita um  time ja existente, deletando o objeto time anterior e adicionando um novo na mesma posicao da lista mas com atributos modificados
     * @param time novo time com os dados atualizados
     * @param pos posicao no time a ser editado na lista de times
     */
    public void editaTime(Time time, int pos){    
        this.times.remove(pos);
        this.times.add(pos, time);
    }
    /**
     * Remove um time ja existente
     * @param pos posicao no time a ser editado na lista de times
     */
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
    /**
     * Insere um novo tecnico na lista de tecnicos de um time
     * @param tecnico novo tecnico a ser inserido 
     * @param index_time posicao do time na lista de times que recebera o novo tecnico
     */
    public void insereTecnico(Tecnico tecnico, int index_time){
        tecnicos = times.get(index_time).getTecnicos();
        tecnicos.add(tecnico); 
        times.get(index_time).setTecnico(tecnicos);
        tcn_total++;
    }
    /**
     * Edita um tecnico ja existente na lista de tecnicos de um time
     * Deleta o antigo objeto tecnico presenta na lista de tecnicos de um time e em seguida insere um novo objeto tecnico 
     * na mesma posicao porem com atributos atualizados.
     * @param tecnico novo tecnico a ser inserido 
     * @param index_time posicao do time na lista de times que recebera o novo objeto tecnico
     * @param pos posicao do tecnico na lista de tecnicos do time que sera editado
     */
    public void editaTecnico(Tecnico tecnico, int index_time, int pos){
        tecnicos = times.get(index_time).getTecnicos();
        tecnicos.remove(pos);
        tecnicos.add(pos, tecnico); 
        times.get(index_time).setTecnico(tecnicos);
    }
    /**
     * Remove um tecnico ja existente da lista de tecnicos de um time 
     * @param index_time posicao do time na lista de times que removera o tecnico
     * @param pos posicao do tecnico na lista de tecnicos de um time que sera deletado
     */
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
    /**
     * Insere um novo jogador na lista de jogadores de um time
     * @param jogador novo jogador a ser inserido 
     * @param index_time posicao do time na lista de times que recebera o novo jogador
     */
    public void insereJogador(Jogador jogador, int index_time){
        jogadores = times.get(index_time).getJogadores();
        jogadores.add(jogador); 
        times.get(index_time).setJogadores(jogadores);
        jgdrs_total++;
    }
    /**
     * Edita um jogador ja existente na lista de jogadores de um time
     * Deleta o antigo objeto jogador presenta na lista de jogadores de um time e em seguida insere um novo objeto jogador 
     * na mesma posicao do deletado porem com os atributos atualizados.
     * @param jogador novo jogador a ser inserido 
     * @param index_time posicao do time na lista de times que recebera o novo jogador
     * @param pos posicao do jogador na lista de jogadores de um time que sera editado
     */
    public void editaJogador(Jogador jogador, int index_time, int pos){
        jogadores = times.get(index_time).getJogadores();
        jogadores.remove(pos);
        jogadores.add(pos, jogador); 
        times.get(index_time).setJogadores(jogadores);
    }
    /**
     * Remove um jogador ja existente da lista de jpgadores de um time 
     * @param index_time posicao do time na lista de times que removera o jogador
     * @param pos posicao do jogadopr na lista de jpgadores de um time que sera deletado
     */
    public void removeJogador(int index_time, int pos){
        times.get(index_time).getJogadores().remove(pos);
    }
}