package generic.core.common.profile.profile;

import java.util.UUID;

public class Profile {

    private String name;
    private UUID uuid;

    public Profile(String name, UUID uid){
        this.name = name;
        this.uuid = uid;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
