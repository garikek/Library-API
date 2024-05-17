package com.example.LibraryService.repository;

import com.example.LibraryService.model.LibraryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRecordRepository extends JpaRepository<LibraryRecord, Long> {
}
