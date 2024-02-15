import client.RestApiClient;
import models.Videogame;
import utils.Menu;
import java.util.Scanner;

public class Main
{
    private static Scanner scann = new Scanner(System.in);

    public static void main(String[] args)
    {
        RestApiClient client = new RestApiClient();

        // Definir el menú amb les opcions disponibles
        Menu menu = new Menu("Menú Principal",
                "Llistar tots els videojocs",
                "Llistar un videojoc per ID",
                "Llistar videojocs per companyia",
                "Afegir un videojoc",
                "Modificar un videojoc",
                "Eliminar un videojoc",
                "Salir");

        boolean exit = false;
        int option;

        while (!exit) {
            option = menu.getOption();

            //executar el mètode corresponent a l'opció seleccionada
            switch (option) {
                case 1:
                    client.listAllVideogames();
                    break;
                case 2:
                    client.listVideogamesByID(demanarID());
                    break;
                case 3:
                    client.listVideogamesByCompany(demanarCompany());
                    break;
                case 4:
                    client.createVideogame(demanarVideogame());
                    break;
                case 5:
                    client.updateVideogame(demanarVideogame());
                    break;
                case 6:
                    client.deleteVideogameByID(demanarID());
                    break;
                case 7:
                    exit = true; //Sortir del bucle
                    System.out.println("Sortint del programa...");
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        }
    }

    /**
     * Mètode per demanar l'ID del videojoc
     * @return
     */
    private static String demanarID(){
        boolean error = true;
        String id = "";

        while (error) {
            try{
                System.out.println("Introdueix l'ID del videojoc: ");
                id = scann.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("S'esperava un número");
                scann.next();
            }
        }
        return id;
    }

    /**
     * Mètode per demanar la companyia del videojoc
     * @return
     */
    private static String demanarCompany(){
        boolean error = true;
        String companyia = "";

        while (error) {
            try{
                System.out.println("Introdueix la companyia del videojoc: ");
                companyia = scann.nextLine();
                error = false;
            }catch (Exception e){
                System.out.println("S'esperava un número");
                scann.next();
            }
        }
        return companyia;
    }

    /**
     * Mètode per demanar les dades completes del videojoc
     * @return
     */
    private static Videogame demanarVideogame(){
        Videogame v = new Videogame();
        System.out.println("Introdueix l'id del videojoc: ");
        v.setId(scann.nextLine());
        System.out.println("Introdueix el títol del videojoc: ");
        v.setTitle(scann.nextLine());
        System.out.println("Introdueix l'any del videojoc: ");
        v.setYear(scann.nextLine());
        System.out.println("Introdueix la modalitat del videojoc: ");
        v.setModality(scann.nextLine());
        System.out.println("Introdueix la companyia del videojoc: ");
        v.setCompany(scann.nextLine());
        return v;
    }
}
