package generic.core.common.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CoreLoggerFormat extends Formatter {

    private CoreLoggerType type = CoreLoggerType.INFO;
    private String plugin = "NULL";
    public CoreLoggerFormat(CoreLoggerType type, String plugin){
        this.type = type;
        this.plugin = plugin;
    }
    @Override
    public String format(LogRecord record) {
        switch(type) {
            case START:
                return "§e[GenericLogger] [" + record.getLevel() + "] [" + plugin + "] §aSTARTING: " + record.getMessage() + " §b[" + record.getThreadID() + "]";
            case STOP:
                return "§e[GenericLogger] [" + record.getLevel() + "] [" + plugin + "] §cSTOPING: " + record.getMessage() + " §b[" + record.getThreadID() + "]";
            case INFO:
                return "§e[GenericLogger] [" + record.getLevel() + "] [" + plugin + "] §bMessage: " + record.getMessage() + " §b[" + record.getThreadID() + "]";
            case ERRO:
                return "§e[GenericLogger] [" + record.getLevel() + "] [" + plugin + "] §4ERRO: " + record.getMessage() + " §b[" + record.getThreadID() + "]";
            default:
                return "§e[GenericLogger] [" + record.getLevel() + "] [" + plugin + "] §bINVALID: " + record.getMessage() + " §b[" + record.getThreadID() + "]";
        }
    }
}
