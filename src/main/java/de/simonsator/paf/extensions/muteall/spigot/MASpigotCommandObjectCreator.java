package de.simonsator.paf.extensions.muteall.spigot;

import de.simonsator.paf.extensions.muteall.MACommand;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

public class MASpigotCommandObjectCreator {
	public static MACommand createNewMACommandObject(String[] names, int priority, String string, ConfigurationCreator config) {
		return new MASpigotCommand(names, priority, string, config);
	}
}
