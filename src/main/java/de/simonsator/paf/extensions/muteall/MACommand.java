package de.simonsator.paf.extensions.muteall;

import de.simonsator.partyandfriends.api.friends.abstractcommands.FriendSubCommand;
import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayerManager;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.util.HashSet;
import java.util.UUID;


public abstract class MACommand extends FriendSubCommand {
	private final ConfigurationCreator CONFIG;
	private HashSet<UUID> DEACTIVATE = new HashSet<>();

	protected MACommand(String[] pCommands, int pPriority, String pHelp, ConfigurationCreator pConfig) {
		super(pCommands, pPriority, pHelp);
		CONFIG = pConfig;
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		if (DEACTIVATE.contains(pPlayer.getUniqueId())) {
			DEACTIVATE.remove(pPlayer.getUniqueId());
			pPlayer.setSetting(2, 0);
			pPlayer.sendMessage(PREFIX + CONFIG.getString("Messages.Disabled"));
			return;
		}
		if (pPlayer.getSettingsWorth(2) == 1) {
			pPlayer.sendMessage(PREFIX + CONFIG.getString("Messages.Permanently"));
			return;
		}
		DEACTIVATE.add(pPlayer.getUniqueId());
		pPlayer.setSetting(2, 1);
		pPlayer.sendMessage(PREFIX + CONFIG.getString("Messages.Activated"));
	}

	protected void onLeave(UUID pPlayerUUID) {
		if (!DEACTIVATE.contains(pPlayerUUID))
			return;
		PAFPlayer player = PAFPlayerManager.getInstance().getPlayer(pPlayerUUID);
		if (player.getSettingsWorth(2) == 1)
			player.setSetting(2, 0);
		DEACTIVATE.remove(pPlayerUUID);
	}

}