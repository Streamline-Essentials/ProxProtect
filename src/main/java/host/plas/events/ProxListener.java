package host.plas.events;

import host.plas.ProxProtect;
import host.plas.data.cause.HazardCause;
import host.plas.data.cause.HazardCauseType;
import singularity.events.server.CosmicChatEvent;
import tv.quaint.events.BaseEventListener;
import tv.quaint.events.processing.BaseProcessor;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProxListener implements BaseEventListener {
    @BaseProcessor
    public void onChatEvent(CosmicChatEvent event) {
        HazardCause cause = new HazardCause(event.getPlayer(), HazardCauseType.CHAT, event.getMessage());

        AtomicBoolean cancel = new AtomicBoolean(false);
        ProxProtect.getHazardsConfig().getHazards().forEach(hazard -> {
            if (cancel.get()) return;

            boolean bool = hazard.checkAndConclude(cause);
            cancel.set(bool);
        });

        if (cancel.get()) {
            event.setCanceled(true); // Chat Event.
            event.setCancelled(true); // Base Event.
        }
    }
}
