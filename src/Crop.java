import java.lang.Math;

public class Crop {

//Corn
//Cotton
//Cranberries
//Rice
//Soybeans
//Okra
//Wheat
    //Crop corn = new Crop("Corn", 3.5, 2, 7, 4, 8, 10);
    //  System.out.println(corn.getnumber_Name());


    private String name;
    private int number_name;
    private double value;
    private int growthStage;
    public int waterLevel = 0;
    private int idealwater;
    private int fertilizerLevel;
    private double health;
    private int harvest;
    private String[] crop_numbers = new String[]{"Soil", "Corn", "Cotton", "Cranberries", "Rice", "Soybeans", "Okra", "Wheat"};


    public Crop(String name) {
        this.name = name;
        number_name = setNumberName(name);
        value = 4;
        growthStage = 0;
        idealwater = 5;
        fertilizerLevel = 5;
        health = 5;
        harvest = 0;
    }

    public Crop(String name, double value, int growthStage, int idealwater, int fertilizerLevel, int health, int harvest) {
        this.name = name;
        this.number_name = setNumberName(name);

        this.value = value;
        this.growthStage = growthStage;
        this.idealwater = idealwater;
        this.fertilizerLevel = fertilizerLevel;
        this.health = health;
        this.harvest = harvest;

    }


    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(int growthStage) {
        this.growthStage = growthStage;
    }

    public int getIdealwater() {
        return idealwater;
    }

    public void setWaterLevel(int idealwater) {
        this.idealwater = idealwater;
    }

    public int getFertilizerLevel() {
        return fertilizerLevel;
    }

    public void setFertilizerLevel(int fertilizerLevel) {
        this.fertilizerLevel = fertilizerLevel;
    }

    public double getHealth() {
        return health;
    }

    public int getNumber_Name() {
        return number_name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getHarvest() {
        return harvest;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    public int setNumberName(String n) {

        int index = -1;
        for (int i = 0; i < crop_numbers.length; i++) {
            if (crop_numbers[i].equals(n)) {
                index = i;
                break;
            }


        }

        return index;


    }

    public void printTypes() {
        //	  corn.printTypes();
        for (int i = 1; i < crop_numbers.length; i++) {
            System.out.println(i + ") " + crop_numbers[i]);
        }

    }
    public double harvest(){
        float water_mods = 1- ((Math.abs(waterLevel - this.idealwater)/100);

        double yield = 25 * this.getValue();
        yield = yield*water_mods;



        return yield;
    }


    public void plant(int crop) {
        switch (crop) {
            case 0:

                this.name = "Soil";

                number_name = setNumberName(name);
                value = 0;
                growthStage = 1;
                idealwater = 0;
                fertilizerLevel = 0;
                health = 0;
                harvest = 0;
                break;

            case 1:
                this.name = "Corn";

                number_name = setNumberName(name);
                value = 4;
                growthStage = 1;
                idealwater = 5;
                fertilizerLevel = 5;
                health = 5;
                harvest = 1;
                break;

            case 2:
                this.name = "Cotton";

                number_name = setNumberName(name);
                value = 47;
                growthStage = 1;
                idealwater = 5;
                fertilizerLevel = 5;
                health = 5;
                harvest = 1;
                break;

            case 3:
                this.name = "Cranberries";

                number_name = setNumberName(name);
                value = 13;
                growthStage = 1;
                idealwater = 5;
                fertilizerLevel = 5;
                health = 5;
                harvest = 1;
                break;

            case 4:
                this.name = "Rice";

                number_name = setNumberName(name);
                value = 99;
                growthStage = 1;
                idealwater = 5;
                fertilizerLevel = 5;
                health = 5;
                harvest = 0;
                break;

            case 5:
                this.name = "Soybeans";

                number_name = setNumberName(name);
                value = 68;
                growthStage = 1;
                idealwater = 5;
                fertilizerLevel = 5;
                health = 5;
                harvest = 0;
                break;

            case 6:
                System.out.println("hit a 6ser");
                this.name = "Okra";

                number_name = setNumberName(name);
                value = 16;
                growthStage = 1;
                idealwater = 5;
                fertilizerLevel = 5;
                health = 5;
                harvest = 0;
                break;

            case 7:
                this.name = "Wheat";

                number_name = setNumberName(name);
                value = 50;
                growthStage = 1;
                idealwater = 5;
                fertilizerLevel = 5;
                health = 5;
                harvest = 0;
                break;
            default:
                System.out.println("Invalid Crop Number");
                //return "Invalid Crop Number";
        }


    }
}
