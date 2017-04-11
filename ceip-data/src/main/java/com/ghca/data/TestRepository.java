package com.ghca.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gh on 2017/4/11.
 */
@Repository
public interface TestRepository extends JpaRepository<TestEntity, String> {
}
