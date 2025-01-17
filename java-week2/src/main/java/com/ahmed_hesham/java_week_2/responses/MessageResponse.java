package com.ahmed_hesham.java_week_2.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {
    private String message;
}
