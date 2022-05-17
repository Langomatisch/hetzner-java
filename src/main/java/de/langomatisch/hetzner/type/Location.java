package de.langomatisch.hetzner.type;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {

    private String city;
    private String country;
    private String description;
    private int id;
    private double latitude;
    private double longitude;
    private String name;
    @SerializedName("network_zone")
    private String networkZone;

}
