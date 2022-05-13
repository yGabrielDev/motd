package lobby.zane.com.room;

import lobby.zane.com.Main;
import lobby.zane.com.api.scoreboard.ScoreboardHelper;
import engine.zane.com.base.Core;
import engine.zane.com.bukkit.account.BukkitPlayer;
import lobby.zane.com.api.onlinecount.ServerConnect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

import java.util.HashMap;

public class RoomManager {

	private static HashMap<Player, ScoreboardHelper> scoreboards = new HashMap<>();

	public static HashMap<Player, ScoreboardHelper> getScoreboards() {
		return scoreboards;
	}

	public static String lobby(Player player) {
		if (Bukkit.getServer().getPort() == ServerConnect.LOBBY1.getPort()) {
			return "#1";
		}
		if (Bukkit.getServer().getPort() == ServerConnect.LOBBY2.getPort()) {
			return "#2";
		}
		if (Bukkit.getServer().getPort() == ServerConnect.LOBBY3.getPort()) {
			return "#3";
		}
		if (Bukkit.getServer().getPort() == ServerConnect.LOBBY4.getPort()) {
			return "#4";
		}
		return null;
	}

	public static void handle(Player player) {
		ScoreboardHelper scoreboard = new ScoreboardHelper(player, "§5§lZANE");
        BukkitPlayer bukkitPlayer = (BukkitPlayer) Core.getAccountPlayer().getZanePlayer(player.getUniqueId());

		    scoreboard.add("", "", 7);
			scoreboard.add("Rank:"," " + bukkitPlayer.getGroup().getTagToUse().getName(), 6);
            scoreboard.add("", "", 5);
		    scoreboard.add("Lobby:", " §7" + lobby(player), 4);
            scoreboard.add("Players:", " §a" + Bukkit.getOnlinePlayers().size(), 3);
            scoreboard.add("", "", 2);
            scoreboard.add("§ewww.zanemc", "§e.com", 1);

		player.setScoreboard(scoreboard.getSoreboard());
		scoreboards.put(player, scoreboard);

		new BukkitRunnable() {
			@Override
			public void run() {
				if (!player.isOnline()) {
					cancel();
					return;
				}
				scoreboard.getSoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§5§lZANE");
				scoreboard.update("Rank:"," " + bukkitPlayer.getGroup().getTagToUse().getName(), 6);
				scoreboard.update("Players:", " §a" + Bukkit.getOnlinePlayers().size(), 3);
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 0, 3L);
	}
}