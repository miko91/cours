/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mika
 */
public final class Convertisseur extends JFrame implements ActionListener, KeyListener{
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Attributs
     */
    private final JMenuBar bar = new JMenuBar();
    private final LinkedList<JMenu> menus = new LinkedList<JMenu>();
    private final LinkedList<JMenuItem> items = new LinkedList<JMenuItem>();
    private final JPanel panel = new JPanel();
    private final JPanel higth = new JPanel(new BorderLayout());
    private final JPanel menuBar = new JPanel(new BorderLayout());
    private final JPanel panTitle = new JPanel();
    private final JPanel panBlank = new JPanel();
    private final JPanel panBlank2 = new JPanel();
    private final JPanel panContent = new JPanel();
    private final JPanel panSubContent1 = new JPanel();
    private final JPanel panSubContent2 = new JPanel();
    private final LinkedList<JPanel> panList = new LinkedList<JPanel>();
    private final JPanel panInfo = new JPanel();
    private final JLabel title = new JLabel("Convertisseur de devise\n");
    private final JButton ac = new JButton("AC");
    private final JButton infos = new JButton("Infos");
    private final JButton exit = new JButton("Quitter");
    private final JComboBox devSource = new JComboBox();
    private final JComboBox devDest = new JComboBox();
    private final JTextField montantSource = new JTextField();
    private final JTextField montantDest = new JTextField();
    private final JLabel signSource = new JLabel();
    private final JLabel signDest = new JLabel();
    private final JLabel blank = new JLabel();
    private final JLabel dir = new JLabel("=>");
    private final JLabel egal = new JLabel("=");
    
    
    /**
     * Constructeur
     */
    public Convertisseur() {
        Font fonte = new Font(" TimesRoman ",Font.BOLD,20);
        
        //Informations de la JFrame
        this.setTitle("Convertisseur v1.2");
        this.setSize((int)getToolkit().getScreenSize().getWidth()/5, ((int)getToolkit().getScreenSize().getHeight()/4));
        this.setLocationRelativeTo(null);
        
        //Menu
        menus.add(new JMenu("Files"));
        items.add(new JMenuItem("Informations"));
        items.add(new JMenuItem("Quitter"));
        
        for(JMenuItem it : items) {
            it.addActionListener(this);
            menus.get(0).add(it);
        }
        
        for(JMenu me : menus) {
            bar.add(me);
        }
        menuBar.add(bar);
                
        //Conteneur de titre
        title.setFont(fonte);
        panTitle.setLayout(new FlowLayout());
        panTitle.add(title);
        
        //Conteneur haut
        higth.add(menuBar, BorderLayout.NORTH);
        higth.add(panTitle, BorderLayout.SOUTH);
        
        //Conteneur central
        panSubContent1.setLayout(new GridLayout(3, 2));
        
        for(int i = 0; i < 9; i++) {
            if (i == 0 || i == 2 || i == 6 || i == 8) {
                panList.add(new JPanel(new GridLayout(1,1)));
            } else {
                panList.add(new JPanel(new FlowLayout()));
            }
        }
        devSource.addActionListener(this);
        devDest.addActionListener(this);
        
        montantSource.addKeyListener(this);
        montantDest.addKeyListener(this);
        
        panList.get(0).add(devSource);
        panList.get(1).add(dir);
        panList.get(2).add(devDest);
        panList.get(3).add(signSource);
        panList.get(4).add(blank);
        panList.get(5).add(signDest);
        panList.get(6).add(montantSource);
        panList.get(7).add(egal);
        panList.get(8).add(montantDest);        

        for (int i = 0; i < 9; i++) {
            panSubContent1.add(panList.get(i));
        }
        
        ac.addActionListener(this);
        panSubContent2.add(ac);
        
        panContent.setLayout(new GridLayout(2, 1));
        panContent.add(panSubContent1);
        panContent.add(panSubContent2);
        
        this.loadDev();
        
        //Conteneur bas
        panInfo.setLayout(new FlowLayout());
        exit.addActionListener(this);
        infos.addActionListener(this);
        panInfo.add(infos);
        panInfo.add(exit);        
        
        //Conteneur global
        panel.setLayout(new BorderLayout());
        panel.add(higth, BorderLayout.NORTH);
        panel.add(panBlank, BorderLayout.WEST);
        panel.add(panBlank2, BorderLayout.EAST);
        panel.add(panContent, BorderLayout.CENTER);
        panel.add(panInfo, BorderLayout.SOUTH);
        
        //Impl�mentation du JPanel
        this.setContentPane(panel);
        
        //Rendre visible le tout et non resizable
        this.setJMenuBar(bar);
        this.setResizable(false);
        this.setVisible(true);
    }
    

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	if (System.getProperty("os.name").contains("Mac")) {
    		  System.setProperty("apple.laf.useScreenMenuBar", "true");
    	}
        Convertisseur unConvertisseur = new Convertisseur();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit || ae.getSource() == items.get(1)) {
            this.exit();
        } else if (ae.getSource() == devSource) {
            this.loadSign(1);
            if (montantDest.getText().length() > 0) {
                this.toSource();
            }
        } else if (ae.getSource() == devDest) {
            this.loadSign(2);
            if (montantSource.getText().length() > 0) {
                this.toDest();
            }
        } else if (ae.getSource() == ac) {
            montantSource.setText("");
            montantDest.setText("");
        } else if (ae.getSource() == infos || ae.getSource() == items.get(0)) {
            JOptionPane.showMessageDialog(this, "Convertisseur �crit en JAVA � l'occasion d'un cours sur la POO.\nCe convertisseur de devises contient le taux de changes pour : Euro, Franc, Dollar, Livres", "Informations", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void loadDev() {
        for(Devise dev : Devise.values()) {
            this.devSource.addItem(dev.getName());
            this.devDest.addItem(dev.getName());
        }
    }
    
    public void loadSign(int i) {
        if (i == 1) {
            for(Devise dev : Devise.values()) {
                if (devSource.getSelectedItem().equals(dev.getName())) {
                    signSource.setText(dev.getSign());
                }
            }
        } else if (i == 2) {
            for(Devise dev : Devise.values()) {
                if (devDest.getSelectedItem().equals(dev.getName())) {
                    signDest.setText(dev.getSign());
                }
            }
        }
    }
    
    public void toDest() {
        double tauxSource = 0, tauxDest = 0;
        for(Devise dev : Devise.values()) {
            if (devSource.getSelectedItem().equals(dev.getName())) {
                tauxSource = dev.getTaux();
            }
            if (devDest.getSelectedItem().equals(dev.getName())) {
                tauxDest = dev.getTaux();
            }
        }
        //System.out.println("Taux Source : "+tauxSource+"  -  Taux Dest : "+tauxDest);
        double source = Double.parseDouble(montantSource.getText());
        double dest = (source / tauxSource) * tauxDest;
        dest = (double) Math.round(dest * 100) / 100;
        montantDest.setText(""+dest);
    }
    
    public void toSource() {
        double tauxSource = 0, tauxDest = 0;
        for(Devise dev : Devise.values()) {
            if (devSource.getSelectedItem().equals(dev.getName())) {
                tauxSource = dev.getTaux();
            }
            if (devDest.getSelectedItem().equals(dev.getName())) {
                tauxDest = dev.getTaux();
            }
        }
        //System.out.println("Taux Source : "+tauxSource+"  -  Taux Dest : "+tauxDest);
        double dest = Double.parseDouble(montantDest.getText());
        double source = (dest / tauxDest) * tauxSource;
        source = (double) Math.round(source * 100) / 100;
        montantSource.setText(""+source);
    }
    
    public void exit() {
        int retour;
        retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.OK_CANCEL_OPTION);
        if(retour == 0) {
            this.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @SuppressWarnings("unused")
	@Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource() == montantSource) {
            if (ke.getKeyCode() == 8 || ke.getKeyCode() == 10 || ke.getKeyCode() == 17) {
                if (ke.getKeyCode() == 8) {
                    if (montantSource.getText().length() < 1) {
                        montantDest.setText("");
                    } else {
                        this.toDest();
                    }
                }
            } else {
                try {
                float mt = Float.parseFloat(montantSource.getText());
                this.toDest();
                } catch (NumberFormatException e) {
                  montantSource.setText(montantSource.getText().substring(0, montantSource.getText().length() - 1));
                }
            }            
        } else if (ke.getSource() == montantDest) {
            if (ke.getKeyCode() == 8 || ke.getKeyCode() == 10 || ke.getKeyCode() == 17) {
                if (ke.getKeyCode() == 8) {
                    if (montantDest.getText().length() < 1) {
                        montantSource.setText("");
                    } else {
                        this.toSource();
                    }
                }
            } else {
                try {
                float mt = Float.parseFloat(montantDest.getText());
                this.toSource();
                } catch (NumberFormatException e) {
                  montantDest.setText(montantDest.getText().substring(0, montantDest.getText().length() - 1));
                }
            }
        }
    }
    
}