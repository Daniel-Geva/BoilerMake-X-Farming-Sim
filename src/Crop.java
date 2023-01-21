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
    private int waterLevel;
    private int fertilizerLevel;
    private int health;
    private int harvest;
    private String[] crop_numbers = new String[]{ "Soil","Corn","Cotton","Cranberries","Rice","Soybeans","Okra","Wheat"};



    public Crop(String name) {
        this.name = name;
        number_name = setNumberName(name);
        value = 4;
        growthStage = 0;
        waterLevel = 5;
        fertilizerLevel = 5;
        health = 5;
        harvest = 0;
    }
    public Crop(String name, double value, int growthStage, int waterLevel, int fertilizerLevel, int health, int harvest) {
        this.name = name;
        this.number_name = setNumberName(name);

        this.value = value;
        this.growthStage = growthStage;
        this.waterLevel = waterLevel;
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

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getFertilizerLevel() {
        return fertilizerLevel;
    }

    public void setFertilizerLevel(int fertilizerLevel) {
        this.fertilizerLevel = fertilizerLevel;
    }

    public int getHealth() {
        return health;
    }
    public int getNumber_Name() {
        return number_name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHarvest() {
        return harvest;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }
    public int setNumberName(String n){

        int index = -1;
        for (int i=0;i<crop_numbers.length;i++) {
            if (crop_numbers[i].equals(n)) {
                index = i;
                break;
            }


        }

        return index;



    }
    public void printTypes(){
        //	  corn.printTypes();
        for (int i=1;i<crop_numbers.length;i++) {
            System.out.println(i + ") " + crop_numbers[i]);
        }

    }
}