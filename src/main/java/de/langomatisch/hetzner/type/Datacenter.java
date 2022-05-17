package de.langomatisch.hetzner.type;

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

}
