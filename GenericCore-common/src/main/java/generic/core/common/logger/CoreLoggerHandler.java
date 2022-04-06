package generic.core.common.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CoreLoggerHandler extends ConsoleHandler {
    @Override
    public void publish(LogRecord record) {
        super.publish(record);
    }

    @Override
    public void flush() {
        super.flush();
    }

    @Override
    public void close() throws SecurityException {
        super.close();
    }
}
