package com.edy.course.library.dto;



import java.time.LocalDate;

public record AuthorResponse(

        String name,

        LocalDate dateBirth,

        String nacionality
) {
}
