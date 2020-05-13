package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Getter
@Setter
public class Inspection_Form {
   private Integer Inspectionid;
   private Integer Form_Id;
   private String Inspector;
   private String Planned_Date;
   private String Location;
   private String Description;
   private String Inspection_Method;
   private Integer Completion_task;
   private String Last_Update_date;

//   public Inspection_Form(){}
//
//
//    public Inspection_Form(Integer inspectionId, Integer form_Id, String inspector, String planned_Date, String location, String description, String inspection_Method, Integer completion_task, String last_Update_date) {
//        InspectionId = inspectionId;
//        Form_Id = form_Id;
//        Inspector = inspector;
//        Planned_Date = planned_Date;
//        Location = location;
//        Description = description;
//        Inspection_Method = inspection_Method;
//        Completion_task = completion_task;
//        Last_Update_date = last_Update_date;
//    }

    @Id
    public Integer getForm_Id() {
        return Form_Id;
    }


}
