package me.spacenough.logger;

import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

public class Logger {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
    private final StringBuilder sb = new StringBuilder();

    public void info(@NotNull String... messages){
        for (String text : messages){
            sb.append(" ").append(text);
        }

        logger.info("[Elendil INFO]: {}", sb);
    }

    public void warn(@NotNull String... messages){
        for (String text : messages){
            sb.append(" ").append(text);
        }

        logger.info("[Elendil WARN]: {}", sb);
    }

    public void error(@NotNull String... messages){
        for (String text : messages){
            sb.append(" ").append(text);
        }

        logger.info("[Elendil ERROR]: {}", sb);
    }
}
