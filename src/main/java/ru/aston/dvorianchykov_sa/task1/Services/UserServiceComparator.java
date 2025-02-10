package ru.aston.dvorianchykov_sa.task1.Services;

import java.util.Comparator;

public class UserServiceComparator implements Comparator<Service> {
    @Override
    public int compare(Service s1, Service s2) {
        if (s1 == null || s1.getUser() == null) return -1;
        if (s2 == null || s2.getUser() == null) return 1;
        return s1.getUser().compareTo(s2.getUser());
    }
}
