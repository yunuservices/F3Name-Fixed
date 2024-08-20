package ua.coolboy.f3name.bukkit;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import ua.coolboy.f3name.core.ConfigParser;
import ua.coolboy.f3name.core.F3Group;

public class BukkitConfigParser implements ConfigParser {

    private final boolean coloredConsole, bungeecord, checkForUpdates, autoupdate;

    private final List<F3Group> groups;

    public BukkitConfigParser(FileConfiguration config) {
        coloredConsole = config.getBoolean("colored-console", true);
        bungeecord = config.getBoolean("bungeecord-as-primary", false);
        checkForUpdates = config.getBoolean("check-for-updates", true);
        autoupdate = config.getBoolean("auto-update", true);
        
        groups = new ArrayList<>();
        ConfigurationSection groupsSection = config.getConfigurationSection("groups");
        if (groupsSection == null) return;
        for (String key : groupsSection.getKeys(false)) {
            ConfigurationSection section = config.getConfigurationSection("groups." + key);
            if (section == null) continue;
            List<String> messages = section.getStringList("f3names");
            int updateTime = section.getInt("update-time", 200);
            boolean shuffle = section.getBoolean("shuffle", false);
            groups.add(new F3Group(key, messages, updateTime, shuffle));
        }
    }

    @Override
    public boolean isColoredConsole() {
        return coloredConsole;
    }
    
    @Override
    public boolean checkForUpdates() {
        return checkForUpdates;
    }
    
    public boolean isAutoUpdate() {
        return autoupdate;
    }
    
    public boolean isBungeeCord() {
        return bungeecord;
    }

    @Override
    public F3Group getF3Group(String name) {
        for (F3Group gds : groups) {
            if (gds.getGroupName().equals(name)) {
                return gds;
            }
        }
        return null;
    }

    @Override
    public List<F3Group> getF3GroupList() {
        return groups;
    }

}
