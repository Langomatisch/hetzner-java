package de.langomatisch.hetzner.type;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Datacenter {

    private String description;
    private int id;
    private Location location;
    private String name;
    private ServerTypes serverTypes;
    private int recommendation;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ServerTypes {

        private int[] available;
        @SerializedName("available_for_migration")
        private int[] availableForMigration;
        private int[] supported;

    }
}
