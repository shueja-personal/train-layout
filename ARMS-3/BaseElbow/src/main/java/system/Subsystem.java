package system;

public interface Subsystem {
    public void periodic();
    public void home();
    public boolean isFinished();
}