package ru.aston.dvorianchykov_sa.task1.Interfaces;

import ru.aston.dvorianchykov_sa.task1.Exceptions.IncorrectUserAgeException;
import ru.aston.dvorianchykov_sa.task1.Exceptions.NullUserException;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal getDiscount() throws NullUserException, IncorrectUserAgeException;
}
