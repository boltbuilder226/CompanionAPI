package com;


import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Message {

	private CommandSender sender;

	public Message(CommandSender sender) {
		this.sender = sender;
	}

	public void send(String message, boolean translate, char key) {
		if (translate) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes(key, message));
		} else {
			sender.sendMessage(message);
		}
	}

	public void send(String message) {
		send(message, false, '0');
	}

}
