package controller;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.comparator.*;
import model.*;
/**
 * Classe ControleDados reune, obtem e compila os dados de um jogador ou dos jogadores de um time para a camada de visualizacao  
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public class ControleDados {
    
    private Dados dados = new Dados();

    //// DADOS
    /**
     * Construtor ControleDados
     * Cria um novo objeto tipo dados que contem as estruturas de dados desejados a aprtir da leitura de um arquivo
     */
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
    /**
     * Metodo responssavel separar os dados de entrada do usuario adiciona-los ou edita-los nas estruturas de dados
     * @param d_time Array com os dados do time a ser adicionado ou editado
     * @param pos posicao do time na lista de times a ser editado
     * @param flag variaveel que nos diz se o time sera editado ou adiconado
     * @return retorna um boolean que indica o sucesso ou falha na adicao/edicao
     */
    public boolean insereEditaTime(String[] d_time, int pos, boolean flag){
        //Verifica a integridade dos dados
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
    
        if(flag) 
            dados.editaTime(aux,pos);
        else 
            dados.insereTime(aux);
        return true;
    }
    /**
     * Remove um time da lista de times
     * @param pos posicao do time na lista de times que sera removido
     * @return retorna um boolean que indica o sucesso ou falha na remocao do dado
     */
    public boolean removeTime(int pos){

        if(pos > dados.getQntTimes() || pos < 0){
            return false;
        }
        else{
            dados.removeTime(pos);
            return true;
        }
    }
    /**
     * Metodo que realiza a busca de um  time na lista de times por meio do seu nome
     * @param nome_time nome do time que sera buscado 
     */
    public int buscaTime(String nome_time){
        ArrayList<Time> aux = dados.getTimes();
        
        for(int pos_time = 0; pos_time < dados.getQntTimes(); pos_time++){
            if(aux.get(pos_time).getName().toLowerCase().equals(nome_time.toLowerCase())){
                return pos_time;
            }
        }
        return -1;
    }
    /**
     * Metodo que ordena a lista de times
     */
    public void ordenaTimes(){
        OrdenaTimes ordenacao = new OrdenaTimes();
        Collections.sort(dados.getTimes(), ordenacao);
    }

    /////////////// TECNICOS ///////////////
    public ArrayList<Tecnico> getTecnicos(int index_time){
        return dados.getTecnicos(index_time);
    }

    public int getQntTotalTecnicos(){
        return dados.getQntTotalTecnicos();
    }
    
    /**
     * Metodo responssavel separar os dados de entrada do usuario adiciona-los ou edita-los nas estruturas de dados lista de times
     * @param d_tecnico Array com os dados do tecnico a ser adicionado ou editado
     * @param index_time posicao do time na lista de times que recebera ou editara o tecnico
     * @param pos posicao do tecnico na lista de tecnicos de um time que sera editado ou adiconado
     * @param flag variavel que indica se os dados serao editados ou adicionados
     * @return retorna um boolean que indica o sucesso ou falha na edicao/adicao dos dados
     */
    public boolean insereEditaTecnico(String[] d_tecnico, int index_time, int pos, boolean flag){
        //Valida integridade dos dados
        for(int i = 1; i < 4; i++){
            if(!d_tecnico[i].matches("[0-9]+")){
                return false;
            }
        }

        Tecnico aux = new Tecnico(d_tecnico[0], Long.parseLong(d_tecnico[1]), 
                            Integer.parseInt(d_tecnico[2]), Integer.parseInt(d_tecnico[3]));
    
        aux.calc_aproveitamento(Integer.parseInt(d_tecnico[2]), Integer.parseInt(d_tecnico[3]));
        if(flag){
            dados.editaTecnico(aux, index_time, pos);
            return true;
        } else {
            dados.insereTecnico(aux, index_time);
            return true;   
        }
    }
    /**
     * Remove um tecnico da lista de tecnicos de um time
     * @param index_time posicao do time na lista de tmes que removera o tecnico
     * @param pos posicao do tecnico na lista de tecnicos de um time que sera removido
     * @return retorna um boolean que indica o sucesso ou falha na remocao dos dados
     */
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
    /**
     * Metodo responssavel separar os dados de entrada do usuario adiciona-los ou edita-los nas estruturas de dados lista de times
     * @param d_jogador Array com os dados do jogador a ser adicionado ou editado
     * @param index_time posicao do time na lista de times que recebera ou editara o jogador
     * @param pos posicao do jogador na lista de jogadores de um time que sera editado ou adiconado
     * @param flag variavel que indica se os dados serao editados ou adicionados
     * @return retorna um boolean que indica o sucesso ou falha na edicao/adicao dos dados
     */
    public boolean insereEditaJogador(String[] d_jogador, int index_time, int pos, boolean flag){
        //Valida integridade dos dados
        for(int i = 2; i < 5; i++){
            if(!d_jogador[i].matches("[0-9]+")){
                return false;
            }
        }

        Jogador aux = new Jogador(d_jogador[0], d_jogador[1], Long.parseLong(d_jogador[2]), 
                            Integer.parseInt(d_jogador[3]), Integer.parseInt(d_jogador[4]));
    
        if(flag)
            dados.editaJogador(aux, index_time, pos);
        else 
            dados.insereJogador(aux, index_time);
        return true;   
    }
    /**
     * Remove um jogador da lista de jogadores de um time
     * @param index_time posicao do time na lista de tmes que removera o jogador
     * @param pos posicao do jogador na lista de jogadores de um time que sera removido
     * @return retorna um boolean que indica o sucesso ou falha na remocao dos dados
     */
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
