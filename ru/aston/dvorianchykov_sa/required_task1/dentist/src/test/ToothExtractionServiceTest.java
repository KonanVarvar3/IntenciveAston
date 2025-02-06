import Exceptions.NullUserException;
import Models.User;
import Services.ToothExtractionService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

class ToothExtractionServiceTest {

    private ToothExtractionService toothExtractionService;
    private ToothExtractionService toothExtractionService2;

    @BeforeEach
    public void setUp() throws NullUserException {
        User dzhon = new User("Dzhon", "Abaimov", 24);
        User alexander = new User("Alexander", "Skvorcov", 48);

        toothExtractionService = new ToothExtractionService(dzhon, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, true);
        toothExtractionService2 = new ToothExtractionService(alexander, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, false);
    }

    @Test
    public void getDiscountWhenStudentIsTrue() {
        BigDecimal expected = toothExtractionService.getDiscount();
        BigDecimal actual = new BigDecimal("150.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTotalWhenStudentIsTrue() {
        BigDecimal expected = toothExtractionService.calculateTotal();
        BigDecimal actual = new BigDecimal("1350.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDiscountWhenStudentIsFalse() {
        BigDecimal expected = toothExtractionService2.getDiscount();
        BigDecimal actual = new BigDecimal("0.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTotalWhenStudentIsFalse() {
        BigDecimal expected = toothExtractionService2.calculateTotal();
        BigDecimal actual = new BigDecimal("1500.00");
        Assertions.assertEquals(expected, actual);
    }

}
