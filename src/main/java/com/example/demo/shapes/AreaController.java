package com.example.demo.shapes;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
public class AreaController {

    @Autowired
    AreaService areaService;

    @GetMapping("/circle")
    public ResponseEntity<IResponseCircle> getMethodName(
            @RequestParam(name = "r", required = false, defaultValue = "3.0") float radius) {
                if (radius < 0) {
                    return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ErrorDto.builder()
                            .message("Radius must be greater than 0")
                            .status(HttpStatus.BAD_REQUEST.value())
                            .details("The radius provided was " + radius)
                            .build());
                }

        return ResponseEntity
                .status(HttpStatus.OK)
                .header( "my header", "my value")
                .body(CircleDto.builder()
                    .radius(radius)
                    .area(areaService.calculateCircleArea(radius))
                    .perimeter(areaService.calculateCirclePerimeter(radius))
                .build());
    }

}
