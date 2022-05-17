package de.langomatisch.hetzner.type;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pricing {

    private String location;
    @SerializedName("price_hourly")
    private Price priceHourly;
    @SerializedName("price_monthly")
    private Price priceMonthly;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Price {
        private double gross, net;
    }

}
