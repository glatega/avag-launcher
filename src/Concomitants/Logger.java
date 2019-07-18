package src.Concomitants;

import java.io.*;

public class Logger {
    private PrintStream fileStream;
    private PrintStream console;
    
    public Logger(String filename) {
        try {
            File file = new File(filename);

            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            console = System.out;
            fileStream = new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String msg) {
        System.setOut(fileStream);
        System.out.println(msg);
        System.setOut(console);
    }
}
