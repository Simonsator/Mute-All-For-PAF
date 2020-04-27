package de.simonsator.paf.extensions.muteall.spigot;

import de.simonsator.paf.extensions.muteall.MACommand;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class MASpigotCommand extends MACommand implements Listener {
	public MASpigotCommand(String[] pCommands, int pPriority, String pHelp, ConfigurationCreator pConfig) {
		super(pCommands, pPriority, pHelp, pConfig);
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent pEvent) {
		onLeave(pEvent.getPlayer().getUniqueId());
	}
}
