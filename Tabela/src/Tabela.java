import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tabela extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabela frame = new Tabela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tabela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		table.setBounds(10, 11, 515, 539);
		contentPane.add(table);
		
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setBounds(574, 39, 75, 14);
		contentPane.add(lblAccount);
		
		textField = new JTextField();
		textField.setBounds(691, 36, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(574, 72, 75, 14);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(691, 69, 133, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProtocol = new JLabel("Protocol");
		lblProtocol.setBounds(574, 109, 75, 14);
		contentPane.add(lblProtocol);
		
		textField_2 = new JTextField();
		textField_2.setBounds(691, 106, 133, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(643, 181, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(643, 232, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(643, 275, 89, 23);
		contentPane.add(btnModify);
	}
}
