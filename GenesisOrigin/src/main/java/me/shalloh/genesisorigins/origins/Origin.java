package me.shalloh.genesisorigins.origins;

import org.bukkit.entity.Player;

import java.util.UUID;

public class Origin {
    private String OriginName;
    private Integer ImpactType;
    private UUID PlayerUUID;

    private String id;
    public Origin (String OriginName, Integer ImpactType, UUID PlayerUUID){
     this.OriginName = OriginName;
     this.ImpactType = ImpactType;
     this.PlayerUUID = PlayerUUID;
     this.id = UUID.randomUUID().toString();
    }

    public UUID getPlayerUUID() {
        return PlayerUUID;
    }

    public void setPlayerUUID(UUID playeruuid) {
        this.PlayerUUID = playeruuid;
    }

    public String getId() {
        return id;
    }

    public String getOriginName() {
        return OriginName;
    }

    public void setOriginName(String originName) {
        OriginName = originName;
    }

    public Integer getImpactType() {
        return ImpactType;
    }

    public void setImpactType(Integer impactType) {
        ImpactType = impactType;
    }
}
