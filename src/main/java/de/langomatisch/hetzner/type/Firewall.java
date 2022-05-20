package de.langomatisch.hetzner.type;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Firewall {

    private int id;
    private Status status;

    public enum Status {
        applied,
        pending;
    }

}
