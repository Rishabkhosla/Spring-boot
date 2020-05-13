package com.example.demo.repository;

import com.example.demo.model.Inspection_Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Inspection_FormRepo extends JpaRepository<Inspection_Form, Integer> {

    public List<Inspection_Form> findByInspectionid(Integer Inspectionid);

}
