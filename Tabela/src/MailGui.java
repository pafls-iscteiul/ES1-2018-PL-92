import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class MailGui extends JFrame {
	private JPanel contentPane;
	private JTextArea tArea;
	private JScrollPane pane;
	private JTextField procuraField;
	private JTextField textField_1;
	private JLabel lblDfdf;
	private List<String> listaMails;
	File[] file = null;
	String path="C:/Users/gabrielaamaral/git/ES1-2018-PL-92/Tabela/src/mail.txt";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailGui frame = new MailGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MailGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		tArea =new JTextArea();
		tArea.setBounds(10, 97, 515, 436);	
		pane = new JScrollPane(tArea);
		pane.setBounds(10, 97, 515, 436);
		contentPane.add(pane);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				tArea.setText("");
//				String s =textField_3.getText();
//				ArrayList<String> a=procura(s);
//				
//				for(String bb : a){
//					tArea.append(bb + "\n");
//				}
//				
//			}
//		});
		btnNewButton.setBounds(350, 31, 175, 31);
		contentPane.add(btnNewButton);
		
		procuraField = new JTextField();
		procuraField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		procuraField.setBounds(10, 31, 310, 31);
		contentPane.add(procuraField);
		procuraField.setColumns(10);
		
		JLabel label1 = new JLabel("");
		java.awt.Image img1 = new ImageIcon (this.getClass().getResource("/hat.png")).getImage();
		label1.setIcon(new ImageIcon(img1));
		label1.setBounds(721, 11, 103, 96);
		contentPane.add(label1);
		
		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		lblBomDiaAcademia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblBomDiaAcademia.setBounds(564, 72, 156, 35);
		contentPane.add(lblBomDiaAcademia);
		
		JLabel label2 = new JLabel("");
		java.awt.Image img2 = new ImageIcon (this.getClass().getResource("/GI.png")).getImage();
		label2.setIcon(new ImageIcon(img2));
		label2.setBounds(574, 118, 134, 135);
		contentPane.add(label2);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				sendEmail(mensagem, destinatario);
			}
		});
		btnEnviar.setBounds(717, 510, 89, 23);
		getContentPane().add(btnEnviar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(651, 276, 156, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblDfdf = new JLabel("Destinat�rio");
		lblDfdf.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblDfdf.setBounds(564, 268, 77, 35);
		contentPane.add(lblDfdf);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(564, 328, 242, 171);
		contentPane.add(textArea);
		textField_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String desinatario=textField_1.getText();
			}
		});		
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		btnLoad.setBounds(717, 226, 89, 23);
		contentPane.add(btnLoad);
	}
	public List<String> readFileMail(File f) {
		String line = null;
		f = new File(path);
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				line = s.nextLine();
				listaMails.add(line);
			}
			s.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return listaMails;
	}
	
	
	public ArrayList<String> criaListaMail() {
		ArrayList<String> d = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))){

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				d.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
}
