package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Countries {

    static String path = "data/data.txt";
    private ArrayList<Country> countries;

    public Countries() {
        this.countries = new ArrayList<>();
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
}
