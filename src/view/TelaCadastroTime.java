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

public class TelaCadastroTime implements ActionListener {

    private JFrame janela;
    private static JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
    private static JLabel labelAbrev = new JLabel("Abreviatura: ");
	private JTextField valorAbrev;
    private static JLabel labelID = new JLabel("ID: ");
	private JTextField valorID;
    private static JLabel labelPontos = new JLabel("Pontos: ");
	private JTextField valorPontos;
    private static JLabel labelNJogos = new JLabel("N Jogos: ");
	private JTextField valorNJogos;
    private static JLabel labelEmpates = new JLabel("Empates: ");
	private JTextField valorEmpates;
    private static JLabel labelVitorias = new JLabel("Vitorias: ");
	private JTextField valorVitorias;
    private static JLabel labelGPro = new JLabel("Gols Pro: ");
	private JTextField valorGPro;
    private static JLabel labelGCon = new JLabel("Gols Con: ");
	private JTextField valorGCon;
    private static JLabel labelSGols = new JLabel("Sald Gols: ");
	private JTextField valorSGols;
    private static JLabel labelAprov = new JLabel("Aprov: ");
	private JTextField valorAprov;
    private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoJogadores = new JButton("Jogadores");
    private ControleDados dados;
    private String[] n_dado = new String[11];
    private boolean flag;
    private int pos;
    private String aux;

    public void insereEditaTime(boolean flag, ControleDados dados, int pos) {

        ControleTime time = new ControleTime(dados);
        this.dados = dados;
        this.flag = flag;
        this.pos = pos;

        janela = new JFrame("Cadastro Time");

        if(flag){
            valorNome = new JTextField(time.getNome(pos), 200);
            valorAbrev = new JTextField(time.getAbrev(pos), 200);
            valorID = new JTextField(time.getID(pos), 200);
            valorPontos = new JTextField(time.getPontos(pos), 200);
            valorNJogos = new JTextField(time.getNumJogos(pos), 200);
            valorVitorias = new JTextField(time.getNumVitorias(pos), 200);
            valorEmpates = new JTextField(time.getNumEmpates(pos), 200);
            valorGPro = new JTextField(time.getGolsPro(pos), 200);
            valorGCon = new JTextField(time.getGolsCon(pos), 200);
            valorSGols = new JTextField(time.getSaldGols(pos), 200);
            valorAprov = new JTextField(time.getAprov(pos), 200);

        }
        else{
            valorNome = new JTextField(200);
            valorAbrev = new JTextField(200);
            valorID = new JTextField(200);
            valorPontos = new JTextField(200);
            valorNJogos = new JTextField(200);
            valorEmpates = new JTextField(200);
            valorVitorias = new JTextField(200);
            valorGPro = new JTextField(200);
            valorGCon =  new JTextField(200);
            valorSGols = new JTextField(200);
            valorAprov = new JTextField(200);
        }
    	
        
        botaoJogadores.setBounds(40, 350, 125, 30);
        botaoSalvar.setBounds(170, 350, 125, 30);
        botaoExcluir.setBounds(300, 350, 125, 30);
        
        labelNome.setBounds(40, 20, 150, 20);
		valorNome.setBounds(200, 20, 180, 20);
		labelAbrev.setBounds(40, 45, 150, 20);
		valorAbrev.setBounds(200, 45, 180, 20);
		labelID.setBounds(40, 70, 150, 20);
		valorID.setBounds(200, 70, 180, 20);		
		labelPontos.setBounds(40, 95, 150, 20);
		valorPontos.setBounds(200, 95, 180, 20);
		labelNJogos.setBounds(40, 120, 150, 20);
		valorNJogos.setBounds(200, 120, 180, 20);
		labelEmpates.setBounds(40, 145, 150, 20);
		valorEmpates.setBounds(200, 145, 180, 20);
		labelVitorias.setBounds(40, 170, 150, 20);
		valorVitorias.setBounds(200, 170, 180, 20);
		labelGPro.setBounds(40, 195, 150, 20);
		valorGPro.setBounds(200, 195, 180, 20);
		labelGCon.setBounds(40, 220, 150, 20);
		valorGCon.setBounds(200, 220, 180, 20);
		labelSGols.setBounds(40, 245, 150, 20);
		valorSGols.setBounds(200, 245, 180, 20);
		labelAprov.setBounds(40, 270, 150, 20);
		valorAprov.setBounds(200, 270, 180, 20);
        
        this.janela.add(labelNome);
        this.janela.add(labelAbrev);
        this.janela.add(labelID);
        this.janela.add(labelPontos);
        this.janela.add(labelNJogos);
        this.janela.add(labelEmpates);
        this.janela.add(labelVitorias);
        this.janela.add(labelGPro);
        this.janela.add(labelGCon);
        this.janela.add(labelSGols);
        this.janela.add(labelAprov);
        
        this.janela.add(valorNome);
        this.janela.add(valorAbrev);
        this.janela.add(valorID);
        this.janela.add(valorPontos);
        this.janela.add(valorNJogos);
        this.janela.add(valorEmpates);
        this.janela.add(valorVitorias);
        this.janela.add(valorGPro);
        this.janela.add(valorGCon);
        this.janela.add(valorSGols);
        this.janela.add(valorAprov);
        this.janela.add(botaoSalvar);

        if(flag){
            this.janela.add(botaoJogadores);
            this.janela.add(botaoExcluir);
        } 

        this.janela.setLayout(null);

		this.janela.setSize(465, 500);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoJogadores.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
            try{
                boolean res;

                n_dado[0] = valorNome.getText();
                n_dado[1] = valorAbrev.getText();
                n_dado[2] = valorID.getText();
                n_dado[3] = valorPontos.getText();
                n_dado[4] = valorNJogos.getText();
                n_dado[5] = valorEmpates.getText();
                n_dado[6] = valorVitorias.getText();
                n_dado[7] = valorGPro.getText();
                n_dado[8] = valorGCon.getText();
                n_dado[9] = valorSGols.getText();
                n_dado[10] = valorAprov.getText();

                if(flag){
                    res = dados.insereEditaTime(n_dado, pos, true);
                } else  res = dados.insereEditaTime(n_dado, pos, false);
                
                if(res) {
					mensagemSucessoCadastro();
				} else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}       
        }

        if(src == botaoExcluir) {
			boolean res = false;
            res = dados.removeTime(pos);
            if(res){
                mensagemSucessoExclusao();
            } else mensagemErroExclusa();
        }

        if(src == botaoJogadores){
            new TelaElenco().mostraElenco(dados, pos);
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
        "ERRO AO SALVAR OS DADOS!\n ", null, JOptionPane.ERROR_MESSAGE);
	}
}