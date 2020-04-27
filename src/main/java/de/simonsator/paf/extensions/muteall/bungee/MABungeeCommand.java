package de.simonsator.paf.extensions.muteall.bungee;

import de.simonsator.paf.extensions.muteall.MACommand;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MABungeeCommand extends MACommand implements Listener {
	public MABungeeCommand(String[] pCommands, int pPriority, String pHelp, ConfigurationCreator pConfig) {
		super(pCommands, pPriority, pHelp, pConfig);
	}

	@EventHandler
	public void onLeave(PlayerDisconnectEvent pEvent) {
		onLeave(pEvent.getPlayer().getUniqueId());
	}
}
