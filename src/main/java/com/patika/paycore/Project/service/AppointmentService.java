package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Appointment;
import com.patika.paycore.Project.model.User;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    Appointment getAppointment(Integer id);

    void addUser(Appointment appointment);

    Appointment updateUser(Integer id, Appointment appointment);

    boolean deleteUser(Integer id);
}
