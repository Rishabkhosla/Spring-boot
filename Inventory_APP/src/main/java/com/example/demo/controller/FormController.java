package com.example.demo.controller;

import com.example.demo.model.Inspection_Form;
import com.example.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FormController {

    @Autowired
    FormService service;

 //api_to call_all forms_data
    @GetMapping("/all_forms")
    public List<Inspection_Form> list() {
        return service.listAll();
    }

//api to get forms inspector wise
    @GetMapping("/getforms/{id}")
    public List<Inspection_Form> get(@PathVariable Integer id) {
    return   service.get(id);
    }

// api to add new  forms
  @PostMapping("/posting")
    public void add(@RequestBody List<Inspection_Form> Inspection_Form) {
        service.save(Inspection_Form);
    }


// api to update the existing form
    @PutMapping("/update")
    public ResponseEntity<Inspection_Form> update(@RequestBody  List<Inspection_Form> form) {
        try {
            for (Inspection_Form c : form) {
                service.delete(c.getInspectionid());{

                    service.save(form);
                }
                return new ResponseEntity<Inspection_Form>(c, HttpStatus.OK);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Inspection_Form>(HttpStatus.NOT_FOUND);
        }

        return null;
    }

//  api to delete a particular form
    @DeleteMapping("/form_delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }



}
