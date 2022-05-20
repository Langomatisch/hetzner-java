package de.langomatisch.hetzner.api;

import de.langomatisch.hetzner.internal.WebRequest;
import de.langomatisch.hetzner.internal.exception.HetznerNotAuthorizedException;
import de.langomatisch.hetzner.type.*;
import de.langomatisch.hetzner.util.MapUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HetznerCloudAPI {

    private final String apiKey;

    public HetznerCloudAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    public Datacenters getDatacenters() throws HetznerNotAuthorizedException {
        return getDatacenters("");
    }

    public Datacenters getDatacenters(String filter) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/datacenters", apiKey, Datacenters.class, MapUtil.asMap("name", filter)).request();
    }

    public Datacenter getDatacenter(String id) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/datacenter/" + id, apiKey, Datacenter.class).request();
    }

    public ServerTypes getServerTypes() throws HetznerNotAuthorizedException {
        return getServerTypes("");
    }

    public ServerTypes getServerTypes(String filter) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/server_types", apiKey, ServerTypes.class, MapUtil.asMap("name", filter)).request();
    }

    public ServerType getServerType(String id) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/server_types/" + id, apiKey, ServerType.class).request();
    }

    public Images getImages() throws HetznerNotAuthorizedException {
        return new WebRequest<>("/images", apiKey, Images.class).request();
    }

    public Images getImages(Image.Sort sort, Image.Type type, Image.Status status, String boundTo, boolean includesDeprecated, String name, String labelSelector) throws HetznerNotAuthorizedException {
        Map<String, String> map = new HashMap<>();
        map.put("sort", sort.getId());
        map.put("type", type.getId());
        map.put("status", status.getId());
        if (type.equals(Image.Type.BACKUP)) {
            map.put("bound_to", boundTo);
        }
        map.put("include_deprecated", String.valueOf(includesDeprecated));
        map.put("name", name);
        map.put("label_selector", labelSelector);
        return new WebRequest<>("/images", apiKey, Images.class, map).request();
    }

    public Isos getIsos() throws HetznerNotAuthorizedException {
        return getIsos("");
    }

    public Isos getIsos(String filter) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/isos", apiKey, Isos.class, MapUtil.asMap("name", filter)).request();
    }

    public Iso getIso(int id) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/isos/" + id, apiKey, Iso.class).request();
    }

    public Locations getLocations() throws HetznerNotAuthorizedException {
        return getLocations("");
    }
    public Locations getLocations(String filter) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/locations", apiKey, Locations.class, MapUtil.asMap("name", filter)).request();
    }

    public Locations getLocation(int id) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/locations/" + id, apiKey, Locations.class).request();
    }

    public Servers getServers() throws HetznerNotAuthorizedException {
        return new WebRequest<>("/servers", apiKey, Servers.class).request();
    }

    public Servers getServers(String filter) throws HetznerNotAuthorizedException {
        return new WebRequest<>("/servers", apiKey, Servers.class).request();
    }
}
