package Utilitarios;

import java.util.Scanner;

public class Ingresos {
    
    private Scanner scan;

    public Scanner getSc() {
        return this.scan;
    }

    public void setSc(Scanner sc) {
        this.scan = sc;
    }

    public Scanner ingreso() {

        this.setSc(new Scanner(System.in));
        return this.getSc();
    }

}
