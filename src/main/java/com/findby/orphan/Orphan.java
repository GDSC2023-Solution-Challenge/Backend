package com.findby.orphan;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
public class Orphan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long orphanId;

    public String name;

    public Integer age;

    public Double latitude;

    public Double longitude;

    public String gender;

    public String look;

    public String countryCode;

    public String countryName;

    public Orphan() {

    }
}
