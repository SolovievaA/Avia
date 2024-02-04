package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;
public class TicketTimeComparatorTest {
    @Test
    public void testComparatorFirstMore() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 4, 5);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 17);

        int expected = comparator.compare(ticket1, ticket2);
        Assertions.assertTrue(expected < 0);

    }
    @Test
    public void testComparatorSecondMore() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 4, 9);
        Ticket ticket2 = new Ticket("MSK", "SPB", 300, 12, 13);

        int expected = comparator.compare(ticket1, ticket2);
        Assertions.assertTrue(expected > 0);

    }

}
