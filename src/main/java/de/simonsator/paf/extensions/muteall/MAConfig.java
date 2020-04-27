package de.simonsator.paf.extensions.muteall;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;


public class MAConfig extends ConfigurationCreator {
	protected MAConfig(File file, PAFExtension pPlugin) throws IOException {
		super(file, pPlugin);
		readFile();
		loadDefaultValues();
		saveFile();
		process();
	}

	private void loadDefaultValues() {
		set("Names", "muteall", "ma");
		set("Priority", 1000);
		set("Messages.Activated", " &7From now on you won't receive messages from your friends via /friend msg until you rejoin the server or use this command again.");
		set("Messages.Disabled", " &7From now on your friends can send you messages via /friend msg again.");
		set("Messages.Permanently", " &7You have already activated the permanent mute of your friends. To change this use &5/friend settings messages &7or change it in the GUI.");
		set("Messages.Help", "&8/&5friend muteall &8- &7De/Activates the mute of all friends");
	}
}
