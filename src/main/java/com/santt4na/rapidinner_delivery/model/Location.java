package com.santt4na.rapidinner_delivery.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Column(precision = 9, scale = 6, columnDefinition = "DECIMAL(9,6)")
    private BigDecimal latitude;

    @Column(precision = 9, scale = 6, columnDefinition = "DECIMAL(9,6)")
    private BigDecimal longitude;

    public void setLatitude(BigDecimal latitude) {
        if (latitude == null ||
                latitude.compareTo(new BigDecimal("-90")) < 0 ||
                latitude.compareTo(new BigDecimal("90")) > 0) {
            throw new IllegalArgumentException("Invalid latitude! Valid range: -90 to 90");
        }
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        if (longitude == null ||
                longitude.compareTo(new BigDecimal("-180")) < 0 ||
                longitude.compareTo(new BigDecimal("180")) > 0) {
            throw new IllegalArgumentException("Invalid longitude! Valid range: -180 to 180");
        }
        this.longitude = longitude;
    }

    public static Location of(BigDecimal latitude, BigDecimal longitude) {
        return new Location(latitude, longitude);
    }
}