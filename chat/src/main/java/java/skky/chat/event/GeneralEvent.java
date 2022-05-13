package java.skky.chat.event;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.skky.chat.Main;
import java.skky.chat.api.ChatAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        Player player = asyncPlayerChatEvent.getPlayer();
        if (ChatAPI.getInstance().getChatState() == ChatAPI.ChatState.DISABLED) {
            player.sendMessage("§cChat is off.");
            return;
        }
        String msg = asyncPlayerChatEvent.getMessage().replace("&", "§");

        TextComponent text2 = new TextComponent(msg.replace("&", "§"));
        List<String> url = extractUrls(msg);
        if (url.size() > 0) {
            text2.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url.get(0)));
        }

        asyncPlayerChatEvent.setFormat("§7" + player.getDisplayName() + " §7» §f" + msg);
    }

    private Pattern urlFinderPattern = Pattern.compile("((https?):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)",
			Pattern.CASE_INSENSITIVE);

	public List<String> extractUrls(String text) {
		List<String> containedUrls = new ArrayList<String>();
		Matcher urlMatcher = urlFinderPattern.matcher(text);
		while (urlMatcher.find()) {
			containedUrls.add(urlMatcher.group(1));
		}
		return containedUrls;
	}
}
