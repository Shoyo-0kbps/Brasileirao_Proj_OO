package model;
import java.util.ArrayList;

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
   
   public void incPts(int ptsAcr){
      pontos += ptsAcr;
   }

   public int getNumJogos(){
      return num_jogos;
   }
   
   public void setNumJogos(int num_jogos){
      this.num_jogos = num_jogos;
   }
   
   public void incNumJgs(){
      num_jogos += 1;
   }

   public int getNumEmpates(){
      return num_empates;
   }
   
   public void setNumEmpates(int num_empates){
      this.num_empates = num_empates;
   }

   public void incNumEpt(){
      num_empates += 1;  
   }

   public int getNumVitorias(){
      return num_vitorias;
   }
   
   public void setNumVitorias(int num_vitorias){
      this.num_vitorias = num_vitorias;
   }

   public void incNumVts(){
      num_vitorias += 1;
   }

   public int getGolsPro(){
      return gols_pro;
   }
   
   public void setGolsPro(int gols_pro){
      this.gols_pro = gols_pro;
   }

   public void incGolsPro(int num_gols){
      gols_pro += num_gols;
   }

   public int getGolsCon(){
      return gols_contra;
   }
   
   public void setGolsCon(int gols_contra){
      this.gols_contra = gols_contra;
   }

   public void incGolsCon(int num_gols){
      gols_contra += num_gols;
   }

   public int getSaldGols(){
      return gols_contra;
   }
   
   public void setSaldGols(int saldo_gols){
      this.saldo_gols = saldo_gols;
   }

   public int calcSaldo(){
      return this.gols_pro + this.gols_contra;
   }

   public float getTaxaAproveitamento(){
      return aproveitamento;
   }

   public void setTaxaAproveitamento(float aproveitamento){
      this.aproveitamento = aproveitamento;
   }  

   public float calcAprov(){
      return ((pontos/num_jogos) * (100/3));
   }

   public ArrayList<Tecnico> getTecnicos(){
      return tecnico;
   } 
   
   public void setTecnico(ArrayList<Tecnico> tecnico){
      this.tecnico = tecnico;
   }
  
   public int getQntTecnicos(){
      return tecnico.size();
   }

   public ArrayList<Jogador> getJogadores(){
      return jogadores;
   }

   public void setJogadores(ArrayList<Jogador> jogadores){
      this.jogadores = jogadores;
   }

   public int getQntJogadores(){
      return jogadores.size();
   }
}