package generic.core.bungee.profile;

import java.util.UUID;

public class Profile {

    private String name;
    private UUID uuid;

    public Profile(String name, UUID uid){
        this.name = name;
        this.uuid = uid;
    }
}
