package de.langomatisch.hetzner.api;

import de.langomatisch.hetzner.internal.WebRequest;
import de.langomatisch.hetzner.internal.exception.HetznerNotAuthorizedException;
import de.langomatisch.hetzner.type.Datacenters;
import de.langomatisch.hetzner.util.MapUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

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
        try {
            return request.request();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Void> getAvailableServer() {
        return null;
    }

    public CompletableFuture<Boolean> createServer() {
        return null;
    }

}
