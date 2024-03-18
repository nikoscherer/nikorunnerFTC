package Other;
public class Round {
    public static double roundToDecimal(double num, int decimals) {


        double rounded;

        rounded = num * Math.pow(10, decimals);
        rounded = Math.round(rounded) / Math.pow(10, decimals);

        return rounded;
    }
}
