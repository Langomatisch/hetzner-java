package de.langomatisch.hetzner.internal;

import com.google.gson.Gson;
import de.langomatisch.hetzner.internal.exception.HetznerNotAuthorizedException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class WebRequest<T> {

    private static final Gson GSON = new Gson();

    private static final String BASE_URL = "https://api.hetzner.cloud/v1/";

    private final String subPath, apiKey;
    private final Class<T> tClass;
    private final Map<String, String> headers;

    public WebRequest(String subPath, String apiKey, Class<T> tClass, Map<String, String> headers) {
        if(subPath.startsWith("/")) {
            subPath = subPath.substring(1);
        }
        this.subPath = subPath;
        this.apiKey = apiKey;
        this.tClass = tClass;
        this.headers = headers;

    }

    public WebRequest(String subPath, String apiKey, Class<T> tClass) {
        this.subPath = subPath;
        this.apiKey = apiKey;
        this.tClass = tClass;
        this.headers = new HashMap<>();
    }


    private HttpClient getClient() {
        return HttpClient.newBuilder().build();
    }

    public T request() throws URISyntaxException, IOException, InterruptedException, HetznerNotAuthorizedException {
        HttpClient client = getClient();
        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(new URI(BASE_URL + subPath)).GET();
        if (apiKey != null && !apiKey.isEmpty()) {
            builder.header("Authorization", "Bearer "+apiKey);
        }
        headers.forEach(builder::header);
        HttpRequest build = builder.build();

        HttpResponse<String> send = client.send(build, HttpResponse.BodyHandlers.ofString());
        String body = send.body();
        System.out.println(send.statusCode());
        if(send.statusCode() == 401){
            throw new HetznerNotAuthorizedException(body);
        }
        return GSON.fromJson(body, tClass);
    }


}
