package ru.sergeysemenov.SpringSecurityExample.service;

import org.springframework.stereotype.Service;

@Service
public class RandomNumService {

    public double getRandomNum() {
        return Math.random();
    }

    public double getRandomNumInRange(double min, double max) {
        return Math.random() * (max - min) + min;
    }
}
