package com.example.clinic.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Data
public class ApiException {
    Throwable cause;
    String message;
    ZonedDateTime time;
}
