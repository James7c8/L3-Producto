package l3.tienda.utils;

import java.util.Scanner;

public class Sc {

    public static int leerEntero(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "\n> ");
        return in.nextInt();
    }

    public static double leerReal(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "\n> ");
        return in.nextDouble();
    }

    public static String leerTexto(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "\n> ");
        return in.nextLine();
    }

}
