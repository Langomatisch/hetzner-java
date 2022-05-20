package de.langomatisch.hetzner.type;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Network {

    private List<Firewall> firewalls;
    @SerializedName("floating_ips")
    private List<Integer> floatingIps;
    private IPV4 ipv4;
    // FIXME: ipv6


}
