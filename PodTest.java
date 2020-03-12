public class PodTest extends TestSuite {
    public static void main(String[] args) {
        TestSuite.run(new PodTest());
    }

    public Test[] getTests() {
        return new Test[] {
            new Test("Name in constructor returned in getName", () -> {
                expectEqual(new Pod("pod1", t -> 500.0).getName(), "pod1");
            }),
            new Test("Velocity function works as expected", () -> {
                var pod = new Pod("pod2", t -> t * 20.0);
                expectEqual(pod.v(5), 100.0);
            }),
            new Test("Distance traveled test with few slices", () -> {
                var pod = new Pod("pod3", t -> t * 20.0);
                // From t=0 to t=2.5: 0*2.5 = 0
                // From t=2.5 to t=5: 50*2.5 = 125
                expectEqual(pod.distanceTraveled(0, 5, 2), 125.0);
            }),
            new Test("Distance traveled test with many slices", () -> {
                var pod = new Pod("pod4", t -> t * 20.0);
                expectWithin(pod.distanceTraveled(0, 5, 1000), 250.0, 0.5);
            }),
            new Test("ConstantVelocityPod", () -> {
                var pod = new ConstantVelocityPod("pod5", 16.0);
                expectWithin(pod.distanceTraveled(10, 20, 128), 160.0, 0.01);
            }),
            new Test("LogarithmicPod", () -> {
                var pod = new LogarithmicPod("pod6", 3.0, 5.2);
                expectWithin(pod.distanceTraveled(10, 20, 32768), 98.6, 0.1);
            }),
            new Test("A strange pod", () -> {
                var pod = new Pod("pod7", t -> (t/5) + Math.sin(t) * Math.log(t + 3));
                expectWithin(pod.distanceTraveled(10, 20, 4096), 13.29, 0.3);
            }),
        };
    }
}


