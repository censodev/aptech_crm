package com.aptech.usm.data.repositories;

import com.aptech.usm.data.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByAccountId(Long accountId);

    List<Student> findByIdIn(Collection<Long> id);
}
