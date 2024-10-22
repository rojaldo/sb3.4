package com.example.demo.shapes;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {
    public float calculateCircleArea(float radius) {
        return (float) (Math.PI * Math.pow(radius, 2));
    }

    public float calculateCirclePerimeter(float radius) {
        return (float) (2 * Math.PI * radius);
    }

    public float calculateRectangleArea(float width, float height) {
        return width * height;
    }

    public float calculateRectanglePerimeter(float width, float height) {
        return 2 * (width + height);
    }
}
