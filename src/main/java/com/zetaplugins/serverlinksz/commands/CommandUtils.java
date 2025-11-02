package com.zetaplugins.serverlinksz.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import com.zetaplugins.serverlinksz.util.MessageUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandUtils {
    /**
     * Throws a usage error message to the sender.
     * @param sender Command sender
     * @param usage Usage string
     */
    public static void throwUsageError(CommandSender sender, String usage) {
        Component msg = MessageUtils.getAndFormatMsg(false, "usageError", "&cUsage: %usage%", new MessageUtils.Replaceable("%usage%", usage));
        sender.sendMessage(msg);
    }

    /**
     * Throws a permission error message to the sender.
     * @param sender Command sender
     */
    public static void throwPermissionError(CommandSender sender) {
        Component msg = MessageUtils.getAndFormatMsg(false, "noPermissionError", "&cYou don't have permission to use this!");
        sender.sendMessage(msg);
    }

    /**
     * Gets a list of options that start with the input
     * @param options The list of options
     * @param input The input
     * @return A list of options that start with the input
     */
    public static List<String> getDisplayOptions(List<String> options, String input) {
        return options.stream()
                .filter(option -> startsWithIgnoreCase(option, input))
                .collect(Collectors.toList());
    }

    /**
     * Gets a list of options that start with the input
     * @param options The list of options
     * @param input The input
     * @return A list of options that start with the input
     */
    public static List<String> getDisplayOptions(Set<String> options, String input) {
        return options.stream()
                .filter(option -> startsWithIgnoreCase(option, input))
                .collect(Collectors.toList());
    }

    /**
     * Checks if a string starts with another string (case-insensitive)
     * @param str The string
     * @param prefix The prefix
     * @return True if the string starts with the prefix, false otherwise
     */
    private static boolean startsWithIgnoreCase(String str, String prefix) {
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
    }
}
