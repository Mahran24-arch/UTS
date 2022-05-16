package com.utsmahran.service.implementation;

import com.utsmahran.entity.Vaksin;
import com.utsmahran.repository.PaketRepository;
import com.utsmahran.service.framework.PaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaketServiceImpl implements PaketService {
    private final PaketRepository paketRepository;

    @Autowired
    public PaketServiceImpl(PaketRepository paketRepository){
        this.paketRepository = paketRepository;
    }

    @Override
    public Optional<Vaksin> findByEmail(String email) {

        return paketRepository.findByEmail(email);
    }

    @Override
    public List<Vaksin> getAllPakets() {
        return paketRepository.findAll();
    }

    @Override
    public Optional<Vaksin> findById(Long id) {

        return paketRepository.findById(id);
    }



    @Override
    public Vaksin save(Vaksin std) {

        return paketRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {

        paketRepository.deleteById(id);
    }
}
