package ru.netology.avia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {

    Ticket ticket1 = new Ticket("Moscow", "Tokio", 45000, 12, 23);
    Ticket ticket3 = new Ticket("Moscow", "Seoul", 30000, 5, 17);

    @Test
    public void shouldCompareByPrice() {
        int expected = 1;
        int actual = ticket1.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }
}
