package pl.plenczewski.backjwttest.controller;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class TicketPriorityConstrollerTest {

      @Spy
    TicketPriorityConstroller ticketPriorityConstroller;

        @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllTicketPriority() {
        Assert.assertEquals(ticketPriorityConstroller.getAllTicketPriority().length,3);
    }
}
