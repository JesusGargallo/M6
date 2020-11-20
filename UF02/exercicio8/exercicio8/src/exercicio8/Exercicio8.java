package exercicio8;

import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.*;

public class Exercicio8 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        boolean preguntando = true,isNegro, isdiscapacitado;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String marca, nombre, dia, nacimiento;
        int añoModelo, añosdecarnet,siguepreguntando;
        
        
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("$objectdb/db/Exercicio8.odb");
        EntityManager em = emf.createEntityManager();

        
        System.out.println("Introdueix el primer propietari:");
        em.getTransaction().begin();
        while(preguntando == true){
            System.out.println("Nombre:");
            nombre = sc.nextLine();
            
            System.out.println("Cuantos años de carnet tienes:");
            añosdecarnet = sc.nextInt();
            
            System.out.println("Dia de nacimiento:");
            nacimiento = sc.next();
            Date nacimientoE = sdf.parse(nacimiento);
            
            System.out.println("Es Discapacitado? ");
            isdiscapacitado = sc.nextBoolean();
            
            Propietaris pro;
            pro = new Propietaris
            (nombre,añosdecarnet,nacimientoE,isdiscapacitado);
            
            em.persist(pro);
            
            System.out.println("Hay un otro propietario? 1-SI / 2-NO ");
            siguepreguntando = sc.nextInt();
            sc.nextLine();
            
            if(siguepreguntando == 1){
                preguntando = true;
            } else {
                preguntando = false;
            } 
        }
        
        preguntando = true;
        System.out.println("Introdueix el primer propietari:");
        em.getTransaction().begin();
        while(preguntando == true){
            System.out.println("Nomre:");
            nombre = sc.nextLine();
            
            System.out.println("Cuantos años de carnet tienes:");
            añosdecarnet = sc.nextInt();
            
            System.out.println("Dia de nacimiento:");
            nacimiento = sc.next();
            Date nacimientoE = sdf.parse(nacimiento);
            
            System.out.println("Es Discapacitado? ");
            isdiscapacitado = sc.nextBoolean();
            
            Propietaris pro;
            pro = new Propietaris
            (nombre,añosdecarnet,nacimientoE,isdiscapacitado);
            
            em.persist(pro);
            
            System.out.println("Hay un otro propietario? 1-SI / 2-NO ");
            siguepreguntando = sc.nextInt();
            sc.nextLine();
            
            if(siguepreguntando == 1){
                preguntando = true;
            } else {
                preguntando = false;
            } 
        }
        
        em.getTransaction().commit();
        preguntando = true;
        
        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
}

