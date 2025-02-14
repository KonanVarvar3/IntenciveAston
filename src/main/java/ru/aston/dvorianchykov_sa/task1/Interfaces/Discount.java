package ru.aston.dvorianchykov_sa.task1.Interfaces;

import ru.aston.dvorianchykov_sa.task1.exceptions.IncorrectUserAgeException;
import ru.aston.dvorianchykov_sa.task1.exceptions.NullUserException;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal getDiscount() throws NullUserException, IncorrectUserAgeException;
}
