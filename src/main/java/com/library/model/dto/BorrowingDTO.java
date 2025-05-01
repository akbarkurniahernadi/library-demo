package com.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDTO {
    private Long id;
    private Long borrowerId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}