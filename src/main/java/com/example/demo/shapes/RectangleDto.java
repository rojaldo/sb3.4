package com.example.demo.shapes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RectangleDto implements IResponseRectangle {
        
        private float width;
        private float height;
        private float area;
        private float perimeter;
}
