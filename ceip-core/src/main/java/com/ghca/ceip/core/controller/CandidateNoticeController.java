package com.ghca.ceip.core.controller;

import com.ghca.ceip.core.model.CandidateNotice;
import com.ghca.ceip.core.repository.CandidateNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gh on 2017/3/16.
 */

@RestController()
public class CandidateNoticeController {

    @Autowired
    private CandidateNoticeRepository candidateNoticeRepository;

    @PutMapping("/candidatenotice")
    public void save(@RequestBody List<CandidateNotice> candidateNotices) {
        candidateNoticeRepository.save(candidateNotices);
    }

    @PostMapping("/test")
    public String test(@RequestBody String value) {
        return "hello"+value;
    }
}
