package com.zetaplugins.serverlinksz.commands.maincommand;

import com.zetaplugins.serverlinksz.commands.CommandUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.zetaplugins.serverlinksz.ServerLinksZ;

import java.util.ArrayList;
import java.util.List;

public class MainTabCompleter implements TabCompleter {
    private final ServerLinksZ plugin;

    public MainTabCompleter(ServerLinksZ plugin) {
        this.plugin = plugin;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        return switch (args.length) {
            case 1 -> getFirstArgOptions(sender, args);
            case 2 -> getSecondArgOptions(args);
            case 3 -> getThirdArgOptions(args);
            case 4 -> getFourthArgOptions(args);
            case 5 -> getFifthArgOptions(args);
            case 6 -> getSixthArgOptions(args);
            default -> List.of();
        };
    }

    public List<String> getFirstArgOptions(CommandSender sender, String[] args) {
        List<String> availableOptions = new ArrayList<>();

        if ("help".startsWith(args[0].toLowerCase()) || args[0].equalsIgnoreCase("help")) {
            availableOptions.add("help");
        }

        if (sender.hasPermission("serverlinksz.admin")) {
            List<String> adminCommands = List.of("add", "remove", "reload");
            for (String adminCommand : adminCommands) {
                if (adminCommand.startsWith(args[0].toLowerCase()) || args[0].equalsIgnoreCase(adminCommand)) {
                    availableOptions.add(adminCommand);
                }
            }
        }

        return availableOptions;
    }

    public List<String> getSecondArgOptions(String[] args) {
        if (args[0].equals("add")) {
            return List.of("<id>");
        }

        if (args[0].equals("remove")) {
            List<String> linkKeys = plugin.getLinkManager().getLinkKeys().stream().toList();
            List<String> suggestions = new ArrayList<>();
            for (String linkKey : linkKeys) {
                if (linkKey.startsWith(args[1].toLowerCase()) || args[1].equalsIgnoreCase(linkKey)) {
                    suggestions.add(linkKey);
                }
            }
            return suggestions;
        }

        return List.of();
    }

    public List<String> getThirdArgOptions(String[] args) {
        if (args[0].equals("add")) {
            return List.of("<name>");
        }

        return List.of();
    }

    public List<String> getFourthArgOptions(String[] args) {
        if (args[0].equals("add")) {
            return List.of("<url>");
        }

        return List.of();
    }

    public List<String> getFifthArgOptions(String[] args) {
        if (args[0].equals("add")) {
            return List.of("true", "false");
        }

        return List.of();
    }

    public List<String> getSixthArgOptions(String[] args) {
        if (args[0].equals("add")) {
            return CommandUtils.getDisplayOptions(List.of(
                    "CUSTOM",
                    "ANNOUNCEMENTS",
                    "COMMUNITY",
                    "COMMUNITY_GUIDELINES",
                    "FEEDBACK",
                    "FORUMS",
                    "NEWS",
                    "REPORT_BUG",
                    "STATUS",
                    "SUPPORT",
                    "WEBSITE"
            ), args[5]);
        }

        return List.of();
    }
}
