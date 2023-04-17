package model;


import java.io.IOException;

public class Controller {
    private Countries countries;

    public Controller() {
        this.countries = new Countries();
    }

    public void addToCountry (String name, String type, int medals) {
        this.countries.addToCountry(name,type,medals);
    }

    public void loadData () throws IOException {
        this.countries.loadData();
    }

    public void saveData () throws IOException {
        this.countries.saveData();
    }

    public String byNameSort (){
        return countries.byNameSort();
    }

    public boolean isEmpty(){
        return countries.isEmpty();
    }

    public String oneCountryMedals ( int country){
        return countries.oneCountryMedals(country);
    }

    public String conventionalRank (){
        return countries.conventionalRank();
    }

    public String oneCountryTotalMedals ( int country){
        return countries.oneCountryTotalMedals(country);
    }

    public String byMedalsRank (){
        return countries.byMedalsRank();
    }
}
