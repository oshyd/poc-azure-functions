package org.example.functions;

import com.microsoft.azure.functions.ExecutionContext;

import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * Azure Functions with Timer Trigger.
 */
public class MyFunction {
    private static final String FUNC_ID = "[FIRST FUNCTION]";
    private static final Logger logger = LoggerFactory.getLogger(MyFunction.class);


    @FunctionName("timeScheduledRunner")
    public void run(
            @TimerTrigger(name = "timeScheduledRunnerTrigger",
                    schedule = "0 */1 * * * *") String timerInfo,
            final ExecutionContext context) {

        context.getLogger().info(FUNC_ID + " Try 1.0.0");
        context.getLogger().info(FUNC_ID + " I am a standard logger, but bellow you should see records from Logback logger");

        logger.info(FUNC_ID + " Logback logger is working. Time: " + LocalDateTime.now());

        logger.info(FUNC_ID + " logback info log record");
        logger.warn(FUNC_ID + " logback warn log record");
        logger.error(FUNC_ID + " logback error log record");

        logger.info("Logback logger levels testing finished");
        logger.info("Exception testing...");

        logger.info("1) Exception with try-catch:");
        try {
            int a = 5;
            int b = 0;
            int c = a / b;

        } catch (Exception e) {
            logger.error("Never divide by zero! Error: " + e.getMessage(), e);
        }

        logger.info("1) Not expected (unchecked) exception:");
        logger.info("Now I will throw runtime exception, please, be ready...");

        throw new RuntimeException("It's runtime Java exception");

    }



}
