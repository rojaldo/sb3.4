package com.example.demo.shapes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CircleDto implements IResponseCircle {
    
    private float radius;
    private float area;
    private float perimeter;

}
