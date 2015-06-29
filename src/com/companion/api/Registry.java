package com.companion.api;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Registry implements Listener {

	
	/**
	 * Registers a single listener for the given plugin
	 * @param plugin Plugin for registration
	 * @param listener Listener to register
	 */
	public static void registerListener(JavaPlugin plugin, Listener listener) {

		plugin.getServer().getPluginManager().registerEvents(listener, plugin);

	}

	/**
	 * Register multiple listeners for the given plugin
	 * @param plugin Plugin for registration
	 * @param listener Listeners to register
	 */
	public static void registerListener(JavaPlugin plugin, Listener... listener) {

		for (Listener l : listener) {
			plugin.getServer().getPluginManager().registerEvents(l, plugin);
		}

	}

	
	/**
	 * Register a command
	 * @param plugin Plugin for registration
	 * @param command String name of command
	 * @param executor CommandExecutor to handle the command
	 */
	public static void registerCommand(JavaPlugin plugin, String command,
			CommandExecutor executor) {

		plugin.getCommand(command).setExecutor(executor);

	}

}
