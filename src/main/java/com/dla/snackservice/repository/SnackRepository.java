package com.dla.snackservice.repository;

import com.dla.snackservice.model.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackRepository extends JpaRepository<Snack, Integer> {
}
