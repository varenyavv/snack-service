package com.dla.snackservice.service;

import com.dla.snackservice.dto.SnackDto;
import com.dla.snackservice.model.Snack;
import com.dla.snackservice.repository.SnackRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackService {

    @Autowired
    SnackRepository snackRepository;

    public Snack createSnack(SnackDto snackDto) {
        Snack snack = new Snack(snackDto.getName());
        return snackRepository.save(snack);
    }

    public Snack getSnackById(Integer id){

       Optional<Snack> retrievedSnack =  snackRepository.findById(id);

       if(!retrievedSnack.isPresent()) {
           throw new RuntimeException(String.format("Snack of id %d not found", id));
       }

       return retrievedSnack.get();
    }

    public List<Snack> getAllSnacks() {
        return snackRepository.findAll();
    }
}
