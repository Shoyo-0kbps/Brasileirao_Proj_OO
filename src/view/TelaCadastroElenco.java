package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;
import model.Dados;
import model.Tecnico;

public class TelaCadastroElenco implements ActionListener {

    //JLabels e respectivo JTexField
    private JFrame janela;
    private static JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
    private static JLabel labelPos = new JLabel("Posicao: ");
	private JTextField valorPos;
    private static JLabel labelID = new JLabel("ID: ");
	private JTextField valorID;
    private static JLabel labelSaldGols = new JLabel("Saldo Gols: ");
	private JTextField valorSaldGols;
    private static JLabel labelNCam = new JLabel("N Camisa: ");
	private JTextField valorNCam;
    private static JLabel labelNJogos = new JLabel("N Jogos: ");
	private JTextField valorNJogos;
    private static JLabel labelNVit = new JLabel("Vitorias: ");
	private JTextField valorNVit;
    //Botoes
    private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
    //Dados
    private ControleDados dados;
    private String[] n_dado = new String[5];
    private int flag;
    private int pos_time;
    private int pos;
    private String aux;

    public void insereEditaElenco(int flag, ControleDados dados, int pos_time, int pos) {

        ControleJogador jogador = new ControleJogador(dados,pos_time);
        ControleTecnico tecnico = new ControleTecnico(dados,pos_time);

        this.dados = dados;
        this.flag = flag;
        this.pos_time = pos_time;
        this.pos = pos;

        janela = new JFrame("Cadastro Time");

        if(flag ==  0){ // Cria novo jogador

            janela = new JFrame("Cadastro Jogador");
            
            valorNome = new JTextField(200);
            valorPos = new JTextField(200);
            valorID = new JTextField(200);
            valorSaldGols = new JTextField(200);
            valorNCam = new JTextField(200);
        
        } 
        else if(flag == 1) { // Edita Jogador
            
            valorNome = new JTextField(jogador.getNome(pos), 200);
            valorPos = new JTextField(jogador.getPosicao(pos), 200);
            valorID = new JTextField(jogador.getID(pos), 200);
            valorSaldGols = new JTextField(jogador.getSaldGols(pos), 200);
            valorNCam = new JTextField(jogador.getNumCamisa(pos), 200);
        
        } else if(flag == 2) { // Cria novo Tecnico
            
            valorNome = new JTextField(200);
            valorID = new JTextField(200);
            valorNJogos =  new JTextField(200);
            valorNVit =  new JTextField(200);

        } else if(flag == 3) { // Edita Tecnico

            valorNome = new JTextField(tecnico.getNome(pos), 200);
            valorID = new JTextField(tecnico.getID(pos), 200);
            valorNJogos =  new JTextField(tecnico.getNumJogos(pos), 200);
            valorNVit =  new JTextField(tecnico.getNumVitorias(pos), 200);
        
        }

        // Cria botoes de acordo com a flag
        if(flag == 0 || flag == 2)
            botaoSalvar.setBounds(170, 350, 125, 30);
        else{
            botaoSalvar.setBounds(40, 350, 125, 30);
            botaoExcluir.setBounds(300, 350, 125, 30);
        }

        // Cria dados em comum jogador tecnico
        labelNome.setBounds(40, 20, 150, 20);
		valorNome.setBounds(200, 20, 180, 20);
		labelID.setBounds(40, 45, 150, 20);
		valorID.setBounds(200, 45, 180, 20);
        
        this.janela.add(labelNome);
        this.janela.add(labelID);
        
        this.janela.add(valorNome);
        this.janela.add(valorID);

        // Adiciona elementos
        if(flag == 0 || flag == 1){
            
            labelPos.setBounds(40, 70, 150, 20);
            valorPos.setBounds(200, 70, 180, 20);		
            labelSaldGols.setBounds(40, 95, 150, 20);
            valorSaldGols.setBounds(200, 95, 180, 20);
            labelNCam.setBounds(40, 120, 150, 20);
            valorNCam.setBounds(200, 120, 180, 20);
            
            this.janela.add(labelPos);
            this.janela.add(labelSaldGols);
            this.janela.add(labelNCam);
            this.janela.add(valorPos);
            this.janela.add(valorSaldGols);
            this.janela.add(valorNCam);
            this.janela.add(botaoSalvar);
            if(flag == 1)
                this.janela.add(botaoExcluir);
        } 
        
        if(flag == 2 || flag == 3){
            
            labelNJogos.setBounds(40, 70, 150, 20);
            valorNJogos.setBounds(200, 70, 180, 20);
            labelNVit.setBounds(40, 95, 150, 20);
            valorNVit.setBounds(200, 95, 180, 20);
            
            this.janela.add(labelNJogos);
            this.janela.add(labelNVit);
            this.janela.add(valorNJogos);
            this.janela.add(valorNVit);
            this.janela.add(botaoSalvar);
            if(flag == 3)
                this.janela.add(botaoExcluir);
        } 

        //Janela
        this.janela.setLayout(null);
		this.janela.setSize(465, 500);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
        // Envia dados a ser salvo ou excluidos para controle
        if(src == botaoSalvar) {
            try{
                boolean res = false;

                if(flag == 0 || flag == 1){
                    n_dado[0] = valorNome.getText();
                    n_dado[1] = valorPos.getText();
                    n_dado[2] = valorID.getText();
                    n_dado[3] = valorSaldGols.getText();
                    n_dado[4] = valorNCam.getText();
                    if(flag == 0)
                        res = dados.insereEditaJogador(n_dado, pos_time, pos, false);
                    else res = dados.insereEditaJogador(n_dado, pos_time, pos, true);
                }

                if(flag == 2 || flag == 3){
                    n_dado[0] = valorNome.getText();
                    n_dado[1] = valorID.getText();
                    n_dado[2] = valorNJogos.getText();
                    n_dado[3] = valorNVit.getText();
                    if(flag == 2)
                        res = dados.insereEditaTecnico(n_dado, pos_time, pos, false);
                    else res = dados.insereEditaTecnico(n_dado, pos_time, pos, true);
                } 

                if(res) {
					mensagemSucessoCadastro();
				} else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}       
        }

        if(src == botaoExcluir)  {
			boolean res = false;
            if(flag == 1){
                res = dados.removeJogador(pos_time, pos);
                if(res)
                    mensagemSucessoExclusao();
                else mensagemErroExclusa();
            }
            else {
                res = dados.removeTecnico(pos_time, pos);
                if(res)
                    mensagemSucessoExclusao();
                else mensagemErroExclusa();
            }
        }
    }
    
    public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

    public void mensagemErroExclusa() {
		JOptionPane.showMessageDialog(null,
        "ERRO AO EXCLUIR OS DADOS!\n ", null, JOptionPane.ERROR_MESSAGE);
	}
	
    public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
    public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
        "ERRO AO SALVAR OS DADOS!\nOS DADOS PREENCHIDOS POSSUEM FORMATO\nINVALIDOS!!", null, JOptionPane.ERROR_MESSAGE);
	}
}