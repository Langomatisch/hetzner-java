package de.langomatisch.hetzner.type;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServerType {

    private int cores;
    @SerializedName("cpu_type")
    private String cpuType;
    private boolean deprecated;
    private int disk;
    private int id;
    private int memory;
    private String name;
    private List<Pricing> prices;
    @SerializedName("storage_type")
    private String storageType;

}
