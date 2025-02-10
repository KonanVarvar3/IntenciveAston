package ru.aston.dvorianchykov_sa.task1.constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Procedures {
    BABY_TOOTH_EXTRACTION("Extraction of baby tooth", new BigDecimal(500).setScale(2, RoundingMode.HALF_UP)),
    MOLAR_TOOTH_EXTRACTION("Extraction of molar tooth", new BigDecimal(1000).setScale(2, RoundingMode.HALF_UP)),
    MORAL_TOOTH_EXTRACTION("Extraction of moral tooth", new BigDecimal(1500).setScale(2, RoundingMode.HALF_UP));

    private final String name;
    private final BigDecimal price;

    Procedures(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
