public class Weather {
    private final String[] types = {"r", "s", "c"};   //r=raining, s=sunny, c=cloudy
    private final int[] percent = {50, 40, 10};
    private String status;      //current status on the crop
    private String weather;     //chosen weather
    private String crop;        //type of crop we're using
    private int currPercent;

    /* Temp during different weathers
    * rainy: 38-80
    * sunny: 50-78
    * cloudy: 40-60
    * */

    //TODO: make an effect of each weather
    public Weather(String currStatus, String typeCrop, int percent) {
        status = currStatus;
        crop = typeCrop;
        for (int i = 0; i < types.length; i++) {
            if (types[i].equals(currStatus)) {
                this.percent[i] = percent;
                currPercent = percent;
                break;
            }
        }
    }

    public void applyStatus(int newPercent) {
        int max = types.length;        //max num of types
        int min = 1;        //min num of types
        int random = (int) (Math.random() * (max - min + 1) + min);
        status = types[random];
        percent[random] = newPercent;
        currPercent = newPercent;
        //TODO: apply status to the crops
    }

    public void showForcast() {
        int max = 100;
        int min = 0;
        int random = (int) (Math.random() * (max - min + 1) + min);
        //TODO: account for the status and the weather
    }

    public int temperatureMod() {
        return switch (this.status) {
            case "s" -> (int) (Math.random() * (78 - 50 + 1) + 50);
            case "r" -> (int) (Math.random() * (80 - 38 + 1) + 38);
            case "c" -> (int) (Math.random() * (60 - 40 + 1) + 40);
            default -> -1;
        };
    }



}
