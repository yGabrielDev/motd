package lobby.zane.com.api.scoreboard;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class FakeOfflinePlayer implements OfflinePlayer {
	private String name;
	private UUID id;

	public void setName(String name) {
		this.name = name;
	}

	public FakeOfflinePlayer(String name) {
		this.name = name;
		this.id = UUID.nameUUIDFromBytes(name.getBytes());
	}

	public FakeOfflinePlayer(String name, UUID id) {
		this(name);
		this.setId(id);
	}

	public boolean isOp() {
		return false;
	}

	public void setOp(boolean arg0) {
	}

	public Map<String, Object> serialize() {
		return null;
	}

	public Location getBedSpawnLocation() {
		return null;
	}

	public long getFirstPlayed() {
		return 0L;
	}

	public long getLastPlayed() {
		return 0L;
	}

	public String getName() {
		return this.name;
	}

	public Player getPlayer() {
		Player player = Bukkit.getPlayer(this.id);
		return player == null ? Bukkit.getPlayer(this.name) : player;
	}

	public UUID getUniqueId() {
		return this.id;
	}

	public boolean hasPlayedBefore() {
		return true;
	}

	public boolean isBanned() {
		return false;
	}

	public boolean isOnline() {
		return false;
	}

	public boolean isWhitelisted() {
		return false;
	}

	public void setBanned(boolean arg0) {
	}

	public void setWhitelisted(boolean arg0) {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
