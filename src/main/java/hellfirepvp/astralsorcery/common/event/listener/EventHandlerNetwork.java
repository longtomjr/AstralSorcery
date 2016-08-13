package hellfirepvp.astralsorcery.common.event.listener;

import hellfirepvp.astralsorcery.AstralSorcery;
import hellfirepvp.astralsorcery.common.data.SyncDataHolder;
import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
import hellfirepvp.astralsorcery.common.network.PacketChannel;
import hellfirepvp.astralsorcery.common.network.packet.server.PktSyncConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: EventHandlerNetwork
 * Created by HellFirePvP
 * Date: 07.05.2016 / 01:10
 */
public class EventHandlerNetwork {

    @SubscribeEvent
    public void onLogin(PlayerEvent.PlayerLoggedInEvent e) {
        EntityPlayerMP p = (EntityPlayerMP) e.player;
        AstralSorcery.log.info("Synchronizing configuration to " + p.getName());
        PacketChannel.CHANNEL.sendTo(new PktSyncConfig(), p);

        ResearchManager.sendInitClientKnowledge(p);

        SyncDataHolder.syncAllDataTo(p);
    }

    @SubscribeEvent
    public void onLogout(PlayerEvent.PlayerLoggedOutEvent e) {
        EntityPlayer player = e.player;

        ResearchManager.logoutResetClient(player);
    }

}