package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger logger = LoggerFactory.getLogger("TestLogger");
    // Buffer per accumulare log
    private static ThreadLocal<StringBuilder> logs = ThreadLocal.withInitial(StringBuilder::new);

    public static void info(String message) {
        logger.info(message);
        System.out.println("[INFO] " + message);
        logs.get().append(getCurrentTime()).append(" [INFO] ").append(message).append("\n");
    }

    public static void debug(String message) {
        logger.debug(message);
        System.out.println("[DEBUG] " + message);
        logs.get().append(getCurrentTime()).append(" [DEBUG] ").append(message).append("\n");
    }

    public static void warn(String message) {
        logger.warn(message);
        System.out.println("[WARN] " + message);
        logs.get().append(getCurrentTime()).append(" [WARN] ").append(message).append("\n");
    }

    public static void error(String message) {
        logger.error(message);
        System.err.println("[ERROR] " + message);
        logs.get().append(getCurrentTime()).append(" [ERROR] ").append(message).append("\n");
    }

    public static synchronized void printLogs() {
        System.out.println("=================\nALL COMBINED LOGS\n=================");
        System.out.println(logs.get().toString());
        // Pulisci il buffer e rimuovi la ThreadLocal
        logs.get().setLength(0);
        logs.remove();
    }

    private static String getCurrentTime() {
        return java.time.LocalDateTime.now().toString().replace("T", " ");
    }
}
