package ru.ladies.objects.ladiesentryfree.exceptions;

import org.hibernate.service.spi.ServiceException;

public class SolutionNotFoundException extends ServiceException {
    public SolutionNotFoundException(String message) {
        super(message);
    }
}
