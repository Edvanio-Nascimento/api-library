package com.edy.course.library.dto;

import com.edy.course.library.entity.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AuthorRequest(

        @NotBlank(message = "O campo nome não pode ser nulo")
        @Size(max = 70, message = "Máximo de 70 caracteres")
        String name,

        @PastOrPresent(message = "A data de nascimento deve ser no passado ou presente")
        @NotNull(message = "O campo data de nascimento é obrigatório")
        LocalDate dateBirth,

        @NotBlank(message = "O campo nacionalidade não pode ser nulo")
        @Size(max = 50, message = "Máximo de 50 caracteres")
        String nacionality
) {

}
