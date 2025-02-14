package task1;

import ru.aston.dvorianchykov_sa.task1.Services.ToothExtractionService;
import org.junit.jupiter.api.*;
import ru.aston.dvorianchykov_sa.task1.constants.Procedures;

import java.math.BigDecimal;

class ToothExtractionServiceTest {

    private ToothExtractionService toothExtractionService;
    private ToothExtractionService toothExtractionService2;

    @BeforeEach
    public void setUp() throws ru.aston.dvorianchykov_sa.task1.exceptions.NullUserException {
        ru.aston.dvorianchykov_sa.task1.Models.User dzhon = new ru.aston.dvorianchykov_sa.task1.Models.User("Dzhon", "Abaimov", 24);
        ru.aston.dvorianchykov_sa.task1.Models.User alexander = new ru.aston.dvorianchykov_sa.task1.Models.User("Alexander", "Skvorcov", 48);

        toothExtractionService = new ToothExtractionService(dzhon, Procedures.MORAL_TOOTH_EXTRACTION, true);
        toothExtractionService2 = new ToothExtractionService(alexander, Procedures.MORAL_TOOTH_EXTRACTION, false);
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
