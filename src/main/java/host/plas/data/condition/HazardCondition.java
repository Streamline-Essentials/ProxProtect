package host.plas.data.condition;

import host.plas.data.cause.HazardCause;
import lombok.Getter;
import lombok.Setter;
import tv.quaint.objects.Identifiable;

@Getter @Setter
public class HazardCondition implements Identifiable {
    private String identifier;

    private HazardConditionType type;
    private String value;

    public HazardCondition(String identifier, HazardConditionType type, String value) {
        this.identifier = identifier;
        this.type = type;
        this.value = value;
    }

    public boolean checkHazard(HazardCause cause) {
        switch (type) {
            case MESSAGE_EQUALS:
                return cause.getValue().equals(value);
            case MESSAGE_CONTAINS:
                return cause.getValue().contains(value);
            case MESSAGE_STARTS_WITH:
                return cause.getValue().startsWith(value);
            case MESSAGE_ENDS_WITH:
                return cause.getValue().endsWith(value);
            case SERVER_NAME_EQUALS:
                return cause.getPlayer().getServerName().equals(value);
            case SERVER_NAME_CONTAINS:
                return cause.getPlayer().getServerName().contains(value);
            case SERVER_NAME_STARTS_WITH:
                return cause.getPlayer().getServerName().startsWith(value);
            case SERVER_NAME_ENDS_WITH:
                return cause.getPlayer().getServerName().endsWith(value);
            case PLAYER_NAME_EQUALS:
                return cause.getPlayer().getCurrentName().equals(value);
            case PLAYER_NAME_CONTAINS:
                return cause.getPlayer().getCurrentName().contains(value);
            case PLAYER_NAME_STARTS_WITH:
                return cause.getPlayer().getCurrentName().startsWith(value);
            case PLAYER_NAME_ENDS_WITH:
                return cause.getPlayer().getCurrentName().endsWith(value);
            case PLAYER_UUID_EQUALS:
                return cause.getPlayer().getUuid().equals(value);
            case PLAYER_UUID_CONTAINS:
                return cause.getPlayer().getUuid().contains(value);
            case PLAYER_UUID_STARTS_WITH:
                return cause.getPlayer().getUuid().startsWith(value);
            case PLAYER_UUID_ENDS_WITH:
                return cause.getPlayer().getUuid().endsWith(value);
            case PLAYER_IP_EQUALS:
                return cause.getPlayer().getCurrentIp().equals(value);
            case PLAYER_IP_CONTAINS:
                return cause.getPlayer().getCurrentIp().contains(value);
            case PLAYER_IP_STARTS_WITH:
                return cause.getPlayer().getCurrentIp().startsWith(value);
            case PLAYER_IP_ENDS_WITH:
                return cause.getPlayer().getCurrentIp().endsWith(value);
            default:
                return false;
        }
    }
}
