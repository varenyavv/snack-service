package com.dla.snackservice.controller;

import com.dla.snackservice.dto.SnackDto;
import com.dla.snackservice.model.Snack;
import com.dla.snackservice.service.SnackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnackController {

  @Autowired
  SnackService snackService;

  @GetMapping(path = "snacks/{snackId}")
  public Snack getSnackById(@PathVariable("snackId") Integer id) {
    //    if (1 == id) {
    //      return new Snack("Eclairs");
    //    }
    //
    //    return new Snack("kitkat");
    return snackService.getSnackById(id);
  }

  @GetMapping(path = "snacks")
  public List<Snack> getAllSnacks() {
    return snackService.getAllSnacks();
  }

  @PostMapping(path = "snacks")
  public Snack createSnack(@RequestBody SnackDto snackDto) {
    return snackService.createSnack(snackDto);
  }
}
