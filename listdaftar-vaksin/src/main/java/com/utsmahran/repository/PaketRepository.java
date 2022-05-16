package com.utsmahran.repository;

import com.utsmahran.entity.Vaksin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaketRepository extends JpaRepository<Vaksin, Long> {
    Optional<Vaksin> findByEmail(String email);
}
