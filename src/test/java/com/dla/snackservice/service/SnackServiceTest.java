package com.dla.snackservice.service;

import com.dla.snackservice.dto.SnackDto;
import com.dla.snackservice.model.Snack;
import com.dla.snackservice.repository.SnackRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SnackServiceTest {

    @Mock
    SnackRepository snackRepository;

    @InjectMocks
    SnackService snackService;

    @Test
    void testCreateSnack() {
        SnackDto snackDto = new SnackDto();
        snackDto.setName("ASDF");
        Snack snack = new Snack("ASDF");
        when(snackRepository.save(any())).thenReturn(snack);
        Snack actualSnack = snackService.createSnack(snackDto);

        assertEquals("ASDF",actualSnack.getName());
    }

    @Test
    void testGetSnack_snackNotFound() {

        when(snackRepository.findById(1)).thenReturn(Optional.empty());

        RuntimeException actualException = assertThrows(RuntimeException.class, () -> snackService.getSnackById(1));
        assertEquals("Snack of id 1 not found", actualException.getMessage());

    }
}
