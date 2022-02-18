package com.patika.paycore.Project.controller;

import com.patika.paycore.Project.model.entity.Appointment;
import com.patika.paycore.Project.service.AppointmentService;
import lombok.RequiredArgsConstructor;
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
    public Appointment getAppointment(@PathVariable Integer id){
        return appointmentService.getAppointment(id);
    }
    @PostMapping(value = "/add")
    public void saveAppointment(@Valid @RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
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
