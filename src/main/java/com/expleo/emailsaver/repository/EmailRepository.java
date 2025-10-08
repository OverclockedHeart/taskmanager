package com.expleo.emailsaver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expleo.emailsaver.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
