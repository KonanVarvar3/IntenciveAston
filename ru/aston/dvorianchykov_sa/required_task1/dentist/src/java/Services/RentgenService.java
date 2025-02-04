package Services;

import Exceptions.IncorrectUserAgeException;
import Exceptions.NullUserException;
import Models.User;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RentgenService extends Service {

    private static final BigDecimal RENTGEN_PRICE = new BigDecimal(600).setScale(2, RoundingMode.HALF_UP);
    private boolean isChild;

    public RentgenService(User user) throws NullUserException, IncorrectUserAgeException {
        super(user);
        setChild();
        this.total = calculateTotal();
    }

    public boolean getChild() {
        return isChild;
    }

    public void setUser(User user) throws IncorrectUserAgeException, NullUserException {
        if (user == null) throw new NullUserException();
        this.user = user;
        setChild();
        this.total = calculateTotal();
    }

    @Override
    public BigDecimal getDiscount() {
        return isChild
                ? RENTGEN_PRICE.multiply(BigDecimal.valueOf(0.4)).setScale(2, RoundingMode.HALF_UP)
                : new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotal() {
        return RENTGEN_PRICE.subtract(getDiscount()).setScale(2, RoundingMode.HALF_UP);
    }

    private void setChild() throws IncorrectUserAgeException {
        if (getUser().getAge() < 0) throw new IncorrectUserAgeException(getUser().getAge());
        if (getUser().getAge() < 18) isChild = true;
    }

    @Override
    public String toString() {
        return String.format("%s %s, age: %d - Rentgen, cost: %s, discount: %s", user.getSurname(), user.getName(), user.getAge(), total, getDiscount());
    }
}
