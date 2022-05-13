package java.skky.chat.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.skky.chat.Main;
import java.skky.chat.api.ChatAPI;

public class ChatCommand implements CommandExecutor, Listener {
    private static int time = 5;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Please login to the server to run this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("chat.permission")) {
            player.sendMessage("§cYou didn't have permission.");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage("§eTo make changes to the chat, you must use §6'/chat (activate, deactivate, clear) [brazil, usa]'§e.");
        } else if (args[0].equalsIgnoreCase("activate")) {
            if (args[1] == null) {
                player.sendMessage("§cPlease fill in all data.");
                return true;
            }

            if (args[1].equalsIgnoreCase("brazil")) {

                if (!(ChatAPI.getInstance().getChatState() == ChatAPI.ChatState.DISABLED)) {
                    player.sendMessage("§cO bate-papo local já está ativado!");
                    return true;
                }

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (time == 5) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §aativado§e em 5 segundos!");
                        }

                        if (time == 4) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §aativado§e em 4 segundos!");
                        }

                        if (time == 3) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §aativado§e em 3 segundos!");
                        }

                        if (time == 2) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §aativado§e em 2 segundos!");
                        }

                        if (time == 1) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §aativado§e em 1 segundo!");
                        }

                        if (time == 0) {
                            ChatAPI.getInstance().setChatState(ChatAPI.ChatState.ACTIVATED);
                            Bukkit.broadcastMessage(" ");
                            Bukkit.broadcastMessage("§aO bate-papo foi ativado!");
                            Bukkit.broadcastMessage(" ");
                            cancel();
                        }
                    }
                }.runTaskTimer(Main.getInstance(), 0, 20);
            } else if (args[1].equalsIgnoreCase("usa")) {

                if (!(ChatAPI.getInstance().getChatState() == ChatAPI.ChatState.DISABLED)) {
                    player.sendMessage("§cLocal chat is now enabled!");
                    return true;
                }

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (time == 5) {
                            Bukkit.broadcastMessage("§eLocal chat will be §aenabled§e on 5 seconds!");
                        }

                        if (time == 4) {
                            Bukkit.broadcastMessage("§eLocal chat will be §aenabled§e on 4 seconds!");
                        }

                        if (time == 3) {
                            Bukkit.broadcastMessage("§eLocal chat will be §aenabled§e on 3 seconds!");
                        }

                        if (time == 2) {
                            Bukkit.broadcastMessage("§eLocal chat will be §aenabled§e on 2 seconds!");
                        }

                        if (time == 1) {
                            Bukkit.broadcastMessage("§eLocal chat will be §aenabled§e on 1 second!");
                        }

                        if (time == 0) {
                            ChatAPI.getInstance().setChatState(ChatAPI.ChatState.ACTIVATED);
                            Bukkit.broadcastMessage(" ");
                            Bukkit.broadcastMessage("§aLocal chat has been activated!");
                            Bukkit.broadcastMessage(" ");
                            cancel();
                        }
                    }
                }.runTaskTimer(Main.getInstance(), 0, 20);
            }

        } else if (args[0].equalsIgnoreCase("deactivate")) {
            if (args[1] == null) {
                player.sendMessage("§cPlease fill in all data.");
                return true;
            }

            if (args[1].equalsIgnoreCase("brazil")) {

                if (!(ChatAPI.getInstance().getChatState() == ChatAPI.ChatState.ACTIVATED)) {
                    player.sendMessage("§cO bate-papo local já está desativado!");
                    return true;
                }

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (time == 5) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §cdesativado§e em 5 segundos!");
                        }

                        if (time == 4) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §cdesativado§e em 4 segundos!");
                        }

                        if (time == 3) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §cdesativado§e em 3 segundos!");
                        }

                        if (time == 2) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §cdesativado§e em 2 segundos!");
                        }

                        if (time == 1) {
                            Bukkit.broadcastMessage("§eO bate-papo local será §cdesativado§e em 1 segundo!");
                        }

                        if (time == 0) {
                            ChatAPI.getInstance().setChatState(ChatAPI.ChatState.DISABLED);
                            Bukkit.broadcastMessage(" ");
                            Bukkit.broadcastMessage("§cO bate-papo foi desativado!");
                            Bukkit.broadcastMessage(" ");
                            cancel();
                        }
                    }
                }.runTaskTimer(Main.getInstance(), 0, 20);
            } else if (args[1].equalsIgnoreCase("usa")) {

                if (!(ChatAPI.getInstance().getChatState() == ChatAPI.ChatState.DISABLED)) {
                    player.sendMessage("§cLocal chat is now disabled!");
                    return true;
                }

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (time == 5) {
                            Bukkit.broadcastMessage("§eLocal chat will be §cdisabled§e on 5 seconds!");
                        }

                        if (time == 4) {
                            Bukkit.broadcastMessage("§eLocal chat will be §cdisabled§e on 4 seconds!");
                        }

                        if (time == 3) {
                            Bukkit.broadcastMessage("§eLocal chat will be §cdisabled§e on 3 seconds!");
                        }

                        if (time == 2) {
                            Bukkit.broadcastMessage("§eLocal chat will be §cdisabled§e on 2 seconds!");
                        }

                        if (time == 1) {
                            Bukkit.broadcastMessage("§eLocal chat will be §cdisabled§e on 1 second!");
                        }

                        if (time == 0) {
                            ChatAPI.getInstance().setChatState(ChatAPI.ChatState.DISABLED);
                            Bukkit.broadcastMessage(" ");
                            Bukkit.broadcastMessage("§aLocal chat has been disabled!");
                            Bukkit.broadcastMessage(" ");
                            cancel();
                        }
                    }
                }.runTaskTimer(Main.getInstance(), 0, 20);
            }

        } else if (args[0].equalsIgnoreCase("clear")) {
            if (args[1] == null) {
                player.sendMessage("§cPlease fill in all data.");
                return true;
            }

            if (args[1].equalsIgnoreCase("brazil")) {
                ChatAPI.clear();
                Bukkit.broadcastMessage("§aO bate-papo foi limpo!");
            } else if (args[1].equalsIgnoreCase("usa")) {
                ChatAPI.clear();
                Bukkit.broadcastMessage("§aThe chat was cleared!");
            }
        }
        return false;
    }
}
