
public class Enfant extends Personne{
	private int age;

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	Enfant(String nom, String prenom, int age)
	{
		super(nom, prenom);
		this.setAge(age);
	}
	
	public void afficher()
	{
		System.out.println("\nNom : " + this.getNom());
		System.out.println("\nPrenom : " + this.getPrenom());
		System.out.println("\nAge : " + this.getAge());
	}
	
	public void saisir()
	{
		System.out.println("\nDonner le nom : ");
		this.setNom(Console.saisirString());
		System.out.println("\nDonner le nom : ");
		this.setPrenom(Console.saisirString());
		System.out.println("\nDonner le nom : ");
		this.setAge(Console.saisirInt());
	}

	public boolean HF() {
		return false;
	}

	public void voyager(String pays) {
	}
	
}
