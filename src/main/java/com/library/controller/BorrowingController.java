package com.library.controller;

import com.library.model.dto.BorrowingDTO;
import com.library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/register")
    public ResponseEntity<BorrowingDTO> registerBorrowing(@RequestBody BorrowingDTO borrowingDTO) {
        BorrowingDTO savedBorrowing = borrowingService.registerBorrowing(borrowingDTO);
        return new ResponseEntity<>(savedBorrowing, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingDTO> getBorrowingById(@PathVariable Long id) {
        BorrowingDTO borrowingDTO = borrowingService.getBorrowingById(id);
        return borrowingDTO != null ? ResponseEntity.ok(borrowingDTO) : ResponseEntity.notFound().build();
    }
}
