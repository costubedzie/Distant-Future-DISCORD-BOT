package me.spacenough;

import com.dynxsty.dih4jda.DIH4JDA;
import com.dynxsty.dih4jda.DIH4JDABuilder;
import com.dynxsty.dih4jda.DIH4JDALogger;
import com.dynxsty.dih4jda.exceptions.DIH4JDAException;
import me.spacenough.logger.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import java.time.LocalDate;

public class Elendil {
    private static JDA jda;

    private static String defaultPackage = "me.spacenough";
    private static String botVersion = "1.0-SNAPSHOT";

    private static Logger logger;

    public static void main(String[] args) {
        execute(args);
    }

    private static void execute(String... args) {
        logger = new Logger();
        init(args);
        botRpc();
    }

    private static void init(String... args) {
        try {
            jda = JDABuilder.createDefault(args[0]).build();
        } catch (Exception e) {
            logger.error("Failed to start bot!", " Possible causes: ");
            logger.error("Invalid token");
            logger.error("Network problems");
            logger.error("Discord API problems");
        }

        try {
            DIH4JDA dih4JDA = DIH4JDABuilder
                    .setJDA(jda)
                    .setCommandsPackage(defaultPackage + ".commands")
                    .disableLogging(DIH4JDALogger.Type.ERROR)
                    .build();
        } catch (DIH4JDAException e) {
            logger.warn("Cannot initialize commands!");
        }
    }

    private static void botRpc() {

        LocalDate date = LocalDate.now();
        LocalDate christmas = LocalDate.parse(  "2022-12-24");

        if (date.equals(christmas)) {
            String christmasMessage = "Merry Christmas Everyone!";

            jda.getPresence().setActivity(Activity.listening(christmasMessage));
        } else {
            jda.getPresence().setActivity(Activity.listening("version: " + botVersion));
        }
    }
}
