package model;

public class Country implements Comparable<Country>{

    private String name;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGoldMedals() {
        return goldMedals;
    }

    public void addGoldMedals(int goldMedals) {
        this.goldMedals += goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public void addSilverMedals(int silverMedals) {
        this.silverMedals += silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public void addBronzeMedals(int bronzeMedals) {
        this.bronzeMedals += bronzeMedals;
    }

    public int compareByName(Country o){
        return this.name.compareTo(o.getName());
    }

    public int totalMedals (){
        return this.goldMedals + this.silverMedals + this.bronzeMedals;
    }
    @Override
    public int compareTo(Country o) {

        int criteria1 = this.goldMedals - o.goldMedals;
        if (criteria1 == 0){
            int criteria2 = this.silverMedals - o.silverMedals;
            if (criteria2 == 0){
                int criteria3 = this.bronzeMedals - o.bronzeMedals;
                if (criteria3 == 0){
                    return this.name.compareTo(o.name);
                } else {
                    return criteria3;
                }
            } else {
                return criteria2;
            }
        } else {
            return criteria1;
        }
    }
}
