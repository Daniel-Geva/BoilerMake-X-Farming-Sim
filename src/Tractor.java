public class Tractor {
    private int level;
    final int TIME_TO_PLOW_LVL1 = 60;
    final int TIME_TO_PLOW_LVL2 = 45;
    final int TIME_TO_PLOW_LVL3 = 35;
    final int TIME_TO_PLOW_LVL4 = 25;
    final int TIME_TO_PLOW_LVL5 = 10;

    final int ONE_TWO = 50;
    final int TWO_THREE = 100;
    final int THREE_FOUR = 150;
    final int FOUR_FIVE = 300;
    public Tractor() {
        level = 0;
    }
    public Tractor(int l) {
        level = l;
    }

    public int plow() {
        int[] arr = {TIME_TO_PLOW_LVL1, TIME_TO_PLOW_LVL2, TIME_TO_PLOW_LVL3, TIME_TO_PLOW_LVL4, TIME_TO_PLOW_LVL5};
        return arr[level-1];
    }
    public void levelUp(int money) {
        int[] arr = {ONE_TWO, TWO_THREE, THREE_FOUR, FOUR_FIVE};
        if(money > arr[level-1]) {
            level++;
        }
    }
}
