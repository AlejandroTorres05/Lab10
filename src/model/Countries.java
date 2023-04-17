package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Countries {

    static String path = "data/data.txt";
    private ArrayList<Country> countries;

    public Countries() {
        this.countries = new ArrayList<>();
    }

    public void addToCountry (String name, String type, int medals)
    {
        int position = isInTheProgram(name);
        if (position < 0){
            this.countries.add(new Country(name));
            position = this.countries.size() -1;
        }

        if (type.equals("gold")){
            this.countries.get(position).addGoldMedals(medals);
        } else if (type.equals("silver")) {
            this.countries.get(position).addSilverMedals(medals);
        } else if (type.equals("bronze")) {
            this.countries.get(position).addBronzeMedals(medals);
        }
    }

    public int isInTheProgram (String name){
        for (int i = 0; i < this.countries.size(); i++){
            if (this.countries.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void saveData () throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        Gson gson = new Gson();
        String data = gson.toJson(this.countries);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }

    public void loadData () throws IOException{
        File file = new File(path);

        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String content = "";
            String line;

            while ((line = reader.readLine()) != null){
                content += line + "\n";
            }
            Gson gson = new Gson();
            Country[] array = gson.fromJson(content, Country[].class);
            this.countries.addAll(Arrays.asList(array));
            fis.close();

        }else {
            File f = new File("data");
            if (!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
    }

    public String byNameSort (){
        if (countries.isEmpty()) return "There aren't countries yet";
        String message = "";

        for (int i = 1; i<countries.size(); i++){
            for (int j = 0; j<i; j++){

                if (countries.get(i).compareByName(countries.get(j)) < 0){
                    countries.add(j, countries.get(i));
                    countries.remove(i+1);
                    break;
                }
            }
        }

        for (int i = 0; i<countries.size(); i++){
            message += (i+1) + ". " + countries.get(i).getName() + "\n";
        }

        return message;
    }

    public boolean isEmpty(){
        return countries.isEmpty();
    }

    public String oneCountryMedals (int country) {
        String message = "";
        message += countries.get(country).getName() + "\n";
        message += " Gold: " + countries.get(country).getGoldMedals() + "\n";
        message += " Silver: " + countries.get(country).getSilverMedals() + "\n";
        message += " Bronze: " + countries.get(country).getBronzeMedals() + "\n";
        return message;
    }

    public String conventionalRank (){
        if (countries.isEmpty()) return "There aren't countries yet";
        String message = "";
        Collections.sort(countries);

        for (int i = 0; i<countries.size(); i++){
            message += (i+1) + ". " + countries.get(i).getName() + "\n";
            message += "    Gold: " + countries.get(i).getGoldMedals() + "\n";
            message += "    Silver: " + countries.get(i).getSilverMedals() + "\n";
            message += "    Bronze: " + countries.get(i).getBronzeMedals() + "\n";
        }
        return message;
    }

    public String oneCountryTotalMedals (int country){
        return countries.get(country).totalMedals() + "";
    }

    public String byMedalsRank (){
        if (countries.isEmpty()) return "There aren't countries yet";
        String message = "";

        Collections.sort(countries, (a,b)->{
            return a.totalMedals() - b.totalMedals();
        });

        for (int i = 0; i<countries.size(); i++){
            message += (i+1) + ". " + countries.get(i).getName() + " with "
                    + countries.get(i).totalMedals() + " medals" + "\n";
        }

        return message;
    }
}
