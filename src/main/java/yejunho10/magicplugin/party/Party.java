package yejunho10.magicplugin.party;

import org.bukkit.entity.Player;
import yejunho10.magicplugin.GUIPlugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("all")
public class Party {
    private static final GUIPlugin plugin = GUIPlugin.getInstance();
    private static int lastId = 0;
    private int id;
    private Player masterPlayer;
    private Set<Player> players;

    public Party(Player p) {
        masterPlayer = p;
        players = new HashSet<>();
        players.add(p);
        id = lastId++;
        plugin.partyMap.put(id, this);
    }

    public static Party getParty(int id) {
        return plugin.partyMap.getOrDefault(id, null);
    }

    public int getId() {
        return id;
    }

    public Player getMasterPlayer() {
        return masterPlayer;
    }

    public boolean isMaster(Player p) {
        return masterPlayer.equals(p);
    }

    public void changeMaster() {
        for (Player p : players) {
            masterPlayer = p;
            return;
        }
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

    public void removeParty() {
        plugin.partyMap.remove(id);
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void sendMessage(String msg) {
        for (Player p : players) {
            p.sendMessage(msg);
        }
    }
}
