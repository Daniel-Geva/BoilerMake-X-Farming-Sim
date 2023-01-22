public class Field {
    private Crop[] crops;
    private int numFields;
    private double upgradeValue;

    public Field() {
        this.crops = new Crop[9];
        for (int i = 0; i < 9; i++) {
            crops[i] = new Crop("Soil");
        }
        this.numFields = 1;
        this.upgradeValue = 100;
    }

    public double harvest(Tractor tractor) {
        double total = 0;
        for (int i = 0; i < numFields; i++) {
            total += crops[i].harvest(tractor);
            crops[i].plant(0);
        }
        return total;
    }

    public double expandFields(double money) {
        if (numFields == 9) {
            return -2;
        }
        if (money >= upgradeValue) {
            money -= upgradeValue;
            upgradeValue *= 2;
            numFields++;
            if (numFields == 9) {
                upgradeValue = -1;
            }
            return money;
        } else {
            return -1;
        }
    }

    public int plant(int type, int field) {
        if (field > numFields) {
            return -1;
        }
        if ((type > 7) || (type < 0)) {
            return -2;
        }
        crops[field - 1].plant(type);
        return type;
    }

    private void printRow(int amount, int row) {
        for (int i = 0; i < 5; i++) {
            System.out.print("|");
            for (int j = 0; j < amount; j++) {
                int rep = crops[(row * 3) + j].getNumber_Name();
                System.out.printf("%d  %d  %d  %d  %d|", rep, rep, rep, rep, rep);
            }
            System.out.println();
        }
        System.out.print("+");
        for (int i = 0; i < amount; i++) {
            System.out.print("-------------+");
        }
        System.out.println();
    }

    //TODO: fix printing
    public void print() {
        int row = 0;
        int total = numFields;
        int top = 0;
        if (numFields >= 3) {
            top = 3;
        } else {
            top = numFields;
        }
        System.out.print("+");
        for (int i = 0; i < top; i++) {
            System.out.print("-------------+");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            int perRow = 0;
            for (int j = 0; j < 3; j++) {
                if (total == 0) {
                    break;
                }
                total--;
                perRow++;
            }
            if ((total == 0) && (perRow == 0)) {
                break;
            }
            printRow(perRow, row);
            row++;
        }
    }

    public void applyWeather(Weather weather) {
        for (int i = 0; i < numFields; i++) {
            weather.applyStatus(crops[i]);
        }
    }

    public String getCropType(int fieldNum) {
        return crops[fieldNum - 1].getName();
    }

    public void printCropTypes() {
        crops[0].printTypes();
    }

    public void printCropInfo() {
        crops[0].printInfo();
    }

    public int getNumFields() {
        return numFields;
    }

    public double getUpgradeValue() {
        return upgradeValue;
    }
}