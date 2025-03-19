package com.Hogar360.casas.domain.model;

public class LocationModel {
    private Long id;
    private Long cityId;
    private Long departmentId;

    public LocationModel(Long id, Long cityId, Long departmentId) {
        this.id = id;
        this.cityId = cityId;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
