package ru.aston.dvorianchykov_sa.task1.Services;

import ru.aston.dvorianchykov_sa.task1.Exceptions.NullUserException;
import ru.aston.dvorianchykov_sa.task1.Models.User;
import ru.aston.dvorianchykov_sa.task1.constants.Procedures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ToothExtractionService extends Service {

    private Procedures procedure;
    private boolean isStudent;

    public ToothExtractionService(User user, Procedures procedure, boolean isStudent) throws NullUserException {
        super(user);
        this.procedure = procedure;
        this.isStudent = isStudent;
        this.total = calculateTotal();
    }

    public void setUser(User user) throws NullUserException {
        if (user == null) throw new NullUserException();
        this.user = user;
        this.total = calculateTotal();
    }

    public String getProcedureName() {
        return procedure.getName();
    }

    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
        this.total = calculateTotal();
    }

    public void setProcedure(Procedures procedure) {
        this.procedure = procedure;
        this.total = calculateTotal();
    }

    @Override
    public BigDecimal getDiscount() {
        BigDecimal percent = isStudent ? new BigDecimal("0.1") : new BigDecimal(0);
        return procedure.getPrice().multiply(percent).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotal() {
        return procedure.getPrice().subtract(getDiscount()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, %s %s, age: %d - %s, cost: %s, discount: %s", super.getId(), user.getSurname(), user.getName(), user.getAge(), procedure.getName(), total, getDiscount());
    }
}
