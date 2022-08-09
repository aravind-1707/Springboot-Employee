package com.practical.demo.Repository;

import com.practical.demo.Entity.VerifcationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerifcationToken,Long> {
}
