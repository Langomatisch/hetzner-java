package de.langomatisch.hetzner.api;

import de.langomatisch.hetzner.internal.WebRequest;
import de.langomatisch.hetzner.internal.exception.HetznerNotAuthorizedException;
import de.langomatisch.hetzner.type.Datacenter;
import de.langomatisch.hetzner.type.Datacenters;
import de.langomatisch.hetzner.type.ServerType;
import de.langomatisch.hetzner.type.ServerTypes;
import de.langomatisch.hetzner.util.MapUtil;

public class HetznerCloudAPI {

    private final String apiKey;

    public HetznerCloudAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public Datacenters getDatacenters() throws HetznerNotAuthorizedException {
        return getDatacenters("");
    }

    public Datacenters getDatacenters(String filter) throws HetznerNotAuthorizedException {
        WebRequest<Datacenters> request = new WebRequest<>("/datacenters", apiKey, Datacenters.class, MapUtil.asMap("name", filter));
        return request.request();
    }

    public Datacenter getDatacenter(String id) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/datacenter/" + id, apiKey, Datacenter.class).request();
    }

    public ServerTypes getServerTypes() throws HetznerNotAuthorizedException {
        return getServerTypes("");
    }

    public ServerTypes getServerTypes(String filter) throws HetznerNotAuthorizedException {
        WebRequest<ServerTypes> request = new WebRequest<>("/server_types", apiKey, ServerTypes.class, MapUtil.asMap("name", filter));
        return request.request();
    }

    public ServerType getServerType(String id) throws HetznerNotAuthorizedException {
        WebRequest<ServerType> request = new WebRequest<>("/server_types/"+id, apiKey, ServerType.class);
        return request.request();
    }
}
