package com.findby.orphan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
public class Orphan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orphanId;

    private String name;

    private Integer age;

    private Double latitude;

    private Double longitude;

    private String gender;

    private String look;

    private String countryCode;

    private String countryName;

    public Orphan() {

    }

    public Orphan update(String name, Integer age, Double latitude, Double longitude, String gender, String look, String countryCode, String countryName) {
        this.name = name;
        this.age = age;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gender = gender;
        this.look = look;
        this.countryCode = countryCode;
        this.countryName = countryName;
        return this;
    }
}
