import java.util.function.Function;

public class Pod {
    // ADD TWO PRIVATE FIELDS, name and velocityFunction

    public Pod(String name, Function<Double, Double> velocityFunction) {
        // IMPLEMENT THIS CONSTRUCTOR
    }

    public String getName() {
        // IMPLEMENT THIS METHOD
        return "";
    }

    public double v(double t) {
        return velocityFunction.apply(t);
    }

    public double distanceTraveled(double startTime, double endTime, int slices) {
        // IMPLEMENT THIS METHOD
        return 0.0;
    }
}
