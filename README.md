# Hetzner-Java

this is a small library for the Hetzner Cloud API

### Which endpoints are done?

- `/getdatacenter`

### How to use the API?

```java

public static void main(String[]args){
    String apiKey = "your-api-key";
    HetznerCloudAPI api = new HetznerCloudAPI(apiKey);
    Datacenters datacenters = api.getDatacenters();
}

```