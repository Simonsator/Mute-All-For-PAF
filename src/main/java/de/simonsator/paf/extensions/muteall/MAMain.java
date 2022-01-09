package de.simonsator.paf.extensions.muteall;

import de.simonsator.paf.extensions.muteall.bungee.MABungeeCommandObjectCreator;
import de.simonsator.paf.extensions.muteall.spigot.MASpigotCommandObjectCreator;
import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;


public class MAMain extends PAFExtension {
	public void onEnable() {
		try {
			ConfigurationCreator config = new MAConfig(new File(getConfigFolder(), "config.yml"), this);
			MACommand command;
			switch (getAdapter().getServerSoftware()) {
				case BUNGEECORD:
					command = MABungeeCommandObjectCreator.createNewMACommandObject(config.getStringList("Names").toArray(new String[0]), config.getInt("Priority"), config.getString("Messages.Help"), config);
					break;
				case SPIGOT:
					command = MASpigotCommandObjectCreator.createNewMACommandObject(config.getStringList("Names").toArray(new String[0]), config.getInt("Priority"), config.getString("Messages.Help"), config);
					break;
				default:
					System.out.println("This extension does not support yet " + getAdapter().getServerSoftware().toString() + ". If you believe this to be an error please contact the author of the extension.");
					return;
			}
			getAdapter().registerListener(command, this);
			Friends.getInstance().addCommand(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}