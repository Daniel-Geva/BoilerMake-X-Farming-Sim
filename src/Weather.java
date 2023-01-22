public class Weather {
    private final String[] types = {"rainy", "sunny", "cloudy", "none"};
    private int[] percent = {45, 45, 10, 0};
    private String status;      //current status on the crop
    private int currPercent;

    /* Temp during different weathers
     * rainy: 38-80
     * sunny: 50-78
     * cloudy: 40-60
     */

    public String getStatus() {
        return status;
    }

    public int getCurrPercent() {
        return currPercent;
    }

    public Weather() {
        status = "n";
        currPercent = 0;
    }

    public Weather(String currStatus, int percent) {
        status = currStatus;
        for (int i = 0; i < types.length; i++) {
            if (types[i].equals(currStatus)) {
                this.percent[i] = percent;
                currPercent = percent;
                break;
            }
        }
    }

    public void generatePercentages() {
        int one = 0;
        int two = 0;
        int three = 0;
        do {
            one = (int) Math.abs(Math.random() * 100);
            two = (int) Math.abs(Math.random() * 100);
            three = (int) Math.abs(Math.random() * 100);
        } while ((one + two + three) != 100);

        this.percent[0] = one;
        this.percent[1] = two;
        this.percent[2] = three;
    }

    public void generateWeather() {
        int max = types.length - 1;
        int min = 1;
        int randomIdx = (int) (Math.random() * (max - min + 1) + min);
        status = types[randomIdx];
        currPercent = percent[randomIdx];
    }

    public void applyStatus(Crop crop) {
        int random = (int) (Math.random() * (25 - 2 + 1) + 2);
        if (status.equals(types[0])) {
            crop.setWaterLevel((int) (crop.waterLevel + random));
        }
        else if (status.equals(types[1])) {
            crop.setWaterLevel((int) (crop.waterLevel - random));
        }
        else if (status.equals(types[2])) {
            crop.setWaterLevel((int) crop.waterLevel);
        }
    }

    public void getWeather() {
        switch (status) {
            case "rainy" -> {
                System.out.println("OH NO! IT'S RAINING");
                System.out.println("                                        ___    ,'\"\"\"\"'.\n" +
                        "                                    ,\"\"\"   \"\"\"\"'      `.\n" +
                        "                                   ,'        _.         `._\n" +
                        "                                  ,'       ,'              `\"\"\"'.\n" +
                        "                                 ,'    .-\"\"`.    ,-'            `.\n" +
                        "                                ,'    (        ,'                :\n" +
                        "                              ,'     ,'           __,            `.\n" +
                        "                        ,\"\"\"\"'     .' ;-.    ,  ,'  \\             `\"\"\"\".\n" +
                        "                      ,'           `-(   `._(_,'     )_                `.\n" +
                        "                     ,'         ,---. \\ @ ;   \\ @ _,'                   `.\n" +
                        "                ,-\"\"'         ,'      ,--'-    `;'                       `.\n" +
                        "               ,'            ,'      (      `. ,'                          `.\n" +
                        "               ;            ,'        \\    _,','                            `.\n" +
                        "              ,'            ;          `--'  ,'                              `.\n" +
                        "             ,'             ;          __    (                    ,           `.\n" +
                        "             ;              `____...  `78b   `.                  ,'           ,'\n" +
                        "             ;    ...----'''' )  _.-  .d8P    `.                ,'    ,'    ,'\n" +
                        "_....----''' '.        _..--\"_.-:.-' .'        `.             ,''.   ,' `--'\n" +
                        "              `\" ___ \"\" _.-'' .-'`-.:..___...--' `-._      ,-\"'   `-'\n" +
                        "        _.--'       _.-'    .'   .' .'               `\"\"\"\"\"\n" +
                        "  __.-''        _.-'     .-'   .'  /\n" +
                        " '          _.-' .-'  .-'        .'\n" +
                        "        _.-'  .-'  .-' .'  .'   /\n" +
                        "    _.-'      .-'   .-'  .'   .'\n" +
                        "_.-'       .-'    .'   .'    /\n" +
                        "       _.-'    .-'   .'    .'\n" +
                        "    .-'            .'");
            }
            case "cloudy" -> {
                System.out.print("IT'S CLOUDY");
                System.out.println("          .-~~~-.\n" +
                        "  .- ~ ~-(       )_ _\n" +
                        " /                    ~ -.\n" +
                        "|                          ',\n" +
                        " \\                         .'\n" +
                        "   ~- ._ ,. ,.,.,., ,.. -~\n" +
                        "           '       '");
            }
            case "sunny" -> {
                System.out.println("IT'S SUNNY!!");
                System.out.println("                        |\n" +
                        "                    .   |\n" +
                        "                        |\n" +
                        "          \\    *        |     *    .  /\n" +
                        "            \\        *  |  .        /\n" +
                        "         .    \\     ___---___     /    .  \n" +
                        "                \\.--         --./     \n" +
                        "     ~-_    *  ./               \\.   *   _-~\n" +
                        "        ~-_   /    ^         ^    \\   _-~     *\n" +
                        "   *       ~-/    ___       ___    \\-~        \n" +
                        "     .      |    (_O_)     (_O_)    |      .\n" +
                        "         * |                         | *     \n" +
                        "-----------|                         |-----------\n" +
                        "  .        |    <               >    |        .    \n" +
                        "        *   |    \\             /    | *\n" +
                        "           _-\\    `.         .'    /-_    *\n" +
                        "     .  _-~ . \\     `-.___.-'     /   ~-_     \n" +
                        "     _-~       `\\               /'*      ~-_  \n" +
                        "    ~           /`--___   ___--'\\           ~\n" +
                        "           *  /        ---     .  \\        .\n" +
                        "            /     *     |           \\\n" +
                        "          /             |   *         \\\n" +
                        "                     .  |        .\n" +
                        "                        |\n" +
                        "                        |");
            }
        }
    }


    public void showForecast() {
        System.out.println("The estimated weather pattern and their percentages are:");
        for (int i = 0; i < types.length - 1; i++) {
            System.out.println(types[i] + ": " + percent[i]);
        }
    }

    public int temperatureMod() {
        return switch (this.status) {
            case "sunny" -> (int) (Math.random() * (78 - 50 + 1) + 50);
            case "rainy" -> (int) (Math.random() * (80 - 38 + 1) + 38);
            case "cloudy" -> (int) (Math.random() * (60 - 40 + 1) + 40);
            default -> 70;
        };
    }
}
