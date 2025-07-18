package com.zetaplugins.serverlinksz.util;

import org.bukkit.event.Listener;
import com.zetaplugins.serverlinksz.ServerLinksZ;

public class EventManager {
    private final ServerLinksZ plugin;

    public EventManager(ServerLinksZ plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers all listeners
     */
    public void registerListeners() {
    }

    /**
     * Registers a listener
     *
     * @param listener The listener to register
     */
    private void registerListener(Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
