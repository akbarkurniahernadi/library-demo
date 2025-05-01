package com.library.service;

import com.library.model.dto.AuthorDTO;
import com.library.model.entity.Author;
import com.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDTO registerAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        Author savedAuthor = authorRepository.save(author);
        return new AuthorDTO(savedAuthor.getId(), savedAuthor.getName());
    }

    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(author -> new AuthorDTO(author.getId(), author.getName()))
                .orElse(null);
    }
}
