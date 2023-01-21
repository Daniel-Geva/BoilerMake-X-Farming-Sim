public class Weather {
    private String status;      //current status on the crop
    private String weather;     //chosen weather
    private String crop;        //type of crop we're using
    private int percent;
    private String newStatus;

    //make an effect of each weather
    public Weather(String currStatus, String typeCrop) {
        status = currStatus;
        crop = typeCrop;
        percent = 50;       //default percent
        newStatus = "";
    }

    public void applyStatus() {
        String[] types = {"raining", "sunny", "cloudy"};
        int[] percentArr = {70, 60, 30};
        int max = 3;        //max num of types
        int min = 1;        //min num of types
        int random = (int) (Math.random() * (max - min + 1) + min);
        newStatus = types[random];
        percent = percentArr[random];
    }

    public void showForcast() {

    }

}
