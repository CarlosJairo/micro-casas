package com.Hogar360.casas.infrastructure.exceptionHandlers;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timeStamp) {
}
