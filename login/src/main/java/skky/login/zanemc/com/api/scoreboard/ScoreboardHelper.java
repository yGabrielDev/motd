package lobby.zane.com.api.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class ScoreboardHelper {

	private Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
	private Objective obj;

	public ScoreboardHelper(Player player, String name) {
		this.obj = scoreboard.registerNewObjective("score", "dummy");
		this.obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		this.obj.setDisplayName(name);

		for (int t = 1; t < 16; ++t) {
			scoreboard.registerNewTeam("line-" + t);
		}
	}

	public Scoreboard getSoreboard() {
		return this.scoreboard;
	}

	public String convert(int line) {
		if (line >= 1 && line <= 9) {
			return "§" + line;
		} else if (line == 10) {
			return "§a";
		} else if (line == 11) {
			return "§b";
		} else if (line == 12) {
			return "§c";
		} else if (line == 13) {
			return "§d";
		} else if (line == 14) {
			return "§e";
		} else {
			return line == 14 ? "§e" : "§0";
		}
	}

	@SuppressWarnings("deprecation")
	public void add(String prefix, String suffix, int line) {
		Team t = scoreboard.getTeam("line-" + line);
		FakeOfflinePlayer of = new FakeOfflinePlayer(convert(line));
		this.obj.getScore(of).setScore(line);
		t.addPlayer(of);
		if (prefix.length() > 16) {
			prefix = prefix.substring(0, 16);
		}

		if (suffix.length() > 16) {
			suffix = suffix.substring(0, 16);
		}

		t.setPrefix(prefix);
		t.setSuffix(suffix);
	}

	public void update(String prefix, String suffix, int line) {
		Team t = scoreboard.getTeam("line-" + line);
		if (prefix.length() > 16) {
			prefix = prefix.substring(0, 16);
		}

		if (suffix.length() > 16) {
			suffix = suffix.substring(0, 16);
		}
		t.setPrefix(prefix);
		t.setSuffix(suffix);
	}

}