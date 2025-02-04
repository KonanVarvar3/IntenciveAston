import Exceptions.IncorrectUserAgeException;
import Exceptions.NullUserException;
import Models.User;
import Services.RentgenService;
import Services.Service;
import Services.ToothExtractionService;
import Services.UserServiceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserServiceListTest {

    private User nik = new User("Nik", "Dobronravov", 10);
    private User ivan = new User("Ivan", "Naumov", 19);
    private User dzhon = new User("Dzhon", "Abaimov", 24);
    private User alexander = new User("Alexander", "Skvorcov", 48);

    @BeforeEach
    public void setUp() {
        nik = new User("Nik", "Dobronravov", 10);
        ivan = new User("Ivan", "Naumov", 19);
        dzhon = new User("Dzhon", "Abaimov", 24);
        alexander = new User("Alexander", "Skvorcov", 48);
    }

    @Test
    public void getTotalPrice() throws NullUserException, IncorrectUserAgeException {
        RentgenService rentgenService1 = new RentgenService(nik);
        RentgenService rentgenService2 = new RentgenService(ivan);

        ToothExtractionService toothExtractionService1 = new ToothExtractionService(dzhon, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, true);
        ToothExtractionService toothExtractionService2 = new ToothExtractionService(alexander, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, false);

        List<Service> serviceList = new ArrayList<>();
        serviceList.add(rentgenService1);
        serviceList.add(rentgenService2);
        serviceList.add(toothExtractionService1);
        serviceList.add(toothExtractionService2);
        UserServiceList userServiceList = new UserServiceList(serviceList);

        BigDecimal expected = userServiceList.calculateTotalServicePrice();
        BigDecimal actual = new BigDecimal("3810.00");
        Assertions.assertEquals(expected, actual);
    }
}
