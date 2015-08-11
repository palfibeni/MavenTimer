package maven.mavenTimer;

import java.util.Collection;

public class TaskTimerPrinter extends TaskTimer{

    public TaskTimerPrinter(int limit, long time) {
        super(limit, time);
    }

    @Override
    protected void process(Collection output) {
        System.out.println(output);
    }  
}
