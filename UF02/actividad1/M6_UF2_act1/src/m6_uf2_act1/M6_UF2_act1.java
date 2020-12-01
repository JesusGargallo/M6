package m6_uf2_act1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class M6_UF2_act1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Creacio del Scanner
		Scanner teclado = new Scanner(System.in);		

		Connection connection = null;
		Statement stmt = null;
		Statement selectStmt = null;
		try {
		
                    
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/m6_uf2_act1", "root", "");			

			System.out.println("1- Afegir columnes(alumnes) | 2- Modificar columnes | 3- Eliminar columnes | 4- Afegir columnes(poblacions)");
			int eleccio = teclado.nextInt();
                        teclado.nextLine();
                        
			if(eleccio == 1){
                                System.out.println("Afegeix un NOM");
				String nom = teclado.next();
				System.out.println("Afegeix un DNI");
				String dni = teclado.next();
				System.out.println("Afegeix una data ->(1897-12-10)");
				String data = teclado.next();
				System.out.println("Afegeix una carrer");
				String carrer = teclado.next();
                                teclado.nextLine();
                                System.out.println("Afegeix el sexe");
				String sexe = teclado.next();
                                teclado.nextLine();
				System.out.println("Afegeix un codi postal");
				int codiPostal = teclado.nextInt();

				try{
					stmt = connection.createStatement();
					stmt.execute("INSERT INTO alumnes VALUES ('" + nom + "',' " + dni + "',' " + data + "',' " + carrer + "','" + sexe + "'," + codiPostal + ")");

				} catch(Exception e){					
					System.out.println("Afegeix un codi postal a la taula poblacions");
				}
			} else if (eleccio == 4){
				System.out.println("Afegeix un nom de poblacio");
				String nomPoblacio = teclado.next();
				System.out.println("Afegeix un codi postal");
				int codiPostalPoblacio = teclado.nextInt();

				stmt = connection.createStatement();
				stmt.execute("INSERT INTO alumnes VALUES ('" + nomPoblacio + "'," + codiPostalPoblacio + ")");
                        }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				//selectStmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
    



