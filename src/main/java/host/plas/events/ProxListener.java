package host.plas.events;

import host.plas.ProxProtect;
import host.plas.data.cause.HazardCause;
import host.plas.data.cause.HazardCauseType;
import singularity.events.server.CosmicChatEvent;
import tv.quaint.events.BaseEventListener;
import tv.quaint.events.processing.BaseProcessor;

public class ProxListener implements BaseEventListener {
    @BaseProcessor
    public void onChatEvent(CosmicChatEvent event) {
        HazardCause cause = new HazardCause(event.getPlayer(), HazardCauseType.CHAT, event.getMessage());
        
        ProxProtect.getHazardsConfig().getHazards().forEach(hazard -> {
            hazard.checkAndConclude(cause);
        });
    }
}
