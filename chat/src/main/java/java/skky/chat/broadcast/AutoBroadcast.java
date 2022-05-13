package java.skky.chat.broadcast;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import java.skky.chat.Main;

public class AutoBroadcast {

    private static Configuration c = Main.getInstance().getConfig();
    private static final String PREFIX = c.getString("broadcast.title").replace("&", "§");

    private static int timer = 0;
    private static int taskID;

    public static void enable() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (timer == 0) Bukkit.broadcastMessage(PREFIX + c.getString("broadcast.messages.one").replace("&", "§"));
                if (timer == 1) Bukkit.broadcastMessage(PREFIX + c.getString("broadcast.messages.two").replace("&", "§"));
                if (timer == 2) Bukkit.broadcastMessage(PREFIX + c.getString("broadcast.messages.three").replace("&", "§"));
                if (timer == 3) Bukkit.broadcastMessage(PREFIX + c.getString("broadcast.messages.four").replace("&", "§"));
                if (timer == 4) Bukkit.broadcastMessage(PREFIX + c.getString("broadcast.messages.five").replace("&", "§"));
                if (timer == 5) timer = 0;
                timer++;
            }
        }, 0L, 1000L);
    }

    public static void disable() {
        Bukkit.getScheduler().cancelTask(taskID);
    }
}