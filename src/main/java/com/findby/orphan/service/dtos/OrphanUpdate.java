package com.findby.orphan.service.dtos;

import com.findby.post.service.dtos.PostRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrphanUpdate {
    private String name;
    private Integer age;
    private Double latitude;
    private Double longitude;
    private String gender;
    private String look;
    private String countryCode;
    private String countryName;

    public OrphanUpdate(PostRequest request) {
        this.name = request.getName();
        this.age = request.getAge();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
        this.gender = request.getGender();
        this.look = request.getLook();
        this.countryCode = request.getCountryCode();
        this.countryName = request.getCountryName();
    }
}
