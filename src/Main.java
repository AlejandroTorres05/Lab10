import model.Controller;

import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static Controller controller;

    public Main (){
        this.sc =  new Scanner(System.in);
        this.controller = new Controller();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.mainMenu();
    }

    private void mainMenu (){

        System.out.println("Hello, welcome to olympic games");
        boolean start = true;

        while (start){

            System.out.println("Type the number of an option"
                    + "\n 1. Enter a country"
                    + "\n 2. Show medals"
                    + "\n 3. Show total of medals"
                    + "\n 4. Show countries"
                    + "\n 0. Exit program");
            int option = sc.nextInt();
            switch (option){
                case 0:
                    start = false;
                    break;
                case 1:
                    enterCountry();
                    break;
                case 2:
                    showMedals();
                    break;
                case 3:
                    showTotalMedals();
                    break;
                case 4:
                    showCountries();
                    break;
                default:
                    System.out.println(option + " isn't an available option");
                    break;
            }
        }
    }

    private void enterCountry (){

    }

    private void showMedals (){

    }

    private void showTotalMedals (){

    }

    private void showCountries (){

    }
}