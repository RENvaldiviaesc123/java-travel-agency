package org.java.lessons.travel;
import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vacanza vacation = null;
        System.out.println("Benvenuto alla nostra Agency! Inserisci i dati della tua prossima destinazione!!");
        while (vacation==null) {
            System.out.println("La tua destinazione:");
            String arrivo = scan.nextLine();

            System.out.println("La tua data di partenza:(yyyy-mm-dd)");
            LocalDate partenza = null;
            try {partenza = LocalDate.parse(scan.nextLine());}
            catch (Exception e) {
                System.out.println("Invalid date format!");
            }

            System.out.println("La tua data di ritorno (yyyy-mm-dd):");
            LocalDate ritorno = null;
            try {ritorno = LocalDate.parse(scan.nextLine());}
            catch (Exception e) {
                System.out.println("Invalid date format!");
            }
            //Creiamo una viaggio (vacanza) con quei dati
            try {
                vacation = new Vacanza(arrivo, partenza, ritorno);
            } catch (RuntimeException e) {
                System.out.println("Invalid parameters");
                System.out.println(e.getMessage());
            }

            scan.close();
        }






    //Chiudiamo lo scanner
    scan.close();
    }
}
