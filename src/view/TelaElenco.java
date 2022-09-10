package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;


public class TelaElenco implements ActionListener, ListSelectionListener {
    
    private static JFrame janela = new JFrame("Elenco");
	private static JLabel titulo = new JLabel("Elenco");
    private static JButton botaoAdicionarT = new JButton("Adicionar T");
    private static JButton botaoAdicionarJ = new JButton("Adicionar J");
	private static JButton botaoAtualizar = new JButton("Atualizar");
    private static ControleDados dados =  new ControleDados();
	private JList<String> listaTecnicos;
	private JList<String> listaJogadores;
    private String[] listaNomesTec = new String[5];
    private String[] listaNomesJog = new String[10];
    private int pos;

    public void mostraElenco(ControleDados dados, int pos){
        
        this.pos = pos;
        
        listaNomesTec = new ControleTecnico(dados, pos).getNomeTecnicos();
        listaNomesJog = new ControleJogador(dados, pos).getNomeJogadores();
        listaTecnicos = new JList<String>(listaNomesTec);
        listaJogadores = new JList<String>(listaNomesJog);

        titulo.setFont(new Font("Arial", Font.BOLD, 12));
		titulo.setBounds(190, 10, 250, 30);
        listaTecnicos.setBounds(40, 50, 150, 350);
        listaJogadores.setBounds(255, 50, 150, 350);
        
        listaTecnicos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaJogadores.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        listaTecnicos.setVisibleRowCount(10);
        listaJogadores.setVisibleRowCount(10);

        botaoAdicionarT.setBounds(25, 450, 125, 30);
        botaoAdicionarJ.setBounds(160, 450, 125, 30);
        botaoAtualizar.setBounds(295, 450, 125, 30);
        
        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaTecnicos);
        janela.add(listaJogadores);
        janela.add(botaoAdicionarT);
        janela.add(botaoAdicionarJ);
        janela.add(botaoAtualizar);

		janela.setSize(445, 550);
		janela.setVisible(true);
    
        botaoAdicionarT.addActionListener(this);
        botaoAdicionarJ.addActionListener(this);
        botaoAtualizar.addActionListener(this);
        listaTecnicos.addListSelectionListener(this);
        listaJogadores.addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
	    Object src = e.getSource();
        
        if(src == botaoAdicionarT){
            //new TelaCadastroTime().insereEditaTime(false, dados, -1);
        }
        
        if(src == botaoAdicionarJ){
            //new TelaCadastroTime().insereEditaTime(false, dados, -1);
        }

        if(src == botaoAtualizar){
            listaTecnicos.setListData(new ControleTecnico(dados, pos).getNomeTecnicos());
            listaJogadores.setListData(new ControleJogador(dados, pos).getNomeJogadores());
            /// TODO SALVAR DADOS
            listaTecnicos.updateUI();
            listaJogadores.updateUI();
        }
    }

    public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
        if(e.getValueIsAdjusting() && src == listaJogadores) {
            //
        }
        if(e.getValueIsAdjusting() && src == listaTecnicos) {
            //
        }
    }
}
