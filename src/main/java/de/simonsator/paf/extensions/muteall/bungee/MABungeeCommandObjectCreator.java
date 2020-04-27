package de.simonsator.paf.extensions.muteall.bungee;

import de.simonsator.paf.extensions.muteall.MACommand;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

public class MABungeeCommandObjectCreator {

	public static MACommand createNewMACommandObject(String[] names, int priority, String string, ConfigurationCreator config) {
		return new MABungeeCommand(names, priority, string, config);
	}
}
