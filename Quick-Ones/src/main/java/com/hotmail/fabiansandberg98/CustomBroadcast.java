/*
 * 
 * Skype: neeh98
 * Bukkit: AdobeGFX
 * GitHub: AdobeGFX
 * YouTube: imTrelyx
 * Mail: fabiansandberg98@hotmail.com
 * 
 */
package com.hotmail.fabiansandberg98;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomBroadcast extends JavaPlugin {

	public void onDisable() {
		System.out.println("Plugin disabled.");
	}

	public void onEnable() {
		System.out.println("Plugin enabled.");
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		if (cmd.equalsIgnoreCase("broadcast")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("For players only.. k.");

			} else {
				Player p = (Player) sender;
				if (!p.hasPermission("broadcast.broadcast")) {
					p.sendMessage(ChatColor.DARK_RED
							+ "You do not have access to that command!");

				} else if (args.length == 0) {
					p.sendMessage(ChatColor.DARK_RED + "You need to type in a message!");
				} else {
					getServer().broadcastMessage(ChatColor.GREEN + "[Broadcast] " + ChatColor.WHITE + p.getName() + ": " + message(args));
				}

			}
		}
		return false;
	}
	public String message(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
		builder.append(args[i]);
		builder.append(" ");
		}
		return builder.toString().trim();
	}
}
