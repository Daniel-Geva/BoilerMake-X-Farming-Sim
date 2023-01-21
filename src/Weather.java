public class Weather {
    private final String[] types = {"rainy", "sunny", "cloudy", "none"};   //r=raining, s=sunny, c=cloudy, n=none
    private int[] percent = {45, 45, 10, 0};
    private String status;      //current status on the crop
    private int currPercent;

    /* Temp during different weathers
     * rainy: 38-80
     * sunny: 50-78
     * cloudy: 40-60
     * */

    //rice wants wet
    //wheat needs to be dry

    public String getStatus() {
        return status;
    }

    public int getCurrPercent() {
        return currPercent;
    }

    //TODO: make an effect of each weather
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

    public void generateWeather() {
        int max = types.length - 1;        //max num of types
        int min = 1;        //min num of types
        int randomIdx = (int) (Math.random() * (max - min + 1) + min);
        status = types[randomIdx];

        int randWeather = (int) (Math.random() * 50);
        percent[randomIdx] = randWeather;
        currPercent = randWeather;
    }

    public void applyStatus(Crop crop) {
        crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)));
        if (status.equals(types[0])) {
            crop.setWaterLevel((int) (crop.waterLevel + 25));
        }
        else if (status.equals(types[1])) {
            crop.setWaterLevel((int) (crop.waterLevel - 25));
        }
        else if (status.equals(types[2])) {
            crop.setWaterLevel((int) crop.waterLevel);
        }
    }

    public void tracProtec(Tractor tractor, Crop crop) {
        int level = tractor.getLevel();

        if (level == 1) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.04);
        } else if (level == 2) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.08);
        } else if (level == 3) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.14);
        } else if (level == 4) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.2);
        } else if (level == 5) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.3);
        } else if (level == 6) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.44);
        } else if (level == 7) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.55);
        } else if (level == 8) {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 0.7);
        } else {
            crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)) + 1);
        }
    }

    public void getWeather() {
        if (status.equals("rainy")) {
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
                    "              `\" mGk \"\" _.-'' .-'`-.:..___...--' `-._      ,-\"'   `-'\n" +
                    "        _.--'       _.-'    .'   .' .'               `\"\"\"\"\"\n" +
                    "  __.-''        _.-'     .-'   .'  /\n" +
                    " '          _.-' .-'  .-'        .'\n" +
                    "        _.-'  .-'  .-' .'  .'   /\n" +
                    "    _.-'      .-'   .-'  .'   .'\n" +
                    "_.-'       .-'    .'   .'    /\n" +
                    "       _.-'    .-'   .'    .'\n" +
                    "    .-'            .'");
        } else if (status.equals("cloudy")) {
            System.out.print("IT'S CLOUDY");
            System.out.println("          .-~~~-.\n" +
                    "  .- ~ ~-(       )_ _\n" +
                    " /                    ~ -.\n" +
                    "|                          ',\n" +
                    " \\                         .'\n" +
                    "   ~- ._ ,. ,.,.,., ,.. -~\n" +
                    "           '       '");
        } else if (status.equals("sunny")) {
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


    public void showForecast() {
        System.out.println("The estimated weather pattern and their respective percentage are:");
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
