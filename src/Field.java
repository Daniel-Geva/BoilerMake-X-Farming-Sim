public class Field {
    private Crop[] crops;
    private int numFields;
    private int upgradeValue;
    //TODO: have an empty crop type

    public Field() {
        this.crops = new Crop[9];
        for (int i = 0; i < 9; i++) {
            crops[i] = new Crop("Soil");
        }
        this.numFields = 1;
        this.upgradeValue = 10;
    }

    public int harvest() {
        int total = 0;
        for (int i = 0; i < numFields; i++) {
            total += crops[i].getValue() * crops[i].getHarvest();
            crops[i].plant(0);
        }
        return total;
    }

    public int expandFields(int money) {
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
        crops[field].plant(type);
        return type;
    }

    private void printRow(int amount, int row) {
        System.out.print("+");
        for (int i = 0; i < amount; i++) {
            System.out.print("-------------+");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("|");
            for (int j = 0; j < amount; j++) {
                int rep = crops[(row * 3) + j].getNumber_Name();
                //System.out.printf("[crops[(%d)]].getNumber_Name()\n", (row * 3) + 1);
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
        //System.out.printf("crops[%d].getNumber_Name() = %d\n", fieldNum, crops[fieldNum].getNumber_Name());
        return crops[fieldNum].getName();
    }

    public void printCropTypes() {
        crops[0].printTypes();
    }

    public int getNumFields() {
        return numFields;
    }

    public int getUpgradeValue() {
        return upgradeValue;
    }
}

/*
 *            +-------------+
 *            |c  c  c  c  c|
 *            |c  c  c  c  c|
 *            |c  c  c  c  c|
 *            |c  c  c  c  c|
 *            |c  c  c  c  c|
 *            +-------------+
 *
 */