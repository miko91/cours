package Panels;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Configuration extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel header = new JPanel();
	private JPanel blank = new JPanel();
	private JPanel blank2 = new JPanel();
	private JPanel content = new JPanel();
	private JPanel footer = new JPanel();
	private JLabel title = new JLabel();
	private JButton cancel = new JButton("Annuler");
	private JButton validate = new JButton("Sauvegarder");
	private JTextField nom = new JTextField();
	private JTextField adresse = new JTextField();
	private JTextField ville = new JTextField();
	private JTextField cp = new JTextField();
	private JTextField tel = new JTextField();
	
	public Configuration() {
		this.initConfig();
	}
	
	public Configuration(String nom, String adresse, String ville, String cp, String tel) {
		
	}
	
	public JLabel getTitle() { return this.title; }
	public JButton getValidate() { return this.validate; }
	public JTextField getNom() { return this.nom; }
	public JTextField getAdresse() { return this.adresse; }
	public JTextField getVille() { return this.ville; }
	public JTextField getCp() { return this.cp; }
	public JTextField getTel() { return this.tel; }
	
	public void setTitle(String title) {
		this.title = new JLabel(title+"\n");
	}
	
	public void setNom(String nom) {
		this.nom.setText(nom);
	}
	
	public void setAdresse(String adresse) {
		this.adresse.setText(adresse);
	}
	
	public void setVille(String ville) {
		this.ville.setText(ville);
	}
	
	public void setCp(String cp) {
		this.cp.setText(cp);
	}
	
	public void setTel(String tel) {
		this.tel.setText(tel);
	}
	
	public void initConfig() {
		this.setLayout(new BorderLayout());
		this.add(blank, BorderLayout.WEST);
		this.add(blank2, BorderLayout.EAST);
		this.header.add(this.title);
		this.header.setSize((int)this.content.getSize().getWidth(), (int)this.content.getSize().getHeight()/5);
		this.add(header, BorderLayout.NORTH);
		

		this.content.setLayout(new GridLayout(5, 2));
		this.content.setSize((int)this.content.getSize().getWidth(), (int)this.content.getSize().getHeight()/5*3);
		this.content.add(new JLabel("Nom du magasin"));
		this.content.add(nom);
		this.content.add(new JLabel("Adresse"));
		this.content.add(adresse);
		this.content.add(new JLabel("Ville"));
		this.content.add(ville);
		this.content.add(new JLabel("Code postal"));
		this.content.add(cp);
		this.content.add(new JLabel("T�l�phone"));
		this.content.add(tel);
		this.add(this.content, BorderLayout.CENTER);
		
		
		this.footer.add(validate);
		this.add(footer, BorderLayout.SOUTH);
	}
}