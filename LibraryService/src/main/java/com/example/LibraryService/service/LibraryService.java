package com.example.LibraryService.service;

import com.example.LibraryService.dto.LibraryRecordDTO;
import com.example.LibraryService.mapper.LibraryRecordMapper;
import com.example.LibraryService.model.LibraryRecord;
import com.example.LibraryService.repository.LibraryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    @Autowired
    private LibraryRecordRepository libraryRecordRepository;

    public List<LibraryRecordDTO> getAllLibraryRecords() {
        return libraryRecordRepository.findAll().stream()
                .map(LibraryRecordMapper.INSTANCE::libraryRecordToLibraryRecordDTO)
                .collect(Collectors.toList());
    }

    public Optional<LibraryRecordDTO> getLibraryRecordById(Long id) {
        return libraryRecordRepository.findById(id)
                .map(LibraryRecordMapper.INSTANCE::libraryRecordToLibraryRecordDTO);
    }

    public LibraryRecordDTO createLibraryRecord(LibraryRecordDTO libraryRecordDTO) {
        LibraryRecord libraryRecord = LibraryRecordMapper.INSTANCE.libraryRecordDTOToLibraryRecord(libraryRecordDTO);
        LibraryRecord savedLibraryRecord = libraryRecordRepository.save(libraryRecord);
        return LibraryRecordMapper.INSTANCE.libraryRecordToLibraryRecordDTO(savedLibraryRecord);
    }

    public Optional<LibraryRecordDTO> updateLibraryRecord(Long id, LibraryRecordDTO libraryRecordDTO) {
        return libraryRecordRepository.findById(id).map(existingRecord -> {
            existingRecord.setBookId(libraryRecordDTO.getBookId());
            existingRecord.setBorrowedAt(libraryRecordDTO.getBorrowedAt());
            existingRecord.setReturnBy(libraryRecordDTO.getReturnBy());
            LibraryRecord updatedLibraryRecord = libraryRecordRepository.save(existingRecord);
            return LibraryRecordMapper.INSTANCE.libraryRecordToLibraryRecordDTO(updatedLibraryRecord);
        });
    }

    public void deleteLibraryRecord(Long id) {
        libraryRecordRepository.deleteById(id);
    }
}
