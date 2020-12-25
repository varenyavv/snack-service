package com.dla.snackservice.controller;

import com.dla.snackservice.model.Snack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SnackControllerTest {

    @InjectMocks
    SnackController snackController;

    @Test
    void testGetSnack_Eclair() {
        Snack actual = snackController.getSnackById(1);

        assertEquals("Eclairs", actual.getName());
    }

    @Test
    void testGetSnack_Kitkat() {
        Snack actual = snackController.getSnackById(3);

        assertEquals("kitkat", actual.getName());
    }

}
