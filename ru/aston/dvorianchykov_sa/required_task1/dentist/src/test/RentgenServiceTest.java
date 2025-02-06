import Exceptions.IncorrectUserAgeException;
import Exceptions.NullUserException;
import Models.User;
import Services.RentgenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class RentgenServiceTest {

    RentgenService rentgenService;
    RentgenService rentgenService2;

    @BeforeEach
    public void setUp() throws NullUserException, IncorrectUserAgeException {
        User nik = new User("Nik", "Dobronravov", 10);
        User ivan = new User("Ivan", "Naumov", 19);

        rentgenService = new RentgenService(nik);
        rentgenService2 = new RentgenService(ivan);
    }

    @Test
    public void getDiscountWhenUserIsChild() {
        BigDecimal expected = rentgenService.getDiscount();
        BigDecimal actual = new BigDecimal("240.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTotalWhenUserIsChild() {
        BigDecimal expected = rentgenService.calculateTotal();
        BigDecimal actual = new BigDecimal("360.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDiscountWhenUserIsNotChild() {
        BigDecimal expected = rentgenService2.getDiscount();
        BigDecimal actual = new BigDecimal("0.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTotalWhenUserIsNotChild() {
        BigDecimal expected = rentgenService2.calculateTotal();
        BigDecimal actual = new BigDecimal("600.00");
        Assertions.assertEquals(expected, actual);
    }
}
