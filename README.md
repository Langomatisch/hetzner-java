# Hetzner-Java

this is a small library for the Hetzner Cloud API

[API Documentation](https://docs.hetzner.cloud/)

### Which endpoints are done?
(get only currently)
- `/getdatacenters`
- `/getdatacenters/{id}`
- `/server_types`
- `/server_types/{id}`
- `/images`
- `/isos`
- `/isos/{id}`
- `/locations`
- `/locations/{id}`

### How to use the API?

```java

public static void main(String[]args){
    String apiKey = "your-api-key";
    HetznerCloudAPI api = new HetznerCloudAPI(apiKey);
    Datacenters datacenters = api.getDatacenters();
}

```