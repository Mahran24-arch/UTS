package com.utsmahran.service.framework;

import com.utsmahran.entity.Vaksin;

import java.util.List;
import java.util.Optional;

public interface PaketService {
    List<Vaksin> getAllPakets();

    Optional<Vaksin> findById(Long id);

    Optional<Vaksin> findByEmail(String email);

    Vaksin save(Vaksin std);

    void deleteById(Long id);
}
