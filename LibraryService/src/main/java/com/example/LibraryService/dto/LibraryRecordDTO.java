package com.example.LibraryService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LibraryRecordDTO {
    private Long id;
    private Long bookId;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnBy;
}
