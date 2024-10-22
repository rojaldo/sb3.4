package com.example.demo.shapes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto implements IResponseCircle, IResponseRectangle {
        
        private String message;
        private int status;
        private String details;
}
