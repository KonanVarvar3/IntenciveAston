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

    UserServiceList userServiceList;

    @BeforeEach
    public void setUp() throws NullUserException, IncorrectUserAgeException {
        User nik = new User("Nik", "Dobronravov", 10);
        User ivan = new User("Ivan", "Naumov", 19);
        User dzhon = new User("Dzhon", "Abaimov", 24);
        User alexander = new User("Alexander", "Skvorcov", 48);

        RentgenService rentgenService1 = new RentgenService(nik);
        RentgenService rentgenService2 = new RentgenService(ivan);
        ToothExtractionService toothExtractionService1 = new ToothExtractionService(dzhon, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, true);
        ToothExtractionService toothExtractionService2 = new ToothExtractionService(alexander, ToothExtractionService.Procedures.MORAL_TOOTH_EXTRACTION, false);

        List<Service> serviceList = new ArrayList<>();
        serviceList.add(rentgenService1);
        serviceList.add(rentgenService2);
        serviceList.add(toothExtractionService1);
        serviceList.add(toothExtractionService2);

        userServiceList = new UserServiceList(serviceList);
    }

    @Test
    public void getTotalPrice(){
        BigDecimal expected = userServiceList.calculateTotalServicePrice();
        BigDecimal actual = new BigDecimal("3810.00");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortServices(){
        List<Service> serviceList = userServiceList.sortServices();

        String expected1 = serviceList.get(0).getUser().getSurname();
        String expected2 = serviceList.get(1).getUser().getSurname();
        String expected3 = serviceList.get(2).getUser().getSurname();
        String expected4 = serviceList.get(3).getUser().getSurname();

        String actual1 = "Abaimov";
        String actual2 = "Dobronravov";
        String actual3 = "Naumov";
        String actual4 = "Skvorcov";

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
        Assertions.assertEquals(expected4, actual4);
    }
}
