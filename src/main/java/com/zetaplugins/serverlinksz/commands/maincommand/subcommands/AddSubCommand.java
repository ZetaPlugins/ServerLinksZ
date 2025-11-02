package com.zetaplugins.serverlinksz.commands.maincommand.subcommands;

import org.bukkit.command.CommandSender;
import com.zetaplugins.serverlinksz.ServerLinksZ;
import com.zetaplugins.serverlinksz.commands.CommandUtils;
import com.zetaplugins.serverlinksz.commands.SubCommand;
import com.zetaplugins.serverlinksz.util.MessageUtils;

import java.net.URI;
import java.net.URISyntaxException;

public class AddSubCommand implements SubCommand {
    private final ServerLinksZ plugin;

    public AddSubCommand(ServerLinksZ plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!hasPermission(sender)) {
            CommandUtils.throwPermissionError(sender);
            return false;
        }

        if (args.length < 4) {
            CommandUtils.throwUsageError(sender, getUsage());
            return false;
        }

        boolean showHints = plugin.getConfig().getBoolean("hints");

        String id = args[1];
        String name = args[2];
        String url = args[3];
        boolean allowCommand = args.length > 4 && args[4].equals("true");
        String type = args.length > 5 ? args[5] : "CUSTOM";

        if (!isValidURL(url)) {
            sender.sendMessage(MessageUtils.getAndFormatMsg(false, "invalidUrlError", "&cThe URL is invalid!"));
            return false;
        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            sender.sendMessage(MessageUtils.getAndFormatMsg(false, "urlProtocolError", "&cThe URL must start with 'http://' or 'https://'!"));
            return false;
        }

        plugin.getLinkManager().addLink(id, name, url, allowCommand, type);
        sender.sendMessage(MessageUtils.getAndFormatMsg(true, "addLinkMsg", "&7Successfully added link with id %id%!", new MessageUtils.Replaceable("%id%", id)));
        if (showHints) {
            sender.sendMessage(MessageUtils.getAndFormatMsg(false, "rejoinHint", "<#E9D502>⚠ To update the Serverlinks, please rejoin the server!"));
            sender.sendMessage(MessageUtils.getAndFormatMsg(false, "moreConfigOptionsHint", "<#E9D502>⚠ For more configuration options, please refer to the config.yml file!"));
        }

        return true;
    }

    @Override
    public String getUsage() {
        return "/serverlinksz add <id> <name> <url> <allowCommand> <type>";
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("serverlinksz.admin");
    }

    private boolean isValidURL(String url) {
        try {
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
