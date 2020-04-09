public class ConstantVelocityPod extends Pod {
    public ConstantVelocityPod(final String name, final double velocity) {
        super(name, t -> velocity);
    }
    public double distancedTraveled(final double startTime, final double endTime) {
      return (endTime - startTime) * (v(startTime) + v(endTime));
    }
}