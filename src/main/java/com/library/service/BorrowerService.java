package com.library.service;

import com.library.model.dto.BorrowerDTO;
import com.library.model.entity.Borrower;
import com.library.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    public BorrowerDTO registerBorrower(BorrowerDTO borrowerDTO) {
        Borrower borrower = new Borrower();
        borrower.setName(borrowerDTO.getName());
        Borrower savedBorrower = borrowerRepository.save(borrower);
        return new BorrowerDTO(savedBorrower.getId(), savedBorrower.getName());
    }

    public BorrowerDTO getBorrowerById(Long id) {
        return borrowerRepository.findById(id)
                .map(borrower -> new BorrowerDTO(borrower.getId(), borrower.getName()))
                .orElse(null);
    }
}

