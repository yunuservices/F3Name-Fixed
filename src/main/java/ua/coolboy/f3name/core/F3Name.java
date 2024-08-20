package ua.coolboy.f3name.core;

import java.util.Collection;
import java.util.UUID;

public interface F3Name {

    /**
     * Logger prefix
     */
    String PREFIX = "§3[F3Name] §r";
    /**
     * Resource ID for updationg
     */
    int RESOURCE_ID = 58997;
    /**
     * Minecraft brand channel
     */
    String BRAND_CHANNEL = "minecraft:brand";
    /**
     * Plugin channel
     */
    String PLUGIN_CHANNEL = "bukkit:f3name";

    /**
     * Gets plugin {@link LoggerUtil}
     *
     * @return LoggerUtil for logging on behalf of the plugin
     */
    LoggerUtil getLoggerUtil();

    /**
     * Gets {@link ServerType}
     *
     * @return ServerType to understand on what platform plugin is loaded
     */
    ServerType getServerType();

    /**
     * Gets plugin {@link ConfigParser}
     *
     * @return ConfigParser that used to parse config
     */
    ConfigParser getConfigParser();

    /**
     * Gets {@link F3Runnable} list
     *
     * @return List of F3Runnable, each runnable serves one group
     */
    Collection<? extends F3Runnable> getRunnables();

    /**
     * Replaces placeholders and sends server brand to player
     *
     * @param uuid  player UUID
     * @param brand string to send
     */
    void send(UUID uuid, String brand);

    /**
     * Sends server brand to player without editing text
     *
     * @param uuid  player UUID
     * @param brand string to send
     */
    void sendRaw(UUID uuid, String brand);

    enum ServerType {
        /**
         * Represents Bukkit server
         */
        BUKKIT,
        /**
         * Represents BungeeCord server
         */
        BUNGEE;
    }
}
