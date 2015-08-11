package maven.mavenTimer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class TaskTimerWriter extends TaskTimer {

    public TaskTimerWriter(int limit, long time) {
        super(limit, time);
    }

    @Override
    protected void process(Collection output) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("result.txt", true)))) {
            out.println(output.toString());
            
            System.out.println("Line writed");
            out.close();

        } catch (IOException e) {}
    }
}
