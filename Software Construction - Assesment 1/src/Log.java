import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Log
{
    //String Date / Time, String Action
    //24/09/2003 13:48:32 Added P1(12333)x3 to L1
    //24/09/2003 13:48:32 Removed P1(12333)x1 from L1
    //24/09/2003 13:48:32 Moved P1(12333)x5 from L1 to L2
    //24/09/2003 13:48:32 Created New Location L5
    //24/09/2003 13:48:32 Created New Product P2(12334) with price $299.98
    Map<String, String> log;

    public Log()
    {
        log = new LinkedHashMap<String, String>();
    }

    public void logData(String data)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.log.put(formatter.format(date), data);
        System.out.println(formatter.format(date) + data);
    }

    public void printLog()
    {
        for(Map.Entry log: this.log.entrySet()){
            System.out.println(log.getKey()+ " "+log.getValue());
        }
    }

}
