package emailapp;

import java.util.Scanner;

public class Email {
	
	private String name;
	private String lastName;
	private String department;
	private String password;
	private int defaultPasswordSize = 10;
	private String email;
	private String emailSufix = "ensayos.com";
	private String alterEmail;
	private int mailCapacity = 500;
	
	Scanner kb = new Scanner(System.in);
	
	//constructor
	public Email () {
		this.name = getNombre();
		this.lastName = getApellido();
		this.department = Department();
		this.password = randomPass(defaultPasswordSize);
		
		this.email = this.name.toLowerCase()+ "."+ this.lastName.toLowerCase() + 
					 "@"+ this.department.toLowerCase() +"."+ this.emailSufix.toLowerCase();		
	}
	
	//Metodo que pide ingresar nombre
	public String getNombre() {
		String nombre;
		System.out.println("Ingresa tu nombre: ");
		nombre = kb.next();
		return nombre;		
	}
	
	//Metodo que pide ingresar el apellido
	public String getApellido() {		
		String apellido;
		System.out.println("Ingresa tu Apellido: ");
		apellido = kb.next();
		return apellido;		
	}
	
	//Metodo que pide ingresar digito para buscar el departamento		 
	public String Department() {
		
		String departamento = "";
		int num;
		
		do {
			
			System.out.println("\nBienvenido/a "+this.name + " "+ this.lastName+ 
								"\nIngresa digito de tu Departamento: \n1 - Diseño \n2 - Desarrollo \n3 - Contabilidad \n4 - Ninguno \n0 -  Salir");
			
			num = kb.nextInt();
			
		switch (num) {
			case 1: departamento = "Ventas";				
				break;
				
			case 2: departamento = "Desarrollo";
				break;
				
			case 3: departamento = "Contabilidad";	
				break;
				
			case 4: departamento = "";
				break;
				
			case 0: System.exit(0);	
				break;
				
			default: System.out.println( "Ingresa una opcion valida\n");
				break;
			}
		} while (num > 4 || num < 0);
		
		kb.close();
		
		return departamento;
		
	}
	
	//genera password aleatorio
	public String randomPass(int length) {
		String passwordSet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789@=#$%&";
		char[] password = new char[length];
		
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length() );
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
		
	//set and get
	public void setMailCapacity(int capacity) {
		this.mailCapacity = capacity;
	}
	
	public void setAlterEmail(String alterEmail) {
		this.alterEmail = alterEmail;
	}
	
	public int getMailCapacity () {
		return mailCapacity;
	}
	
	public String getAlterEmail() {
		return alterEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	//Metodo que muestra informacion
	public String showInfo() {
		return "NOMBRE: "+ this.name + " " + this.lastName +
				"\nEMAIL: " + this.email +
				"\nCONTRASEÑA: " + this.password +
				"\nCAPACIDAD EMAIL: " + this.mailCapacity +" MB";
	}
	
}
