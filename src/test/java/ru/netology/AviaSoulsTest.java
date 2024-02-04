package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class AviaSoulsTest {

    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 600, 12, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 20, 21);
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 9, 10);
        Ticket ticket4 = new Ticket("UFA", "SPB", 350, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SOCHI", 400, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 150, 4, 5);
        Ticket ticket7 = new Ticket("MSK", "SPB", 300, 12, 13);
        Ticket ticket8 = new Ticket("MSK", "SPB", 250, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket6, ticket8, ticket7, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 600, 12, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 20, 21);
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 9, 10);
        Ticket ticket4 = new Ticket("UFA", "SPB", 350, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SOCHI", 400, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 150, 4, 5);
        Ticket ticket7 = new Ticket("MSK", "SPB", 300, 12, 13);
        Ticket ticket8 = new Ticket("MSK", "SPB", 250, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SOCHI");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 600, 12, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 20, 21);
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 9, 10);
        Ticket ticket4 = new Ticket("UFA", "SPB", 350, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SOCHI", 400, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 150, 4, 5);
        Ticket ticket7 = new Ticket("MSK", "SPB", 300, 12, 13);
        Ticket ticket8 = new Ticket("MSK", "SPB", 250, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "LA");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 600, 12, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 19, 23);//4
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 9, 10);//1
        Ticket ticket4 = new Ticket("UFA", "SPB", 350, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SOCHI", 400, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 150, 4, 9);//5
        Ticket ticket7 = new Ticket("MSK", "SPB", 300, 12, 14);//2
        Ticket ticket8 = new Ticket("MSK", "SPB", 250, 7, 10);//3

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket3, ticket7, ticket8, ticket2, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 600, 12, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 19, 23);//4
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 9, 10);//1
        Ticket ticket4 = new Ticket("UFA", "SPB", 350, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SOCHI", 400, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 150, 4, 9);//5
        Ticket ticket7 = new Ticket("MSK", "SPB", 300, 12, 14);//2
        Ticket ticket8 = new Ticket("MSK", "SPB", 250, 7, 10);//3

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("UFA", "SPB", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 600, 12, 15);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 19, 23);//4
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 9, 10);//1
        Ticket ticket4 = new Ticket("UFA", "SPB", 350, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SOCHI", 400, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 150, 4, 9);//5
        Ticket ticket7 = new Ticket("MSK", "SPB", 300, 12, 14);//2
        Ticket ticket8 = new Ticket("MSK", "SPB", 250, 7, 10);//3

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "LA", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


}
