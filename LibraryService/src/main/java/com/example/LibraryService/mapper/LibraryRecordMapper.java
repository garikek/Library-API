package com.example.LibraryService.mapper;

import com.example.LibraryService.dto.LibraryRecordDTO;
import com.example.LibraryService.model.LibraryRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibraryRecordMapper {
    LibraryRecordMapper INSTANCE = Mappers.getMapper(LibraryRecordMapper.class);

    LibraryRecordDTO libraryRecordToLibraryRecordDTO(LibraryRecord libraryRecord);
    LibraryRecord libraryRecordDTOToLibraryRecord(LibraryRecordDTO libraryRecordDTO);
}
