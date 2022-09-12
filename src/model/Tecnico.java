package model;
/**
 * Classe Tecnico simula o comportamento de um tecnico no sistema proposta e extende o comportamento da classe abstrata Pessoa
 * @author Francisco Mizael Santos da Silva
 * @since 2022
 * @version 1.0
 */
public class Tecnico extends Pessoa{
    
    private float taxa_aproveitamento;
    private int num_jogos;
    private int num_vitorias;
    /**
    * Construtor do Tecnico
    */
    public Tecnico(){
        super();
    }
    /**
 	* Construtor do Tecnico
 	* @param nome do tecnico
 	*/
    public Tecnico(String nome){
        super(nome, "tecnico");       
    }
    /**
 	* Construtor do tecnico
 	* @param nome nome do tecnico
 	* @param id identificador do tecnico no sistema
 	*/
    public Tecnico(String nome, long id){
        super(nome, "tecnico", id);               
    }
    /**
     * Construtor do tecnico
     * @param nome nome do tecnico
     * @param id identificador do tecnico no sistema
     * @param num_jogos numero de jogos que participou
     * @param num_vitorias numero de vitorias que obteve
     */
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
    /**
     * Calcula a taxa de aproveitamento do tecnico
     * @param num_jogos numnero de jogos que participou
     * @param num_vitorias numero de vitorias que obteve
     */
    public void calc_aproveitamento(int num_jogos, int num_vitorias){
        taxa_aproveitamento = ((num_vitorias / num_jogos)*100);
    }    
}

