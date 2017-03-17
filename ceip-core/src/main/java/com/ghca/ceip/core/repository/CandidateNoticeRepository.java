package com.ghca.ceip.core.repository;

import com.ghca.ceip.core.model.CandidateNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * Created by gh on 2017/3/16.
 */
public interface CandidateNoticeRepository extends JpaRepository<CandidateNotice, String> {
}
