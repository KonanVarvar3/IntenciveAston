import Exceptions.IncorrectUserAgeException;
import Exceptions.NullUserException;
import Models.User;
import Services.RentgenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class RentgenServiceTest {

    private User nik = new User("Nik", "Dobronravov", 10);
    private User ivan = new User("Ivan", "Naumov", 19);

    @BeforeEach
    public void setUp() {
        nik = new User("Nik", "Dobronravov", 10);
        ivan = new User("Ivan", "Naumov", 19);
    }

    @Test
    public void getDiscountWhenUserIsChild() throws NullUserException, IncorrectUserAgeException {
        RentgenService rentgenService = new RentgenService(nik);
        BigDecimal expected = rentgenService.getDiscount();
        BigDecimal actual = new BigDecimal("240.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDiscountWhenUserIsNotChild() throws NullUserException, IncorrectUserAgeException {
        RentgenService rentgenService = new RentgenService(ivan);
        BigDecimal expected = rentgenService.getDiscount();
        BigDecimal actual = new BigDecimal("0.00");
        Assertions.assertEquals(expected, actual);
    }
}
