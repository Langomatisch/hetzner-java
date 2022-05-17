package de.langomatisch.hetzner.type;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServerTypes {

    @SerializedName("server_types")
    private List<ServerType> serverTypes;

}
