package de.langomatisch.hetzner.type;

import com.google.gson.annotations.SerializedName;
import com.jcraft.jsch.Session;
import de.langomatisch.hetzner.internal.SSHConnection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Server {

    @SerializedName("backup_window")
    private String backupWindow;
    private String created;
    private Datacenter datacenter;
    private int id;
    private Image image;
    @SerializedName("included_traffic")
    private long includedTraffic;
    @SerializedName("ingoing_traffic")
    private long ingoingTraffic;
    private Iso iso;
    private Object labels;
    @SerializedName("load_balancers")
    private List<Integer> loadBalancers;
    private boolean locked;
    private String name;
    @SerializedName("outgoing_traffic")
    private long outgoingTraffic;
    @SerializedName("placement_group")
    private Object placementGroup;
    @SerializedName("primary_disk_size")
    private int primaryDiskSize;
    @SerializedName("private_net")
    private List<Network> privateNet;
    private Object protection;
    @SerializedName("public_net")
    private Network publicNet;
    @SerializedName("rescue_enabled")
    private boolean rescueEnabled;
    @SerializedName("server_type")
    private ServerType serverType;
    private Status status;
    private List<Integer> volumes;

    public SSHConnection connect(SSHKey key) {
        return new SSHConnection(publicNet.getIpv4().getIp(), 22, key, "root");
    }

    public enum Status {
        running,
        initializing,
        starting,
        stopping,
        off,
        deleting,
        migrating,
        rebuilding,
        unknown
    }

}
