package ru.aston.dvorianchykov_sa.task1.Services;

import ru.aston.dvorianchykov_sa.task1.Exceptions.IncorrectUserAgeException;
import ru.aston.dvorianchykov_sa.task1.Exceptions.NullUserException;
import ru.aston.dvorianchykov_sa.task1.Models.User;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RentgenService extends Service {

    private static final BigDecimal RENTGEN_PRICE = new BigDecimal(600).setScale(2, RoundingMode.HALF_UP);

    public RentgenService(User user) throws NullUserException, IncorrectUserAgeException {
        super(user);
        this.total = calculateTotal();
    }

    public void setUser(User user) throws IncorrectUserAgeException, NullUserException {
        if (user == null) throw new NullUserException();
        this.user = user;
        this.total = calculateTotal();
    }

    @Override
    public BigDecimal getDiscount() throws IncorrectUserAgeException {
        return isChild()
                ? RENTGEN_PRICE.multiply(BigDecimal.valueOf(0.4)).setScale(2, RoundingMode.HALF_UP)
                : new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotal() throws IncorrectUserAgeException {
        return RENTGEN_PRICE.subtract(getDiscount()).setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isChild() throws IncorrectUserAgeException {
        if (getUser().getAge() < 0) throw new IncorrectUserAgeException(getUser().getAge());
        return getUser().getAge() < 18;
    }

    @Override
    public String toString() {
        try {
            return String.format("ID: %d, %s %s, age: %d - Rentgen, cost: %s, discount: %s", super.getId(), user.getSurname(), user.getName(), user.getAge(), total, getDiscount());
        } catch (IncorrectUserAgeException e) {
            return new IncorrectUserAgeException(user.getAge()).getMessage();
        }
    }
}
