package com.santt4na.rapidinner_delivery.utils;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private double latitude;
    private double longitude;

    public void setLatitude(double latitude) {
        if (latitude < -90 || latitude > 90)
            throw new IllegalArgumentException("Latitude inválida!");
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        if (longitude < -180 || longitude > 180)
            throw new IllegalArgumentException("Longitude inválida!");
        this.longitude = longitude;
    }
}