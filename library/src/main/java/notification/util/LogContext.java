package notification.util;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

import java.util.Map;

@AllArgsConstructor
public class LogContext {

    private final Logger logger;

    public LogContext(Class c) {
        logger = LoggerFactory.getLogger(c);
    }

    public void info(Map<String,Object> requestContext, String message) {
        if (null != requestContext) {
            //logger.info(Markers.appendEntries(requestContext), message);
            logger.info(message);
        } else {
            logger.info(message);
        }
    }

    public void info(String message) {
        logger.info(message);
    }

}
