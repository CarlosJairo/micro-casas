package com.Hogar360.casas.domain.model;

import com.Hogar360.casas.domain.exceptions.DescriptionEmptyException;
import com.Hogar360.casas.domain.exceptions.DescriptionMaxSizeExceededException;
import com.Hogar360.casas.domain.exceptions.NameEmptyException;
import com.Hogar360.casas.domain.exceptions.NameMaxSizeExceededException;
import com.Hogar360.casas.domain.utils.constants.CityDomainConstants;
import com.Hogar360.casas.domain.utils.constants.DomainConstants;

public class CityModel {
    private Long id;
    private String name;
    private String description;
    private final Long departmentId;

    public CityModel(Long id, String name, String description, Long departmentId) {
        if (name.trim().isEmpty()) {
            throw new NameEmptyException(DomainConstants.FIELD_NAME_EMPTY_MESSAGE);
        }
        if (description.trim().isEmpty()) {
            throw new DescriptionEmptyException(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE);
        }
        if (name.length() > CityDomainConstants.CITY_NAME_MAX_LENGTH ) {
            throw new NameMaxSizeExceededException(CityDomainConstants.CITY_NAME_MAX_SIZE_EXCEEDED);
        }
        if (description.length() > CityDomainConstants.CITY_DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(CityDomainConstants.CITY_DESCRIPTION_MAX_SIZE_EXCEEDED);
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new NameEmptyException(DomainConstants.FIELD_NAME_EMPTY_MESSAGE);
        }
        if (name.length() > CityDomainConstants.CITY_NAME_MAX_LENGTH ) {
            throw new NameMaxSizeExceededException(CityDomainConstants.CITY_NAME_MAX_SIZE_EXCEEDED);
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.trim().isEmpty()) {
            throw new DescriptionEmptyException(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE);
        }
        if (description.length() > CityDomainConstants.CITY_DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(CityDomainConstants.CITY_DESCRIPTION_MAX_SIZE_EXCEEDED);
        }
        this.description = description;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}
