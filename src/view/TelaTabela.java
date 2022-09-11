package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;


public class TelaTabela implements ActionListener, ListSelectionListener {
    
    //JLabels
    private static JFrame janela = new JFrame("Brasileirao");
	private static JLabel tms = new JLabel("Times");
	private static JLabel pts = new JLabel("P");
	private static JLabel jgs = new JLabel("J");
	private static JLabel vit = new JLabel("V");
	private static JLabel emp = new JLabel("E");
    //JtexField
    private static JTextField valorBusca = new JTextField(200);
    //Botoes
    private static JButton botaoAdicionar = new JButton("Adicionar");
	private static JButton botaoAtualizar = new JButton("Atualizar");
	private static JButton botaoBuscar = new JButton("Buscar");
    //Dados
    private static ControleDados dados =  new ControleDados();
	private JList<String> listaTimes;
	private JList<String> listaPontos;
	private JList<String> listaNJogos;
	private JList<String> listaVitorias;
	private JList<String> listaEmpates;
    private String[] listaNomesT = new String[20];
    private String[] listaPontosT = new String[20];
    private String[] listaNJogosT = new String[20];
    private String[] listaVitoriasT = new String[20];
    private String[] listaEmpatesT = new String[20];

    TelaTabela(){
        dados.ordenaTimes();

        //Jlabels
        tms.setFont(new Font("Arial", Font.BOLD, 12));
        pts.setFont(new Font("Arial", Font.BOLD, 12));
        jgs.setFont(new Font("Arial", Font.BOLD, 12));
        vit.setFont(new Font("Arial", Font.BOLD, 12));
        emp.setFont(new Font("Arial", Font.BOLD, 12));
		tms.setBounds(10, 45, 100, 30);
		pts.setBounds(175, 45, 20, 30);
		jgs.setBounds(205, 45, 20, 30);
		vit.setBounds(235, 45, 20, 30);
		emp.setBounds(265, 45, 20, 30);
        // JTexField
        valorBusca.setBounds(225,10,100,20);
        // Botoes
        botaoAdicionar.setBounds(40, 450, 100, 30);
        botaoAtualizar.setBounds(320, 450, 100, 30);
        botaoBuscar.setBounds(330,10,100,20);
        
        // JLIsts
        listaNomesT = new ControleTime(dados).getNomeTimes();
        listaPontosT = new ControleTime(dados).getPontosTimes();
        listaNJogosT = new ControleTime(dados).getNJogos();
        listaVitoriasT = new ControleTime(dados).getNVitorias();
        listaEmpatesT = new ControleTime(dados).getNEmpates();
        
        listaTimes = new JList<String>(listaNomesT);
        listaPontos = new JList<String>(listaPontosT);
        listaNJogos = new JList<String>(listaNJogosT);
        listaVitorias = new JList<String>(listaVitoriasT);
        listaEmpates = new JList<String>(listaEmpatesT);
        
        // Bounds JLists
        listaTimes.setBounds(10, 70, 150, 350);
        listaTimes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaTimes.setVisibleRowCount(10);
        
        listaPontos.setBounds(170, 70, 20, 350);
        listaPontos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaPontos.setVisibleRowCount(10);
        
        listaNJogos.setBounds(200, 70, 20, 350);
        listaNJogos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaNJogos.setVisibleRowCount(10);
        
        listaVitorias.setBounds(230, 70, 20, 350);
        listaVitorias.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaVitorias.setVisibleRowCount(10);
        
        listaEmpates.setBounds(260, 70, 20, 350);
        listaEmpates.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaEmpates.setVisibleRowCount(10);
    
        // Components
        janela.add(tms);
        janela.add(pts);
        janela.add(jgs);
        janela.add(vit);
        janela.add(emp);
        janela.add(listaTimes);
        janela.add(listaPontos);
        janela.add(listaNJogos);
        janela.add(listaVitorias);
        janela.add(listaEmpates);
        janela.add(botaoAdicionar);
        janela.add(botaoAtualizar);
        janela.add(botaoBuscar);
        janela.add(valorBusca);

        //Janela
        janela.setLayout(null);
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
            dados.ordenaTimes();
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
