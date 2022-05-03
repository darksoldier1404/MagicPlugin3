package yejunho10.magicplugin.party;

import org.bukkit.entity.Player;
import yejunho10.magicplugin.GUIPlugin;

@SuppressWarnings("all")
public class PartyPlayer {
    private static final GUIPlugin plugin = GUIPlugin.getInstance();
    private int partyId;

    private PartyPlayer(Player p) {
        partyId = -1;
        plugin.ppMap.put(p.getName(), this);
    }

    public static void registerPartyPlayer(Player p) {
        if (!plugin.ppMap.containsKey(p.getName()))
            new PartyPlayer(p);
    }

    public static PartyPlayer getPartyPlayer(Player p) {
        return plugin.ppMap.containsKey(p.getName()) ? plugin.ppMap.get(p.getName()) : new PartyPlayer(p);
    }

    public int getPartyId() {
        return partyId;
    }

    public boolean hasParty() {
        return partyId != -1;
    }

    public void joinParty(int partyId) {
        this.partyId = partyId;
    }

    public void leaveParty() {
        partyId = -1;
    }
}
