package com.github.gabrielbruck.motd.event;

import com.github.gabrielbruck.motd.Main;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class GeneralEvent implements Listener {

    @EventHandler
    public void onServer(ProxyPingEvent proxyPingEvent) {
        ServerPing serverPing = proxyPingEvent.getResponse();

        serverPing.setDescription("§a§lGAAEL §b§l§m->§f §egithub.com/yGabrielDev \n" +
                "§4§lERROS? ENTRE EM CONTATO: §bGabriel.#9875");

        proxyPingEvent.setResponse(serverPing);
    }

}
