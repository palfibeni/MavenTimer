package maven.mavenTimer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class TaskTimer<E> {
    
    final int limit;
    final long time;
    private final Timer timer;
    private final LinkedBlockingQueue<E> queue;

    TaskTimer(int limit, long time) {
        this.limit = limit;
        this.time = time;
        this.queue = new LinkedBlockingQueue<>();
        timer = new Timer(true);

        timer.scheduleAtFixedRate(createTask(), 1000, time * 100);
    }

    public void recive(E data) throws InterruptedException {
        queue.put(data);
    }
    
    protected abstract void process(Collection<E> output);
    
    private TimerTask createTask(){
        return new TimerTask() {
            
            @Override
            public void run() {
                try {
                    
                Collection <E> output = new LinkedList<>();
                queue.drainTo((Collection<E>)output, limit);
                
                process(output);
                }
                catch (Exception e) {}
            }
        };
    }
    
}
