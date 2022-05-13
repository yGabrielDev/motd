package java.skky.chat;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.skky.chat.broadcast.AutoBroadcast;
import java.skky.chat.command.ChatCommand;
import java.skky.chat.event.GeneralEvent;

@Getter
public class Main extends JavaPlugin {
    @Setter
    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ChatCommand(), this);
        Bukkit.getPluginManager().registerEvents(new GeneralEvent(), this);
        Bukkit.getPluginCommand("chat").setExecutor(new ChatCommand());
        AutoBroadcast.enable();

        Bukkit.getConsoleSender().sendMessage("§e§lCHAT§a Plugin started successfully!");
    }
}
