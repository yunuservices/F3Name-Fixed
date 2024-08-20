package ua.coolboy.f3name.core;

public interface LoggerUtil {
    void info(Object obj);

    void error(Object obj);

    void error(Object obj, Throwable t);

    void printStacktrace(Exception ex);

    void setColoredConsole(boolean colored);
}
