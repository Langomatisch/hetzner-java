package de.langomatisch.hetzner.type;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPV4 {

    private boolean blocked;
    @SerializedName("dns_ptr")
    private String dnsPointer;
    private int id;
    private String ip;

}
