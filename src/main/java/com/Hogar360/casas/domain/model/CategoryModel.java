package com.Hogar360.casas.domain.model;

import com.Hogar360.casas.domain.exceptions.DescriptionEmptyException;
import com.Hogar360.casas.domain.exceptions.DescriptionMaxSizeExceededException;
import com.Hogar360.casas.domain.exceptions.NameEmptyException;
import com.Hogar360.casas.domain.exceptions.NameMaxSizeExceededException;
import com.Hogar360.casas.domain.utils.constants.CategoryDomainConstants;
import com.Hogar360.casas.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        if (name.trim().isEmpty()) {
            throw new NameEmptyException(DomainConstants.FIELD_NAME_EMPTY_MESSAGE);
        }
        if (description.trim().isEmpty()) {
            throw new DescriptionEmptyException(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE);
        }
        if (name.length() > CategoryDomainConstants.CATEGORY_NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(CategoryDomainConstants.CATEGORY_NAME_MAX_SIZE_EXCEEDED);
        }
        if (description.length() > CategoryDomainConstants.CATEGORY_DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(CategoryDomainConstants.CATEGORY_DESCRIPTION_MAX_SIZE_EXCEEDED);
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
        if (name.trim().isEmpty()) {
            throw new NameEmptyException(DomainConstants.FIELD_NAME_EMPTY_MESSAGE);
        }

        if (name.length() > CategoryDomainConstants.CATEGORY_NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(CategoryDomainConstants.CATEGORY_NAME_MAX_SIZE_EXCEEDED);
        }
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.trim().isEmpty()) {
            throw new DescriptionEmptyException(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE);
        }
        if (description.length() > CategoryDomainConstants.CATEGORY_DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(CategoryDomainConstants.CATEGORY_DESCRIPTION_MAX_SIZE_EXCEEDED);
        }

        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }
}
