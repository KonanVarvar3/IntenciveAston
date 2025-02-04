package Services;

import Interfaces.ServiceCalculation;

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
        BigDecimal sum = new BigDecimal(0);
        for (Service service : serviceList) {
            sum = sum.add(service.getTotal());
        }
        return sum.setScale(2, RoundingMode.HALF_UP);
    }

    public List<Service> sortServices() {
        Collections.sort(serviceList);
        return serviceList;
    }

    @Override
    public String toString() {
        if (serviceList == null || serviceList.isEmpty()) return "";
        StringBuilder stringBuilder = new StringBuilder("Total price: ").append(calculateTotalServicePrice().toString());
        for (Service service : serviceList) {
            stringBuilder.append("\n").append(service);
        }
        return stringBuilder.toString();
    }
}
