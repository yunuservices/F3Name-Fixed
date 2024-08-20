package ua.coolboy.f3name.core;

import java.util.List;

public interface F3Runnable extends Runnable {

    F3Group getGroup();

    String getCurrentString();

    List<String> getStrings();

}
