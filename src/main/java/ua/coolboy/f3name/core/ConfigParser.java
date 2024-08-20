package ua.coolboy.f3name.core;

import java.util.List;

public interface ConfigParser {

    boolean isColoredConsole();
    
    boolean checkForUpdates();

    F3Group getF3Group(String name);

    List<F3Group> getF3GroupList();
    
}
