package com.example.LibraryService.controller;

import com.example.LibraryService.dto.LibraryRecordDTO;
import com.example.LibraryService.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<LibraryRecordDTO> getAllLibraryRecords() {
        return libraryService.getAllLibraryRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryRecordDTO> getLibraryRecordById(@PathVariable Long id) {
        Optional<LibraryRecordDTO> libraryRecordDTO = libraryService.getLibraryRecordById(id);
        return libraryRecordDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LibraryRecordDTO> createLibraryRecord(@RequestBody LibraryRecordDTO libraryRecordDTO) {
        LibraryRecordDTO createdRecord = libraryService.createLibraryRecord(libraryRecordDTO);
        return ResponseEntity.ok(createdRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryRecordDTO> updateLibraryRecord(@PathVariable Long id, @RequestBody LibraryRecordDTO libraryRecordDTO) {
        Optional<LibraryRecordDTO> updatedRecord = libraryService.updateLibraryRecord(id, libraryRecordDTO);
        return updatedRecord.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryRecord(@PathVariable Long id) {
        libraryService.deleteLibraryRecord(id);
        return ResponseEntity.noContent().build();
    }
}
