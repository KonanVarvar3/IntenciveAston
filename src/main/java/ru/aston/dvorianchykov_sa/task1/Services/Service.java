package ru.aston.dvorianchykov_sa.task1.Services;

import ru.aston.dvorianchykov_sa.task1.Exceptions.NullUserException;
import ru.aston.dvorianchykov_sa.task1.Interfaces.Discount;
import ru.aston.dvorianchykov_sa.task1.Models.User;

import java.math.BigDecimal;

public abstract class Service implements Discount {

    private static int incrementId = 1;
    private final int id;
    protected User user;
    protected BigDecimal total;

    public Service(User user) throws NullUserException {
        if (user == null) throw new NullUserException();
        this.id = incrementId;
        incrementId++;
        this.user = user;
    }

    public static int getIncrementId() {
        return incrementId;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
