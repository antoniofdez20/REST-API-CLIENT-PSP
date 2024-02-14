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

        // Definir el menú con las opciones disponibles
        Menu menu = new Menu("Menú Principal",
                "Llistar tots els videojocs",
                "Llistar un videojoc per ID",
                "Afegir un videojoc",
                "Modificar un videojoc",
                "Eliminar un videojoc",
                "Salir");

        boolean exit = false;
        int option;

        while (!exit) {
            option = menu.getOption();

            switch (option) {
                case 1:
                    client.listAllVideogames(); // Llamar al método para listar videojuegos
                    break;
                case 2:
                    client.listVideogamesByID(demanarID());
                    break;
                case 3:
                    client.createVideogame(demanarVideogame());
                    break;
                case 4:
                    client.updateVideogame(demanarVideogame());
                    break;
                case 5:
                    client.deleteVideogameByID(demanarID());
                    break;
                case 6:
                    exit = true; // Salir del bucle
                    System.out.println("Sortint del programa...");
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        }
    }

    private static int demanarID(){
        boolean error = true;
        int id = 0;

        while (error){
            try{
                System.out.println("Introdueix l'ID del videojoc: ");
                id = scann.nextInt();
                error = false;
            }catch (Exception e){
                System.out.println("S'esperava un número");
                scann.next();
            }
        }
        return id;
    }

    private static Videogame demanarVideogame(){
        Videogame v = new Videogame();
        System.out.println("Introdueix l'id del videojoc: ");
        v.setId(scann.nextInt());
        System.out.println("Introdueix el títol del videojoc: ");
        v.setTitle(scann.next());
        System.out.println("Introdueix l'any del videojoc: ");
        v.setYear(scann.next());
        System.out.println("Introdueix la modalitat del videojoc: ");
        v.setModality(scann.next());
        System.out.println("Introdueix la companyia del videojoc: ");
        v.setCompany(scann.next());
        return v;
    }
}
