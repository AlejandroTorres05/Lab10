import model.Controller;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private Scanner sc;
    private Controller controller;

    public Main (){
        this.sc =  new Scanner(System.in);
        this.controller = new Controller();
    }
    public static void main(String[] args) {
        Main main = new Main();

        try {
            main.getController().loadData();
            main.addCountryMenu();
            main.getController().saveData();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void mainMenu (){
        System.out.println("Hello, welcome to olympic games");
        boolean start = true;

        while (start){
            System.out.println("Please type an option"
                    + "\n1. Show conventional rank"
                    + "\n2. Show countries by total number of medals"
                    + "\n3. Show countries ordered by their names"
                    + "\n4. Introduce a country"
                    + "\n0. Close the program");
            int option = sc.nextInt();
            switch (option){
                case 0:
                    start = true;
                    break;
                case 1:
                    conventionalRank();
                    break;
                case 2:
                    byMedalsRank();
                    break;
                case 3:
                    byNameSort();
                    break;
                case 4:
                    addCountryMenu();
                    break;
                default:
                    System.out.println(option + "isn't an option");
                    break;
            }
        }
    }

    private void addCountryMenu(){

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
                    byNameSort();
                    break;
                default:
                    System.out.println(option + " isn't an available option");
                    break;
            }
        }
    }

    private void enterCountry (){
        System.out.println("Please type the information in this order:"
                + "\n country_name::type_medal::number_of_medals"
                + "\n remember that the types are literally: 'gold', 'silver', 'bronze'"
                + "\n For example: colombia::gold::10");
        sc.nextLine();
        String country = sc.nextLine();
        String[] data = country.split("::");
        String name = data[0];
        String type = data[1];
        int medals = Integer.parseInt(data[2]);
        this.controller.addToCountry(name, type, medals);
    }

    private void showMedals (){
        if(controller.isEmpty()){
            System.out.println("There aren't countries yet");
            return;
        }
        System.out.println("Please type an option"
                + "\n1. Show all medals for one country"
                + "\n2. Show all medals for all countries");
        int option = sc.nextInt();
        if (option == 1){
            System.out.println("Please type the number of the country");
            byNameSort();
            int country = sc.nextInt();
            System.out.println(this.controller.oneCountryMedals(country -1));
        } else {
            conventionalRank();
        }
    }

    private void showTotalMedals (){
        if(controller.isEmpty()){
            System.out.println("There aren't countries yet");
            return;
        }
        System.out.println("Please type an option"
                + "\n1. Show total medals for one country"
                + "\n2. Show total medals for all countries");
        int selection = sc.nextInt();
        if (selection == 1){
            System.out.println("Please type the number of the country");
            byNameSort();
            int country = sc.nextInt();
            System.out.println(this.controller.oneCountryTotalMedals(country -1));
        } else {
            byMedalsRank();
        }
    }

    public Controller getController() {
        return controller;
    }

    private void conventionalRank (){
        System.out.println(this.controller.conventionalRank());
    }

    private void byMedalsRank (){
        System.out.println(this.controller.byMedalsRank());
    }

    private void byNameSort (){
        System.out.println(this.controller.byNameSort());
    }
}