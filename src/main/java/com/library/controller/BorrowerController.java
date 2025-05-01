package com.library.controller;

import com.library.model.dto.BorrowerDTO;
import com.library.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping("/register")
    public ResponseEntity<BorrowerDTO> registerBorrower(@RequestBody BorrowerDTO borrowerDTO) {
        BorrowerDTO savedBorrower = borrowerService.registerBorrower(borrowerDTO);
        return new ResponseEntity<>(savedBorrower, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowerDTO> getBorrowerById(@PathVariable Long id) {
        BorrowerDTO borrowerDTO = borrowerService.getBorrowerById(id);
        return borrowerDTO != null ? ResponseEntity.ok(borrowerDTO) : ResponseEntity.notFound().build();
    }
}
