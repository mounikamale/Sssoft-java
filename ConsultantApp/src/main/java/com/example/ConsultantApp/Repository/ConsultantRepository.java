package com.example.ConsultantApp.Repository;

import com.example.ConsultantApp.Entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository <Consultant, Long>{
}
