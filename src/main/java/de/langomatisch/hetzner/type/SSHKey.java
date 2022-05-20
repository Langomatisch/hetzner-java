package de.langomatisch.hetzner.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SSHKey {

    private String key;
    private String passphrase;

}
