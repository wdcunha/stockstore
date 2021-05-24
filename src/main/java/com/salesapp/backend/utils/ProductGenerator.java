package com.salesapp.backend.utils;

import java.util.Random;

public class ProductGenerator implements IdGenerator{

    @Override
    public String generateNumber() {
        return "brand-" + Math.abs(new Random().nextInt());
    }
}
