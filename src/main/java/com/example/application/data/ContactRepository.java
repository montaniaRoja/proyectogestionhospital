package com.example.application.data;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<SamplePerson, Long> {

}
