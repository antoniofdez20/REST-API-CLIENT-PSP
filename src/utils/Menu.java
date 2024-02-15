package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    String header;
    String[] options;


    public Menu(String header, String ... options)
    {
        this.header = header;
        this.options = options;
    }

    /**
     * Mostra el menú per pantalla
     */
    public void show()
    {
        System.out.println("=".repeat(18));
        System.out.println(header);
        System.out.println("=".repeat(20));
        int counter = 0;
        for (String option : options)
            System.out.println(++counter + " -> " + option);
        System.out.println("=".repeat(20));
    }

    /**
     * Agafa la opció del menú que introdueix l'usuari
     * @return
     */
    public int getOption()
    {
        Scanner get = new Scanner(System.in);

        int answer = -1;
        try{
            while (answer < 0 || answer > options.length) {
                show();
                answer = get.nextInt();

            }
        }catch (InputMismatchException e){
            System.err.println("S'esperava un numero");
            getOption();
        }
        return answer;
    }
}
