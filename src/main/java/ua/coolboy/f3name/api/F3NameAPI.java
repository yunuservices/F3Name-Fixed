package ua.coolboy.f3name.api;

import org.jetbrains.annotations.ApiStatus;
import ua.coolboy.f3name.core.F3Name;

/**
 * API for F3Name
 * <br>
 * Use {@link #getInstance()}
 *
 * @author Cool_boy
 */
public class F3NameAPI {

    private static F3Name plugin;

    @ApiStatus.Internal
    public static void setInstance(F3Name plugin) {
        if (F3NameAPI.plugin != null) throw new IllegalAccessError("Plugin already set!");
        F3NameAPI.plugin = plugin;
    }

    /**
     * Gets plugin API
     *
     * @return Instance of plugin main class
     */
    @SuppressWarnings("unused")
    public static F3Name getInstance() {
        return plugin;
    }

}
