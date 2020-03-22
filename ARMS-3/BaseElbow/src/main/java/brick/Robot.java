package brick;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

public class Robot{
    static Timer timer = new Timer("MainLoop", false);
    static final long startNanoTime = System.currentTimeMillis();
    static final long updateIntervalMillisTime = 10000 / 100; //every 1/10th sec
    static AtomicLong updatesCompleted = new AtomicLong(0);
    static TimerTask periodic = new TimerTask(){
        @Override
        public void run() {
            //RobotContainer.robotPeriodic();
        }
    };
    public static void startRobot(){
        System.out.println("RobotStarting");
        timer.schedule(periodic, 0, updateIntervalMillisTime);
        RobotContainer.robotInit();
    }

}