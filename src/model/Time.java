package model;
import java.util.ArrayList;
/**
 * Classe Time simula o comportamento de um time na tebala do campeonato Brasileiro
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public class Time {
   private String name;
   private String abrev;
   private long id;
   private int pontos;
   private int num_jogos;
   private int num_empates; 
   private int num_vitorias;
   private int gols_pro;
   private int gols_contra;
   private int saldo_gols;
   private float aproveitamento;
   private ArrayList<Tecnico> tecnico;
   private ArrayList<Jogador> jogadores;
   /**
    * Construtor time
    * @param name o nome do time
    * @param abrev abreviatura do time
    * @param id identificador do time no sistema
    */
   public Time(String name, String abrev, long id){
      this.name = name;
      this.abrev = abrev;
      this.id = id;
      pontos = 0;
      num_jogos = 0;
      num_empates = 0;
      num_vitorias = 0;
      gols_pro = 0;
      gols_contra = 0;
      saldo_gols = 0;
      aproveitamento = 0;
   }
   /**
    * Construtor Time
    * @param name nome do time
    * @param abrev abreviatura do time
    * @param id identificador do time no sistema
    * @param tecnico objeto que contem uma lista da Classe Tecnico
    */
   public Time(String name, String abrev, long id, ArrayList<Tecnico> tecnico){
      this.name = name;
      this.abrev = abrev;
      this.id = id;
      pontos = 0;
      num_jogos = 0;
      num_empates = 0;
      num_vitorias = 0;
      gols_pro = 0;
      gols_contra = 0;
      saldo_gols = 0;
      aproveitamento = 0;
      this.tecnico = tecnico;
   }
   /**
    * Construtor Time
    * @param name nome do time
    * @param abrev abreviatura do time
    * @param id identificador do time no sistema
    * @param tecnico objeto que contem uma lista da Classe Tecnico
    * @param jogadores objeto que contem uma lista da Classe Jogador
    */
   public Time(String name, String abrev, long id, ArrayList<Tecnico> tecnico, ArrayList<Jogador> jogadores){
      this.name = name;
      this.abrev = abrev;
      this.id = id;
      pontos = 0;
      num_jogos = 0;
      num_empates = 0;
      num_vitorias = 0;
      gols_pro = 0;
      gols_contra = 0;
      saldo_gols = 0;
      aproveitamento = 0;
      this.tecnico = tecnico;
      this.jogadores = jogadores;
   }
   /**
    * Construtor com os dados do Time
    * @param name nome do time
    * @param abrev abreviatura do time
    * @param id identificador do time no sistema
    * @param pontos pontos do time
    * @param num_jogos numero de jogos realizados 
    * @param num_empates numero de empates 
    * @param num_vitorias numero de vitorias 
    * @param gols_pro gols realizados
    * @param gols_contra gols sofridos
    * @param saldo_gols saldo de gols 
    * @param aproveitamento aproveitamento 
    */
   public Time(String name, String abrev, long id, int pontos, int num_jogos, 
               int num_empates, int num_vitorias, int gols_pro, int gols_contra, 
               int saldo_gols, float aproveitamento){
      
      this.name = name;
      this.abrev = abrev;
      this.id = id;
      this.pontos = pontos;
      this.num_jogos = num_jogos;
      this.num_empates = num_empates;
      this.num_vitorias = num_vitorias;
      this.gols_pro = gols_pro;
      this.gols_contra = gols_contra;
      this.saldo_gols = saldo_gols;
      this.aproveitamento = aproveitamento;
   }
   /**
    * Construtor completo do time
    * @param name nome do time
    * @param abrev abreviatura do time
    * @param id identificador do time no sistema
    * @param tecnico objeto que contem uma lista da Classe Tecnico
    * @param jogadores objeto que contem uma lista da Classe Jogador
    * @param pontos pontos do time
    * @param num_jogos numero de jogos realizados 
    * @param num_empates numero de empates 
    * @param num_vitorias numero de vitorias 
    * @param gols_pro gols realizados
    * @param gols_contra gols sofridos
    * @param saldo_gols saldo de gols 
    * @param aproveitamento aproveitamento 
    */
   public Time(String name, String abrev, long id, ArrayList<Tecnico> tecnico, ArrayList<Jogador> jogadores,
               int pontos, int num_jogos, int num_empates, int num_vitorias, int gols_pro,
               int gols_contra, int saldo_gols, float aproveitamento){
      
      this.name = name;
      this.abrev = abrev;
      this.id = id;
      this.pontos = pontos;
      this.num_jogos = num_jogos;
      this.num_empates = num_empates;
      this.num_vitorias = num_vitorias;
      this.gols_pro = gols_pro;
      this.gols_contra = gols_contra;
      this.saldo_gols = saldo_gols;
      this.aproveitamento = aproveitamento;
      this.tecnico = tecnico;
      this.jogadores = jogadores;
   }

   public String getName(){
      return name;
   }
   
   public void setName(String name){
      this.name = name;
   }

   public String getAbrev(){
      return abrev;
   }
   
   public void setAbrev(String abrev){
      this.abrev = abrev;
   }

   public long getID(){
      return id;
   }
   
   public void setID(long id){
      this.id = id;
   }

   public int getPontos(){
      return pontos;
   }
   
   public void setPontos(int pontos){
      this.pontos = pontos;
   }
   
   public int getNumJogos(){
      return num_jogos;
   }
   
   public void setNumJogos(int num_jogos){
      this.num_jogos = num_jogos;
   }
   
   public int getNumEmpates(){
      return num_empates;
   }
   
   public void setNumEmpates(int num_empates){
      this.num_empates = num_empates;
   }

   public int getNumVitorias(){
      return num_vitorias;
   }
   
   public void setNumVitorias(int num_vitorias){
      this.num_vitorias = num_vitorias;
   }

   public int getGolsPro(){
      return gols_pro;
   }
   
   public void setGolsPro(int gols_pro){
      this.gols_pro = gols_pro;
   }

   public int getGolsCon(){
      return gols_contra;
   }
   
   public void setGolsCon(int gols_contra){
      this.gols_contra = gols_contra;
   }

   public int getSaldGols(){
      return gols_contra;
   }
   
   public void setSaldGols(int saldo_gols){
      this.saldo_gols = saldo_gols;
   }
   /**
    * Calcula o saldo de gols do time
    * @return <code>Integer<code> com o valor do saldo de gols 
    */
   public int calcSaldo(){
      return this.gols_pro + this.gols_contra;
   }

   public float getTaxaAproveitamento(){
      return aproveitamento;
   }

   public void setTaxaAproveitamento(float aproveitamento){
      this.aproveitamento = aproveitamento;
   }  
   
   /**
    * Calcula taxa de aproveitamento 
    * @return <code>Float<code> com o valor da taxa de aproveitamento do time
    */
   public float calcAprov(){
      return ((pontos/num_jogos) * (100/3));
   }

   public ArrayList<Tecnico> getTecnicos(){
      return tecnico;
   } 
   
   public void setTecnico(ArrayList<Tecnico> tecnico){
      this.tecnico = tecnico;
   }
   /**
    * 
    * @return retorna o tamanho da lista com tecnicos
    */
   public int getQntTecnicos(){
      return tecnico.size();
   }

   public ArrayList<Jogador> getJogadores(){
      return jogadores;
   }

   public void setJogadores(ArrayList<Jogador> jogadores){
      this.jogadores = jogadores;
   }
   /**
    * 
    * @return retorna o tamanho da lista com jogadores
    */
   public int getQntJogadores(){
      return jogadores.size();
   }
}