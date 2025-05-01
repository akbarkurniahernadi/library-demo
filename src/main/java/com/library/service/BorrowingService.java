package com.library.service;

import com.library.model.dto.BorrowingDTO;
import com.library.model.entity.Borrowing;
import com.library.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    public BorrowingDTO registerBorrowing(BorrowingDTO borrowingDTO) {
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrowerId(borrowingDTO.getBorrowerId());
        borrowing.setBookId(borrowingDTO.getBookId());
        borrowing.setBorrowDate(borrowingDTO.getBorrowDate());
        borrowing.setReturnDate(borrowingDTO.getReturnDate());
        Borrowing savedBorrowing = borrowingRepository.save(borrowing);
        return new BorrowingDTO(savedBorrowing.getId(), savedBorrowing.getBorrowerId(), savedBorrowing.getBookId(), savedBorrowing.getBorrowDate(), savedBorrowing.getReturnDate());
    }

    public BorrowingDTO getBorrowingById(Long id) {
        return borrowingRepository.findById(id)
                .map(borrowing -> new BorrowingDTO(borrowing.getId(), borrowing.getBorrowerId(), borrowing.getBookId(), borrowing.getBorrowDate(), borrowing.getReturnDate()))
                .orElse(null);
    }
}

