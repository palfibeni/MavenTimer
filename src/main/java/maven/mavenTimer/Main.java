package maven.mavenTimer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        String testinput = "request";

        TaskTimer printer = new TaskTimerPrinter(5, 2);
        //TaskTimer writer = new TaskTimerWriter(5, 2);
        
        for(int i = 0; i < 40; i++){
            printer.recive(testinput + " " + i);
            //writer.recive(content + i);
        }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
