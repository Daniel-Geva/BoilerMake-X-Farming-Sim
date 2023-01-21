public class Field {
    private Crop[] crops;
    private int numFields;
    private int upgradeValue;
    //TODO: have an empty crop type

    Field() {
        this.crops = new Crop[9];
        this.numFields = 1;
        this.upgradeValue = 10;
    }

    public int harvest() {
        int total = 0;
        for (int i = 0; i < numFields; i++) {
            total += crops[i].value() * crops[i].remaining();
            crops[i].plant(0); //set fields empty
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
        if ((type > 5) || (type < 1)) {
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
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < amount; j++) {
                int rep = crops[(row * 3) + j].type();
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
        for (int i = 0; i < 3; i++) {
            int perRow = (numFields - (row * 3)) / (3 - row);
            if (perRow < 0) {
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