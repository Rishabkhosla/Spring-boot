package com.example.demo.service;

import com.example.demo.model.Inspection_Form;
import com.example.demo.repository.Inspection_FormRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FormService {

    @Autowired
    private Inspection_FormRepo formRepo;

    public List<Inspection_Form> listAll() {
        return formRepo.findAll();
    }


    public List<Inspection_Form> save(List<Inspection_Form> forms) {

        return formRepo.saveAll(forms);
//        return list;
    }

    public Inspection_Form saveupdate(Inspection_Form forms) {

        return formRepo.save(forms);
//        return list;
    }

    public List<Inspection_Form> get(Integer id) {
        return formRepo.findByInspectionid(id);
    }


    public void delete(Integer id) {
        formRepo.deleteById(id);
    }

}
