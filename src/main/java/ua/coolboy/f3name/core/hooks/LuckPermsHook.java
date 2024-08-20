package ua.coolboy.f3name.core.hooks;

import ua.coolboy.f3name.core.F3Group;
import ua.coolboy.f3name.core.F3Name;

import java.util.List;
import java.util.logging.Logger;

public abstract class LuckPermsHook {

    public static ILuckPermsHook get(List<F3Group> groups) {
        try {
            Class.forName("net.luckperms.api.LuckPerms");
            return new LP5(groups);
        } catch (ClassNotFoundException ignored) {
        }

        try {
            Class.forName("me.lucko.luckperms.LuckPerms");
            Logger.getLogger(F3Name.PREFIX).severe(F3Name.PREFIX + "Found old LuckPerms 4.0. Groups would not work!");
        } catch (ClassNotFoundException ignored) {
        }
        return null;
    }
}
