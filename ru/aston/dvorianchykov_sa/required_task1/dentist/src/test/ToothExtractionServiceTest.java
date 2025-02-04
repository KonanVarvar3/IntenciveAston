import Exceptions.NullUserException;
import Models.User;
import Services.ToothExtractionService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

class ToothExtractionServiceTest {

    private User dzhon = new User("Dzhon", "Abaimov", 24);

    @BeforeEach
    public void setUp() {
        dzhon = new User("Dzhon", "Abaimov", 24);
    }

    @Test
    public void getDiscountWhenStudentIsTrue() throws NullUserException {
        ToothExtractionService toothExtractionService = new ToothExtractionService(dzhon, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, true);
        BigDecimal expected = toothExtractionService.getDiscount();
        BigDecimal actual = new BigDecimal(150).setScale(2, RoundingMode.HALF_UP);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDiscountWhenStudentIsFalse() throws NullUserException {
        ToothExtractionService toothExtractionService = new ToothExtractionService(dzhon, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, false);
        BigDecimal expected2 = toothExtractionService.getDiscount();
        BigDecimal actual2 = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        Assertions.assertEquals(expected2, actual2);
    }

}
