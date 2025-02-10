package ru.aston.dvorianchykov_sa.task1.Services;

import ru.aston.dvorianchykov_sa.task1.Interfaces.ServiceCalculation;
import ru.aston.dvorianchykov_sa.task1.Models.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

public class UserServiceList implements ServiceCalculation {

    private List<Service> serviceList;

    public UserServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public BigDecimal calculateTotalServicePrice() {
        if (serviceList == null || serviceList.isEmpty()) return new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal[] sum = {new BigDecimal(0)};
        serviceList.forEach(service -> sum[0] = sum[0].add(service.getTotal()));
        return sum[0].setScale(2, RoundingMode.HALF_UP);
    }

    public List<Service> sortServices() {
        serviceList.sort(new UserServiceComparator());
        return serviceList;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (serviceList == null || serviceList.isEmpty()) return "";
        StringBuilder stringBuilder = new StringBuilder("Total price: ").append(calculateTotalServicePrice().toString());
        serviceList.forEach(service -> stringBuilder.append("\n").append(service));
        return stringBuilder.toString();
    }
}
