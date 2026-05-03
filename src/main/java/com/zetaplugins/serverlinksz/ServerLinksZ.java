package com.zetaplugins.serverlinksz;

import com.zetaplugins.serverlinksz.util.CommandManager;
import com.zetaplugins.serverlinksz.util.EventManager;
import com.zetaplugins.serverlinksz.util.LanguageManager;
import com.zetaplugins.serverlinksz.util.LinkManager;
import dev.faststats.bukkit.BukkitMetrics;
import dev.faststats.core.ErrorTracker;
import dev.faststats.core.data.Metric;
import org.bukkit.plugin.java.JavaPlugin;
import com.zetaplugins.serverlinksz.util.bStats.CustomCharts;
import com.zetaplugins.serverlinksz.util.bStats.Metrics;

import java.io.File;

public final class ServerLinksZ extends JavaPlugin {
    private static final int BSTATS_PLUGIN_ID = 22795;
    private static final String FASTSTATS_TOKEN = "e74ea63e83b6c70ddbd45a8d609f1a03";
    public static final ErrorTracker FASTSTATS_ERROR_TRACKER = ErrorTracker.contextAware();

    private dev.faststats.core.Metrics faststatsMetrics;

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
        initFastStats();

        getLogger().info("ServerLinksZ has been enabled!");
    }

    @Override
    public void onDisable() {
        if (faststatsMetrics != null) faststatsMetrics.shutdown();
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
        Metrics metrics = new Metrics(this, BSTATS_PLUGIN_ID);

        metrics.addCustomChart(CustomCharts.getLanguageChart(this));
        metrics.addCustomChart(CustomCharts.getLinksChart(this));
    }

    private void initFastStats() {
        this.faststatsMetrics = BukkitMetrics.factory()
                .token(FASTSTATS_TOKEN)
                .errorTracker(FASTSTATS_ERROR_TRACKER)
                .addMetric(Metric.string("language", () -> getConfig().getString("lang")))
                .create(this);

        this.faststatsMetrics.ready();

        getLogger().info("FastStats metrics initialized.");
    }

    public File getPluginFile() {
        return this.getFile();
    }
}
