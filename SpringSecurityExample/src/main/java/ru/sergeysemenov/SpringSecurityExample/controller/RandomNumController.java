package ru.sergeysemenov.SpringSecurityExample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeysemenov.SpringSecurityExample.service.RandomNumService;

@RestController
@RequestMapping("/api/v1/random-num")
@RequiredArgsConstructor
public class RandomNumController {
    RandomNumService randomNumService;


    @Operation(summary = "Запрос на получения случайного числа")
    @GetMapping("/")
    public Double getRandomNum() {
        return randomNumService.getRandomNum();
    }

    @Operation(summary = "Запрос на получения случайного числа в указанном диапазоне")
    @GetMapping("/range")
    public Double getRandomNumInRange(@RequestParam(name = "min", defaultValue = "0.0" ) Double min,
                                      @RequestParam(name = "max", defaultValue = "10.0") Double max) {
        return randomNumService.getRandomNumInRange(min, max);
    }

}
