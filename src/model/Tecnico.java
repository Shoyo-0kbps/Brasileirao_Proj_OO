package model;

public class Tecnico extends Pessoa{
    
    private float taxa_aproveitamento;
    private int num_jogos;
    private int num_vitorias;

    public Tecnico(){
        super();
    }

    public Tecnico(String nome){
        super(nome, "tecnico");       
    }

    public Tecnico(String nome, long id){
        super(nome, "tecnico", id);               
    }
    
    public Tecnico(String nome, long id, int num_jogos, int num_vitorias){
        super(nome, "tecnico", id);  
        this.num_jogos = num_jogos;             
        this.num_vitorias = num_vitorias;
    }

    public float getTaxaAproveitamento(){
        return taxa_aproveitamento;
    }

    public void setTaxaAproveitamento(float taxa_aproveitamento){
        this.taxa_aproveitamento = taxa_aproveitamento;
    }

    public int getNumJogos(){
        return num_jogos;
    }
    
    public void setNumJogos(int num_jogos){
        this.num_jogos = num_jogos;
    }

    public int getNumVitorias(){
        return num_vitorias;
    }
    
    public void setNumVitorias(int num_vitorias){
        this.num_vitorias = num_vitorias;
    }

    public void calc_aproveitamento(int num_jogos, int num_vitorias){
        taxa_aproveitamento = ((num_vitorias / num_jogos)*100);
    }    
}

