/*
Group Number: 90
Group Members: Maahir Hussain Shaik(ID: 21154501)
               Roshan Varughese(ID: 21137055)
Class Name: Log
Class Function:
It logs data along with timestamps and stores them in a LinkedHashMap.
It can print the logged data with timestamps.
It provides methods to save the log to a file and load the log from a file.
This class is designed for logging and managing actions with timestamps, including methods to log, print, save, and load log data.
 */

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Log
{

    Map<String, String> log;

    public Log()
    {
        log = new LinkedHashMap<>();
    }

    public void logData(String data)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(StringResources.LOG_DATE_TIME_FORMAT);
        Date date = new Date();
        this.log.put(formatter.format(date), data);
        System.out.println(formatter.format(date) + " " + data);
    }

    public void printLog()
    {
        for(Map.Entry log: this.log.entrySet()){
            System.out.println(log.getKey()+ " "+log.getValue());
        }
    }

    //Start of Partially ChatGPT Generated Code
    public void saveLog() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(StringResources.FILE_PATH_3))) {
            writer.println("DATE/TIME, Action");
            for (Map.Entry<String, String> entry : log.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error saving log: " + e.getMessage());
        }
    }
    //End of Partially ChatGPT Generated Code

    public void loadLog() {
        try (BufferedReader reader = new BufferedReader(new FileReader(StringResources.FILE_PATH_3))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    log.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading log: " + e.getMessage());
        }
    }

}
