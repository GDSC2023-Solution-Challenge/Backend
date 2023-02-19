package com.findby.orphan.service.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrphanResponse {
    private final Long orphanId;
    private final String name;
    private final Integer age;
    private final Double latitude;
    private final Double longitude;
    private final String gender;
    private final String look;
    private final String countryCode;
    private final String countryName;

    public static OrphanResponse of(
            Long orphanId,
            String name,
            Integer age,
            Double latitude,
            Double longitude,
            String gender,
            String look,
            String countryCode,
            String countryName
    ) {
        return new OrphanResponse(
                orphanId, name, age, latitude, longitude, gender, look, countryCode, countryName
        );
    }
}
