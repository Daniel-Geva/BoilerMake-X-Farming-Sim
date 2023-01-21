import java.util.Scanner;

public class Interface {
    //TODO: figure out how to clear terminal (print many newlines?)

    private static int scanInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static void planting(Field field) {
        clear();
        int numFields = field.getNumFields();
        boolean plantLoop = true;
        while (plantLoop) {
            field.print();
            System.out.println("You have " + numFields + " fields to plant");
            System.out.println("Choose a field to plant:");
            int fieldNum = scanInt();
            System.out.println("Choose a crop to plant:");
            field.printCropTypes();
            int cropNum = scanInt();
            int result = field.plant(cropNum, fieldNum);
            if (result == -1) {
                System.out.println("Invalid field number");
            } else if (result == -2) {
                System.out.println("Invalid crop type");
            } else if (result == 9) {
                plantLoop = false;
            } else {
                System.out.printf("Planted %s\n", field.getCropType(fieldNum));
            }
        }
    }

    private static void cropInfo() {
        //TODO: print crop info
    }

    private static void weatherForcast(Weather weather) {
        weather.showForecast();
        //TODO: forecast the weather
    }

    private static int upgrade(Field field, int money) {
        clear();
        System.out.println("Possible Upgrades:");
        if (field.getUpgradeValue() == -1) {
            System.out.println("1) Max number of fields reached");
        } else {
            System.out.printf("1) Add another field: %d\n", field.getUpgradeValue());
        }
        //TODO: add other upgrades

        int resp = scanInt();
        if (resp == 1) {
            int result = field.expandFields(money);
            if (result == -1) {
                System.out.println("Insufficient funds to expand fields");
            } else {
                money = result;
            }
        }

        return money;
    }

    private static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Field field = new Field();
        Weather weather = new Weather();
        int money = 0;

        boolean running = true;
        while (running) {
            boolean innerLoop = true;
            while (innerLoop) {
                clear();
                System.out.println("Here is your farm:");
                field.print();
                System.out.println("Select an action:");
                System.out.println("1: Plant a field");
                System.out.println("2: View crop types");
                System.out.println("3: View weather forecast");
                System.out.println("4: Upgrade");
                System.out.println("5: Advance");
                System.out.println("6: Exit");
                int response = scanInt();
                if (response == 1) {
                    planting(field);
                } else if (response == 2) {
                    cropInfo();
                } else if (response == 3) {
                    weatherForecast(weather);
                } else if (response == 4) {
                    money = upgrade(field, money);
                } else if (response == 5) {
                    //TODO: advance time
                    innerLoop = false;
                } else if (response == 6) {
                    innerLoop = false;
                    running = false;
                } else {
                    System.out.println("Invalid selection, please try again");
                }
            }

            if (running) {
                weather.generateWeather();
                field.applyWeather(weather);
                weather.getWeather();
                int harvest = field.harvest();
                money += harvest;
                System.out.printf("Congratulations! You made $%d this harvest! Your new total is %d\n", harvest, money);

            }
        }
    }
}