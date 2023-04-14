package model;


import java.io.IOException;

public class Controller {
    private Countries countries;

    public Controller() {
        this.countries = new Countries();
    }

    public void loadData () throws IOException {
        this.countries.loadData();
    }

    public void saveData () throws IOException {
        this.countries.saveData();
    }
}
