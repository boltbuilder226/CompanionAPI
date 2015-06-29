package com.companion.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CompanionAPI extends JavaPlugin {
	
	public static CompanionAPI instance;
	
	@Override
	public void onEnable() {
		instance = this;
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	public static CompanionAPI getInstance() {
		return instance;
	}
	
	public static void debug(String message) {
	    Bukkit.broadcastMessage(message);
	}

}
