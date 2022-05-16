package com.utsmahran.controller;

import com.utsmahran.entity.Vaksin;
import com.utsmahran.exception.PaketNotFoundException;
import com.utsmahran.service.framework.PaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/vaksinns")
public class PaketController {
    private final PaketService paketservice;

    @Autowired
    public PaketController(PaketService paketservice) {
        this.paketservice = paketservice;
    }

    @GetMapping
    public List<Vaksin> getAllPakets() {
        return paketservice.getAllPakets();
    }

    @GetMapping(value = "/{id}")
    public Vaksin getStudentById(@PathVariable("id") @Min(1) Long id) {
        Vaksin std = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Vaksin addPaket(@Valid @RequestBody Vaksin std) {
        return paketservice.save(std);
    }

    @PutMapping(value = "/{id}")
    public Vaksin updatePaket(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Vaksin newStd) {
        Vaksin vaksin = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        vaksin.setFirstName(newStd.getFirstName());
        vaksin.setLastName(newStd.getLastName());
        vaksin.setEmail(newStd.getEmail());
        vaksin.setPhoneNumber(newStd.getPhoneNumber());
        return paketservice.save(vaksin);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        Vaksin std = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        paketservice.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}
