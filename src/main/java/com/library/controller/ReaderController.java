package com.library.controller;

import com.library.domain.ReaderDto;
import com.library.mapper.Mapper;
import com.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/reader")
public class ReaderController {
    @Autowired
    private DbService dbService;
    @Autowired
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return mapper.mapToReaderDtoList(dbService.getAllReader());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDto getReader(@RequestParam int id) throws ReaderNotFoundException {
        return mapper.mapToReaderDto(dbService.findReaderById(id).orElseThrow(mapper::createReaderException));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateReader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return mapper.mapToReaderDto(dbService.saveReader(mapper.mapToReader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        dbService.saveReader(mapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReader")
    public void deleteReader(@RequestParam int id) {
        dbService.deleteReader(id);
    }
}
