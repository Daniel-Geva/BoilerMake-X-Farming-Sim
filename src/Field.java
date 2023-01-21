public class Field {
    private int[][][] field;
    private Crop[] crops;
    private int numFields;
    private int upgradeValue;
    //TODO: have an empty crop type

    Field() {
        this.field = new int[9][5][5];
        this.crops = new Crop[9];
        this.numFields = 1;
        this.upgradeValue = 10;
    }

    public int harvest() {
        int total = 0;
        for (int i = 0; i < numFields; i++) {
            total += crops[i].value() * crops[i].remaining();
            crops[i].plant(-1); //set fields empty
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

    public void print() {
        //TODO: print existing fields
    }

    public int getNumFields() {
        return numFields;
    }
}