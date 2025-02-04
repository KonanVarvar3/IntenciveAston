package Interfaces;

import Exceptions.IncorrectUserAgeException;
import Exceptions.NullUserException;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal getDiscount() throws NullUserException, IncorrectUserAgeException;
}
