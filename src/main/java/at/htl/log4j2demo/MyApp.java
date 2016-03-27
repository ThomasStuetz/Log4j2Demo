package at.htl.log4j2demo;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;

public class MyApp {

    static Logger logger = LogManager.getLogger(MyApp.class.getSimpleName());

    public static void main(String[] args) {

        logger.info("*** MyApp launched ***");

        System.out.println("Logging Level: " + logger.getLevel());

        logger.trace("This is a message on level TRACE");
        logger.debug("This is a message on level DEBUG");
        logger.info("This is a message on level INFO");
        logger.warn("This is a message on level WARN");
        logger.error("This is a message on level ERROR");
        logger.fatal("This is a message on level FATAL");
        if (logger.getLevel() == Level.OFF) {
            System.out.println(" **** This is a message when logger is OFF ***");
        }

        // Set new log-level
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration conf = ctx.getConfiguration();
        conf.getLoggerConfig(MyApp.class.getSimpleName()).setLevel(Level.INFO);
        ctx.updateLoggers(conf);

        System.out.println("Logging Level: " + logger.getLevel());

        logger.trace("This is another message on level TRACE");
        logger.debug("This is another message on level DEBUG");
        logger.info("This is another message on level INFO");
        logger.warn("This is another message on level WARN");
        logger.error("This is another message on level ERROR");
        logger.fatal("This is another message on level FATAL");
        if (logger.getLevel() == Level.OFF) {
            System.out.println(" **** This is a message when logger is OFF ***");
        }


        int result = sum(2, 2);
        System.err.printf("2 + 2 is %d%n", result);
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}

