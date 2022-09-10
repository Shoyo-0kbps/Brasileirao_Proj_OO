package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;


public class TelaTabela implements ActionListener, ListSelectionListener {
    
    private static JFrame janela = new JFrame("Brasileirao");
	private static JLabel titulo = new JLabel("Tabela");
    private static JButton botaoAdicionar = new JButton("Adicionar");
	private static JButton botaoAtualizar = new JButton("Atualizar");
    private static ControleDados dados =  new ControleDados();
	private JList<String> listaTimes;
    private String[] listaNomes = new String[20];

    TelaTabela(){
        listaNomes = new ControleTime(dados).getNomeTimes();
        listaTimes = new JList<String>(listaNomes);


        titulo.setFont(new Font("Arial", Font.BOLD, 12));
		titulo.setBounds(190, 10, 250, 30);
        listaTimes.setBounds(10, 50, 150, 350);
        listaTimes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaTimes.setVisibleRowCount(10);

        botaoAdicionar.setBounds(40, 450, 100, 30);
        botaoAtualizar.setBounds(320, 450, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaTimes);
        janela.add(botaoAdicionar);
        janela.add(botaoAtualizar);

		janela.setSize(450, 550);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
    
        botaoAdicionar.addActionListener(this);
        botaoAtualizar.addActionListener(this);
        listaTimes.addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
	    Object src = e.getSource();
        
        if(src == botaoAdicionar){
            new TelaCadastroTime().insereEditaTime(false, dados, -1);
        }

        if(src == botaoAtualizar){
            listaTimes.setListData(new ControleTime(dados).getNomeTimes());
            /// TODO SALVAR DADOS
            listaTimes.updateUI();
        }
    }

    public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
        if(e.getValueIsAdjusting() && src == listaTimes) {
            new TelaCadastroTime().insereEditaTime(true, dados, listaTimes.getSelectedIndex());
        }
    }
}
