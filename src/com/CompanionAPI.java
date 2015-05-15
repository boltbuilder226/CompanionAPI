package com;

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

}
