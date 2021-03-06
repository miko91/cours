import java.awt.Color;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class Convertisseur extends JFrame implements ActionListener{

	
	/**
	 * Boutons d'actions
	 */
	private JButton euro = new JButton("�URO");
	private JButton dv = new JButton("Devise");
	private JButton taux = new JButton("Taux");
	private JButton ac = new JButton("AC");
	private JButton exit = new JButton("Quitter");
	
	/**
	 * Lables
	 */
	private JLabel titre = new JLabel("Programme r�alis� le 26/11/2013");
	private JLabel monnaie = new JLabel();
	
	/**
	 * Zone de texte
	 */
	private TextField montant = new TextField();
	
	/**
	 * Constante du taux de change
	 */
	final double tx = 6.56;
	
	/**
	 * Menus
	 */
	private JMenuBar maBarre = new JMenuBar();
	private JMenu Calcul = new JMenu("Calcul");
	private JMenu Autre = new JMenu("Autre");
	private JMenuItem euroItem = new JMenuItem("Euro");
	private JMenuItem dvItem = new JMenuItem("Devise");
	private JMenuItem quitterItem = new JMenuItem("Quitter");
	private JMenuItem acItem = new JMenuItem("AC");
	private JMenuItem tauxItem = new JMenuItem("Taux");
	
	/**
	 * ComboBox
	 */
	private JComboBox devise = new JComboBox();
	
	
	public Convertisseur() {
		
		
		this.setBounds(200, 200, 420, 290);
		this.setLayout(null);
		this.setTitle("Mon convertisseur");
		this.setResizable(false);
		titre.setBounds(50, 20, 250, 20);
		this.add(titre);
		euro.setBounds(50, 60, 60, 60);
		euro.addActionListener(this);
		euro.setBackground(Color.BLUE);
		this.add(euro);
		montant.setBounds(125, 120, 50, 20);
		this.add(montant);
		monnaie.setBounds(185, 120, 10, 20);
		this.add(monnaie);
		dv.setBounds(210, 60, 60, 60);
		dv.addActionListener(this);
		this.add(dv);
		taux.setBounds(50, 140, 60, 60);
		taux.addActionListener(this);
		this.add(taux);
		ac.setBounds(210, 140, 60, 60);
		ac.addActionListener(this);
		this.add(ac);
		exit.setBounds(120, 220, 80, 30);
		exit.addActionListener(this);
		this.add(exit);
		
		devise.setBounds(285, 60, 130, 30);
		this.add(devise);
		
		/**
		 * Construction du menu
		 */
		maBarre.add(Calcul);
		maBarre.add(Autre);
		Calcul.add(euroItem);
		Calcul.add(dvItem);
		Calcul.add(quitterItem);
		Autre.add(tauxItem);
		Autre.add(acItem);
		euroItem.addActionListener(this);
		dvItem.addActionListener(this);
		quitterItem.addActionListener(this);
		tauxItem.addActionListener(this);
		acItem.addActionListener(this);
		this.chargerDevise();
		this.setJMenuBar(maBarre);
		this.setVisible(true);
		
	}

	
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		Convertisseur unConvertisseur = new Convertisseur();
	}
	
	public void toEuro() {
		try {
			float mt = Float.parseFloat(montant.getText());
			mt /= tx;
			montant.setText(""+mt);
			monnaie.setText("�");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "La saisie n'est pas correct, vous devez donnez un nombre (entier ou d�cimal)"+montant.getText().length(), "Erreur de saisie", JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	public void toDevise() {
		try {
			float mt = Float.parseFloat(montant.getText());
			mt *= this.getTaux();
			montant.setText(""+mt);
			monnaie.setText("F");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "La saisie n'est pas correct, vous devez donnez un nombre (entier ou d�cimal)"+montant.getText().length(), "Erreur de saisie", JOptionPane.ERROR_MESSAGE);	
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ac  || e.getSource() == acItem) {
			montant.setText("");
			monnaie.setText("");
		} else if(e.getSource() == exit || e.getSource() == quitterItem) {
			this.quitter();
		} else if(e.getSource() == euro || e.getSource() == euroItem) {
			this.toEuro();
		} else if(e.getSource() == taux || e.getSource() == tauxItem) {
			JOptionPane.showMessageDialog(this, "Le taux est de "+tx, "Taux", JOptionPane.INFORMATION_MESSAGE);
		} else if(e.getSource() == dv || e.getSource() == dvItem) {
			this.toDevise();
		}
	}
	
	public void chargerDevise() {
		this.devise.addItem("Franc - 6.56");
		this.devise.addItem("Dollar - 0.74");
		this.devise.addItem("Livres - 1.20");
		this.devise.addItem("DA - 0.01");
	}
	
	public float getTaux() {
		float taux = 0;
		String chaine = devise.getSelectedItem().toString();
		try {
			String tab[] = new String[2];
			tab = chaine.split(" - ");
			taux = Float.parseFloat(tab[1]);
		} catch (NumberFormatException e) {
			
		}
		System.out.println(taux);
		return taux;
	}
	
	public void quitter() {
		int retour;
		retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.OK_CANCEL_OPTION);
		if(retour == 0) {
			this.dispose();
		}
	}
	
}
