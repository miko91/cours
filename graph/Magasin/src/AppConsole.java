import java.io.IOException;


public class AppConsole {
	
	private Magasin magasin = new Magasin();

	public AppConsole() {
		initMagasin();
	}
	
	public void initMagasin() {
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Bienvenue dans l'application, veuillez effectuer la configuration initiale\n");
		System.out.println("\nNom du magasin : ");
		this.magasin.setName(Console.saisirString());
		System.out.println("\nAdresse : ");
		this.magasin.setAdresse(Console.saisirString());
		System.out.println("\nVille : ");
		this.magasin.setVille(Console.saisirString());
		System.out.println("\nCode postal : ");
		this.magasin.setCp(Console.saisirString());
		System.out.println("\nT�l�phone : ");
		this.magasin.setTel(Console.saisirString());
		System.out.println("\nSolde (en euros) : ");
		this.magasin.setSolde(Console.saisirDouble());
		System.out.println("\n\nF�licitations la configuration est termin�e, vous allez �tre redirig� sur le menu de l'application.");
		try {
			Console.entree.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		AppConsole uneApp = new AppConsole();
		uneApp.magasin.menu();
	}

}
