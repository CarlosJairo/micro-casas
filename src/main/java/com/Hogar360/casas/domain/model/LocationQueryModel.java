package com.Hogar360.casas.domain.model;
public class LocationQueryModel {
    private Long cityId;
    private String cityName;
    private Long departmentId;
    private String departmentName;

    public LocationQueryModel(Long cityId, String cityName, Long departmentId, String departmentName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // Getters y Setters
    public Long getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
