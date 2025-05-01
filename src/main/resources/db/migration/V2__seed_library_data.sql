-- Seed Authors
INSERT INTO authors (name) VALUES
    ('J.K. Rowling'),
    ('George Orwell'),
    ('Haruki Murakami');

-- Seed Books
INSERT INTO books (title, publication_year, author_id) VALUES
    ('Harry Potter and the Philosopher''s Stone', 1997, 1),
    ('1984', 1949, 2),
    ('Kafka on the Shore', 2002, 3);

-- Seed Borrowers
INSERT INTO borrowers (name) VALUES
    ('Alice'),
    ('Bob'),
    ('Charlie');

-- Seed Borrowings
INSERT INTO borrowings (borrower_id, book_id, borrow_date, return_date) VALUES
    (1, 1, '2025-04-20', '2025-04-27'),
    (2, 2, '2025-04-25', NULL),
    (3, 3, '2025-04-28', NULL);
