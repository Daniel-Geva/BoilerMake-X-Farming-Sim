import java.util.Scanner;

public class Interface {
    //TODO: figure out how to clear terminal (print many newlines?)
    private static void planting(Field field) {
        //clear();
        int numFields = field.getNumFields();
        field.print();
        System.out.println("You have " + numFields + " fields to plant");
        System.out.println("Choose a field and crop to plant:");

        //TODO: finish planting method
    }

    private static void cropInfo() {
        //TODO: print crop info
    }

    private static void weatherForecast() {
        //TODO: forecast the weather
    }

    private static void upgrade() {
        //TODO: upgrades
    }

    private static void clear() {
        //TODO: clear screen
    }

    public static void main(String[] args) {
        Field field = new Field();
        int money = 0;
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Here is your farm:");
            field.print();
            boolean innerLoop = true;
            while (innerLoop) {
                System.out.println("Select an action:");
                System.out.println("1: Plant a field");
                System.out.println("2: View crop types");
                System.out.println("3: View weather forecast");
                System.out.println("4: Upgrade");
                System.out.println("5: Advance");
                System.out.println("6: Exit");
                int response = scan.nextInt();
                if (response == 1) {
                    planting(field);
                } else if (response == 2) {
                    cropInfo();
                } else if (response == 3) {
                    weatherForecast();
                } else if (response == 4) {
                    upgrade();
                } else if (response == 5) {
                    //TODO: advance time
                } else if (response == 6) {
                    innerLoop = false;
                    running = false;
                } else {
                    System.out.println("Invalid selection, please try again");
                }
            }
        }
    }
}