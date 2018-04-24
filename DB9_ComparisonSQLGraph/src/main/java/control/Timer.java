
package control;

/**
 *
 * @author che
 */
public class Timer {
    private long start;

    public Timer() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    public void resetTime() {
        start = System.currentTimeMillis();
}
}
