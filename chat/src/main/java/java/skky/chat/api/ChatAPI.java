package java.skky.chat.api;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

public class ChatAPI {

	@Getter
	@Setter
	private ChatState chatState = ChatState.ACTIVATED;
	@Getter
	private static final ChatAPI instance = new ChatAPI();

	public enum ChatState {
		ACTIVATED, DISABLED;
	}

	public static void clear() {
		Bukkit.broadcastMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
	}
}
