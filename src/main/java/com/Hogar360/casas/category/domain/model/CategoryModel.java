package com.Hogar360.casas.category.domain.model;

import com.Hogar360.casas.category.domain.exceptions.DescriptionMaxSizeExceededException;
import com.Hogar360.casas.category.domain.exceptions.NameMaxSizeExceededException;
import com.Hogar360.casas.category.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        if (name.length() > 50) {
            throw new NameMaxSizeExceededException(DomainConstants.NAME_MAX_SIZE_EXCEEDED);
        }
        if (description.length() > 90) {
            throw new DescriptionMaxSizeExceededException(DomainConstants.DESCRIPTION_MAX_SIZE_EXCEEDED);
        }
        this.id = id;
        this.name = name;
        this.description = description;
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
        if (name.length() > 50) {
            throw new NameMaxSizeExceededException(DomainConstants.NAME_MAX_SIZE_EXCEEDED);
        }
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 90) {
            throw new DescriptionMaxSizeExceededException(DomainConstants.DESCRIPTION_MAX_SIZE_EXCEEDED);
        }

        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }
}
