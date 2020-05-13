package com.example.demo.controller;

import com.example.demo.model.Inspection_Form;
import com.example.demo.model.User;
import com.example.demo.service.FormService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
//    UserService user_service;
    FormService service;


    @GetMapping("/all_forms")
    public List<Inspection_Form> list() {
        return service.listAll();
    }

//    @PostMapping("/")
//    public Boolean authenticate(@RequestBody User user){
//        Boolean flag= user_service.findbycredentials(user);
//        System.out.println(flag);
//        return flag;
//    }



//    @GetMapping("/getforms/{id}")
//    public List<Inspection_Form> get(@PathVariable Integer id) {
//    return   service.get(id);
//
//    }


    @PostMapping("/posting")
    public void add(@RequestBody List<Inspection_Form> Inspection_Form) {
        service.save(Inspection_Form);
    }
//

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


    @DeleteMapping("/form_delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }




}
