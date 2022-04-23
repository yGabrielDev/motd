package com.github.gabrielbruck.motd;

import com.github.gabrielbruck.motd.event.GeneralEvent;
import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
    @Setter
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        BungeeCord.getInstance().getPluginManager().registerListener(this, new GeneralEvent());

        BungeeCord.getInstance().getConsole().sendMessage(TextComponent.fromLegacyText("§d§lMOTD§2 Plugin iniciado com sucesso!"));
    }
}
