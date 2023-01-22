import java.util.Scanner;

public class Interface {

    private static int scan(int type) {
        Scanner scan = new Scanner(System.in);
        if (type == 1) {
            return scan.nextInt();
        } else if (type == 2) {
            scan.nextLine();
            return 1;
        }
        return -1;
    }

    private static void planting(Field field, double money) {
        int numFields = field.getNumFields();
        boolean plantLoop = true;
        while (plantLoop) {
            clear();
            field.print();
            System.out.println("You have " + numFields + " fields to plant");
            System.out.println("Choose a field to plant, or type 0 to go back:");
            int fieldNum = scan(1);
            if (fieldNum == 0) {
                plantLoop = false;
                continue;
            }
            System.out.println("Choose a crop to plant:");
            field.printCropTypes();
            int cropNum = scan(1);
            int result = field.plant(cropNum, fieldNum, money);
            if (result == -1) {
                System.out.println("Invalid field number");
                System.out.println("Press ENTER to continue");
                scan(2);
            } else if (result == -2) {
                System.out.println("Invalid crop type");
                System.out.println("Press ENTER to continue");
                scan(2);
            } else if (result == -3) {
                System.out.println("Not enough money to afford that seed");
                System.out.println("Press ENTER to continue");
                scan(2);
            } else {
                System.out.printf("Planted %s\n", field.getCropType(fieldNum));
                System.out.println("Press ENTER to continue");
                scan(2);
            }
        }
    }

    private static void cropInfo(Field field) {
        clear();
        field.printCropInfo();
        System.out.println("Press ENTER to continue");
        scan(2);
    }

    private static void weatherForecast(Weather weather) {
        clear();
        weather.showForecast();
        System.out.println("Press ENTER to continue");
        scan(2);
    }

    private static double upgrade(Field field, Tractor tractor, double money) {
        boolean upgradeLoop = true;
        while (upgradeLoop) {
            clear();
            System.out.printf("You have $%.2f\n", money);
            System.out.println("Possible Upgrades:");
            if (field.getUpgradeValue() == -1) {
                System.out.println("1) Maximum number of fields reached");
            } else {
                System.out.printf("1) Add another field: $%.2f\n", field.getUpgradeValue());
            }
            if (tractor.getLevel() == 9) {
                System.out.println("2) Maximum tractor level reached");
            } else {
                System.out.printf("2) Upgrade tractor: $%.2f\n", tractor.getUpgradeCost());
            }
            System.out.println("3) Back");

            int resp = scan(1);
            if (resp == 1) {
                double result = field.expandFields(money);
                if (result == -1) {
                    System.out.println("Insufficient funds to expand fields");
                } else if (result == -2) {
                    System.out.println("Maximum number of fields reached");
                } else {
                    System.out.printf("Added new field, total number of fields is now %d\n", field.getNumFields());
                    money = result;
                }
            } else if (resp == 2) {
                int preLevel = tractor.getLevel();
                double result = tractor.levelUp(money);
                if (preLevel == 9) {
                    System.out.println("Maximum tractor level reached");
                } else if (result == -1) {
                    System.out.println("Insufficient funds to upgrade tractor");
                } else {
                    System.out.printf("Tractor upgraded to level %d and is type %s\n", tractor.getLevel(), tractor.getType());
                    money = result;
                }
            } else if (resp == 3) {
                upgradeLoop = false;
                continue;
            } else {
                scan(2);
            }
            System.out.println("Press ENTER to continue");
            scan(2);
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
        Tractor tractor = new Tractor();
        double money = 50;

        boolean running = true;
        while (running) {
            weather.generatePercentages();
            boolean innerLoop = true;
            while (innerLoop) {
                clear();
                System.out.println("Here is your farm:");
                field.print();
                System.out.println("Select an action:");
                System.out.println("1: Plant a field");
                System.out.println("2: View crop info");
                System.out.println("3: View weather forecast");
                System.out.println("4: Upgrade");
                System.out.println("5: Advance");
                System.out.println("6: Exit");
                int response = scan(1);
                if (response == 1) {
                    planting(field, money);
                } else if (response == 2) {
                    cropInfo(field);
                } else if (response == 3) {
                    weatherForecast(weather);
                } else if (response == 4) {
                    money = upgrade(field, tractor, money);
                } else if (response == 5) {
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

                double harvest = field.harvest(tractor);
                money += harvest;
                System.out.printf("Congratulations! You made $%.2f this harvest! Your new total is %.2f\n", harvest, money);
                System.out.println("Press ENTER to continue");
                scan(2);
            }
        }
    }
}