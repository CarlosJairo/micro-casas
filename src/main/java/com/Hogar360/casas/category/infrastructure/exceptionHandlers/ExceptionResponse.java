package com.Hogar360.casas.category.infrastructure.exceptionHandlers;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timeStamp) {
}
