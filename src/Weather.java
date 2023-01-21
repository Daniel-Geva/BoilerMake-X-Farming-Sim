public class Weather {
    private String[] types = {"r", "s", "c", "n"};   //r=raining, s=sunny, c=cloudy, n=none
    private int[] percent = {45, 45, 10, 0};
    private String status;      //current status on the crop
    private int currPercent;

    /* Temp during different weathers
    * rainy: 38-80
    * sunny: 50-78
    * cloudy: 40-60
    * */

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

        int randWeather = (int) (Math.random() * 100);
        percent[randomIdx] = randWeather;
        currPercent = randWeather;
    }

    public void applyStatus(Crop crop) {
//        crop.weather = status;
        crop.setHealth(crop.getHealth() - (crop.getHealth() * (currPercent / 100)));
    }

    public void getWeather() {
        if (status.equals("r")) {
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
        }
        else if (status.equals("c")) {
            System.out.print("IT'S CLOUDY");
            System.out.println("          .-~~~-.\n" +
                    "  .- ~ ~-(       )_ _\n" +
                    " /                    ~ -.\n" +
                    "|                          ',\n" +
                    " \\                         .'\n" +
                    "   ~- ._ ,. ,.,.,., ,.. -~\n" +
                    "           '       '");
        }
        else if (status.equals("s")) {
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
                    "           *  /        ---     .  \\   jgs  .\n" +
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
            case "s" -> (int) (Math.random() * (78 - 50 + 1) + 50);
            case "r" -> (int) (Math.random() * (80 - 38 + 1) + 38);
            case "c" -> (int) (Math.random() * (60 - 40 + 1) + 40);
            default -> 70;
        };
    }
}
