package de.langomatisch.hetzner.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Iso {

    private String deprecated;
    private String description;
    private int id;
    private String name;
    private String type;

}
