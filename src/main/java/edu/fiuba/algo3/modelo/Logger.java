package edu.fiuba.algo3.modelo;

public class Logger {
    private static Logger instance = null;

    private Logger() {
    }

    public Logger(Logger logger) {
        instance = logger;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        System.out.println(message);
    }

    public void error(String message) {
        System.out.println(message);
    }
    
}
