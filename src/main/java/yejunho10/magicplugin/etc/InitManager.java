package yejunho10.magicplugin.etc;

import yejunho10.magicplugin.GUIPlugin;
import yejunho10.magicplugin.cmd.*;
import yejunho10.magicplugin.event.Event;
import yejunho10.magicplugin.gui.ItemInventory;
import yejunho10.magicplugin.npc.FPCommand;
import yejunho10.magicplugin.party.PartyCommand;

import static org.bukkit.Bukkit.getServer;

@SuppressWarnings("all")
public class InitManager {
    private static final GUIPlugin plugin = GUIPlugin.getInstance();

    public static void init() {
        getServer().getPluginManager().registerEvents(new Event(), plugin);
        getServer().getPluginManager().registerEvents(new ItemInventory(), plugin);
        plugin.getCommand("mp").setExecutor(new MPCommand());
        plugin.getCommand("rules").setExecutor(new Rules());
        plugin.getCommand("menu").setExecutor(new ItemCommands());
        plugin.getCommand("sethome").setExecutor(new SetHome());
        plugin.getCommand("home").setExecutor(new Home());
        plugin.getCommand("tk").setExecutor(new Ticket());
        plugin.getCommand("party").setExecutor(new PartyCommand());
        plugin.getCommand("fp").setExecutor(new FPCommand());
    }
}
