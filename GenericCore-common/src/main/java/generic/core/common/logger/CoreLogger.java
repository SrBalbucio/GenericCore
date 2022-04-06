package generic.core.common.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class CoreLogger{

    private Logger logger;
    private String plugin;
    public CoreLogger(Class main, String name){
        this.logger = Logger.getLogger(main.getName());
        this.logger.setLevel(Level.INFO);
        this.plugin = name;
    }

    public void log(Level level, String message){
        Handler handler = new CoreLoggerHandler();
        handler.setFormatter(new CoreLoggerFormat(CoreLoggerType.INFO, plugin));
        handler.setLevel(level);
        handler.publish(new LogRecord(level, message));
    }
    public void start(Level level, String message){
        Handler handler = new CoreLoggerHandler();
        handler.setFormatter(new CoreLoggerFormat(CoreLoggerType.START, plugin));
        handler.setLevel(level);
        handler.publish(new LogRecord(level, message));
    }
    public void stop(Level level, String message){
        Handler handler = new CoreLoggerHandler();
        handler.setFormatter(new CoreLoggerFormat(CoreLoggerType.STOP, plugin));
        handler.setLevel(level);
        handler.publish(new LogRecord(level, message));
    }
    public void erro(Level level, String message){
        Handler handler = new CoreLoggerHandler();
        handler.setFormatter(new CoreLoggerFormat(CoreLoggerType.ERRO, plugin));
        handler.setLevel(level);
        handler.publish(new LogRecord(level, message));
    }

    public static void out(String msg){
        System.out.print("[GenericLogger] "+msg);
    }

}
