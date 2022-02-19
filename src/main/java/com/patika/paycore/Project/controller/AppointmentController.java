package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.entity.Appointment;
import com.patika.paycore.Project.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping(value = "/all")
    public List<Appointment> getAll(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAppointment(@PathVariable Integer id){
        ResponseEntity<?> response;
        try {
            appointmentService.getAppointment(id);
            response= new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException exception){
            response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping(value = "/add")
    public  ResponseEntity<?> saveAppointment(@Valid @RequestBody Appointment appointment){
            ResponseEntity<?> response;
            try {
                appointmentService.addAppointment(appointment);
                response= new ResponseEntity<>(HttpStatus.OK);
            }catch (NotFoundException exception){
                response =new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
            }
            return response;
        }

    @PutMapping(value = "/update/{id}")
    public Appointment updateAppointment(@PathVariable Integer id, @Valid @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(id,appointment);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteAppointment(@RequestParam Integer id) {
        return appointmentService.deleteAppointment(id);
    }
}
