package ru.aston.dvorianchykov_sa.task1;

import ru.aston.dvorianchykov_sa.task1.exceptions.IncorrectUserAgeException;
import ru.aston.dvorianchykov_sa.task1.exceptions.NullUserException;
import ru.aston.dvorianchykov_sa.task1.Models.User;
import ru.aston.dvorianchykov_sa.task1.Services.RentgenService;
import ru.aston.dvorianchykov_sa.task1.Services.ToothExtractionService;
import ru.aston.dvorianchykov_sa.task1.constants.Procedures;

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

        ToothExtractionService toothExtractionService1 = new ToothExtractionService(dzhon, Procedures.MORAL_TOOTH_EXTRACTION, true);
        ToothExtractionService toothExtractionService2 = new ToothExtractionService(alexander, Procedures.MORAL_TOOTH_EXTRACTION, false);

        List<ru.aston.dvorianchykov_sa.task1.Services.Service> serviceList = new ArrayList<>();
        serviceList.add(rentgenService1);
        serviceList.add(rentgenService2);
        serviceList.add(toothExtractionService1);
        serviceList.add(toothExtractionService2);

        ru.aston.dvorianchykov_sa.task1.Services.UserServiceList userServiceList = new ru.aston.dvorianchykov_sa.task1.Services.UserServiceList(serviceList);

        userServiceList.print();

        userServiceList.sortServices();

        userServiceList.print();

    }

}
