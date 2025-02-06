import Exceptions.IncorrectUserAgeException;
import Exceptions.NullUserException;
import Models.User;
import Services.RentgenService;
import Services.Service;
import Services.ToothExtractionService;
import Services.UserServiceList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NullUserException, IncorrectUserAgeException {

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

        UserServiceList userServiceList = new UserServiceList(serviceList);

        //System.out.println(userServiceList);

        userServiceList.sortServices();

        System.out.println(userServiceList);
    }

}
