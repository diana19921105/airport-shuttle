package com.liligo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SystemMessage {

    private String message;
    private String traceId;

}
