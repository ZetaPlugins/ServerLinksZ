package com.zetaplugins.serverlinksz;

import com.zetaplugins.serverlinksz.util.CommandManager;
import com.zetaplugins.serverlinksz.util.EventManager;
import com.zetaplugins.serverlinksz.util.LanguageManager;
import com.zetaplugins.serverlinksz.util.LinkManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.zetaplugins.serverlinksz.util.bStats.CustomCharts;
import com.zetaplugins.serverlinksz.util.bStats.Metrics;

import java.io.File;

public final class ServerLinksZ extends JavaPlugin {
    private CommandManager commandManager;
    private LanguageManager languageManager;
    private EventManager eventManager;
    private LinkManager linkManager;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        languageManager = new LanguageManager(this);

        linkManager = new LinkManager(this);
        linkManager.updateLinks();

        eventManager = new EventManager(this);
        eventManager.registerListeners();
        commandManager = new CommandManager(this);
        commandManager.registerCommands();

        initializeBStats();

        getLogger().info("ServerLinksZ has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ServerLinksZ has been disabled!");
    }

    public static ServerLinksZ getInstance() {
        return JavaPlugin.getPlugin(ServerLinksZ.class);
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public LinkManager getLinkManager() {
        return linkManager;
    }

    private void initializeBStats() {
        final int pluginId = 22795;
        Metrics metrics = new Metrics(this, pluginId);

        metrics.addCustomChart(CustomCharts.getLanguageChart(this));
        metrics.addCustomChart(CustomCharts.getLinksChart(this));
    }

    public File getPluginFile() {
        return this.getFile();
    }
}
