public class Tractor {
    private int level = 0; // 1-9
    private int weatherRes = 0; // weather resistance (scale of 1-4)
    private int horsepower = 1; // horsepower (scale of 1-4)
    private String type = ""; // Compact(lvl 1-4), Utility(lvl 5-6), Row Crop(lvl 7-8), 4WD(lvl 9)

    final int UPGRADE_LVL = 25000;
    final int UPGRADE_TYPE = 50000;

    public Tractor() {
        level = 0;
        type = "Compact";
        weatherRes = 0;
        horsepower = 1;
    }

    public Tractor(int l) {
        level = 1;
        adjustStats(level);
    }

    public int getLevel() {
        return level;
    }
    public int getWeatherRes() {
        return weatherRes;
    }

    public int getHorsepower() {
        return horsepower;
    }
    public String getType() {
        return type;
    }

    public void setLevel(int l) {
        level = l;
        adjustStats(level);
    }

    public void adjustStats(int level) {
        if((level >= 1) && (level <= 4)) {
            type = "Compact";
            weatherRes = 1;
            horsepower = 20 + (8*level); // 28, 36, 44, 52
        }
        else if((level >= 5) && (level <= 6)) {
            type = "Utility";
            weatherRes = 2;
            horsepower = 75 + 75*(level-5); // 75, 150
        }
        else if((level >= 7) && (level <= 8)) {
            type = "Row Crop";
            weatherRes = 3;
            horsepower = 275 + 75*(level-7); // 275, 350
        }
        else if(level == 9) {
            type = "4WD";
            weatherRes = 4;
            horsepower = 500;
        }
        else {
            type = "ERROR";
        }
    }

    public int plow() {
        return horsepower / 500;
    }
    public int levelUp(int money) {
        if (((level == 4) || (level == 6) || (level == 8)) && (money > UPGRADE_TYPE)) {
            level++;
            adjustStats(level);
            return level;
        }
        else if (((level == 1) || (level == 2) || (level == 3) || (level == 5) || (level == 7)) && (money > UPGRADE_LVL)) {
            level++;
            adjustStats(level);
            return level;
        }
        else {
            return -1;
        }
    }
}
