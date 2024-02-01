package ru.netology.avia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Moscow", "Tokio", 45000, 5, 23);
    Ticket ticket2 = new Ticket("Moscow", "Tokio", 60000, 10, 21);
    Ticket ticket3 = new Ticket("Moscow", "Seoul", 30000, 5, 17);
    Ticket ticket4 = new Ticket("Moscow", "New York", 30000, 8, 20);

    @Test
    public void shouldCompareTicketsByPrice() {

        int expectedMore = 1;
        int actualMore = ticket1.compareTo(ticket3);
        int expectedLess = -1;
        int actualLess = ticket1.compareTo(ticket2);
        int expectedEqual = 0;
        int actualEqual = ticket3.compareTo(ticket4);

        Assertions.assertEquals(expectedMore, actualMore);
        Assertions.assertEquals(expectedLess, actualLess);
        Assertions.assertEquals(expectedEqual, actualEqual);

    }

    @Test
    public void shouldSearchTicketsAndSortByPrice() {

        AviaSouls service = new AviaSouls();

        service.add(ticket2);
        service.add(ticket1);
        service.add(ticket3);

        Ticket[] ticketsActual = service.search("Moscow", "Tokio");
        Ticket[] ticketsExpected = {ticket1, ticket2};

        Assertions.assertArrayEquals(ticketsExpected, ticketsActual);

    }

    @Test
    public void shouldCompareTicketsByTime() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expectedMore = 1;
        int actualMore = comparator.compare(ticket1, ticket2);
        int expectedLess = -1;
        int actualLess = comparator.compare(ticket2, ticket3);
        int expectedEqual = 0;
        int actualEqual = comparator.compare(ticket3, ticket4);


        Assertions.assertEquals(expectedMore, actualMore);
        Assertions.assertEquals(expectedLess, actualLess);
        Assertions.assertEquals(expectedEqual, actualEqual);

    }

    @Test
    public void shouldSearchTicketsAndSortByTime() {

        TicketTimeComparator comparator = new TicketTimeComparator();
        AviaSouls service = new AviaSouls();

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);

        Ticket[] ticketsActual = service.searchAndSortBy("Moscow", "Tokio", comparator);
        Ticket[] ticketsExpected = {ticket2, ticket1};

        Assertions.assertArrayEquals(ticketsExpected, ticketsActual);

    }

    @Test
    public void shouldNotFindTicketsBySearch() {

        TicketTimeComparator comparator = new TicketTimeComparator();
        AviaSouls service = new AviaSouls();

        service.add(ticket2);
        service.add(ticket1);
        service.add(ticket3);
        service.add(ticket4);

        Ticket[] ticketsActualSearch = service.search("Tokio", "Moscow");
        Ticket[] ticketsExpectedSearch = {};

        Ticket[] ticketsActualSearchAndSort = service.searchAndSortBy("Seoul", "Tokio", comparator);
        Ticket[] ticketsExpectedSearchAndSort = {};

        Assertions.assertArrayEquals(ticketsExpectedSearch, ticketsActualSearch);
        Assertions.assertArrayEquals(ticketsExpectedSearchAndSort, ticketsActualSearchAndSort);

    }

}
