package de.langomatisch.hetzner.type;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

    @SerializedName("bound_to")
    private int boundTo;
    private String created;
    private CreatedFrom createdFrom;
    private String deleted;
    private String deprecated;
    private String description;
    @SerializedName("disk_size")
    private int diskSize;
    private int id;
    @SerializedName("image_size")
    private double imageSize;
    // FIXME: give this thing a real object
    private Object labels;
    private String name;
    @SerializedName("os_flavor")
    private String osFlavor;
    @SerializedName("os_version")
    private String osVersion;
    private Protection protection;
    @SerializedName("rapid_deploy")
    private boolean rapidDeploy;
    private String status;
    private String type;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Protection {
        private boolean delete;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CreatedFrom {
        private int id;
        private String name;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Sort {
        ID("id"),
        ID_ASC("id:asc"),
        ID_DESC("id:desc"),
        NAME("name"),
        NAME_ASC("name:asc"),
        NAME_DESC("name:desc"),
        CREATED("created"),
        CREATED_ASC("created:asc"),
        CREATED_DESC("created:desc");

        private final String id;

    }

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        SYSTEM("system"),
        SNAPSHOT("snapshot"),
        BACKUP("backup"),
        APP("app");

        private final String id;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        AVAILABLE("available"),
        CREATING("creating");

        private final String id;
    }

}
