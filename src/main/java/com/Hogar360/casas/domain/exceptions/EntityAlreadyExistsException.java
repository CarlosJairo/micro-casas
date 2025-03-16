package com.Hogar360.casas.domain.exceptions;

import com.Hogar360.casas.domain.utils.constants.DomainConstants;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String entityName) {
        super(String.format(DomainConstants.ENTITY_ALREADY_CREATED, entityName));
    }
}
