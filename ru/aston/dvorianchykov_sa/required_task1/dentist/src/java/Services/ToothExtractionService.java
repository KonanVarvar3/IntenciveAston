package Services;

import Exceptions.NullUserException;
import Models.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public class ToothExtractionService extends Service {

    private Procedures procedure;
    private boolean isStudent;

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
        return String.format("%s %s, age: %d - %s, cost: %s, discount: %s", user.getSurname(), user.getName(), user.getAge(), procedure.getName(), total, getDiscount());
    }
}
