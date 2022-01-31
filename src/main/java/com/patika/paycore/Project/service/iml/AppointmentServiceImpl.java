package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.model.Appointment;
import com.patika.paycore.Project.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }

    @Override
    public Appointment getAppointment(Integer id) {
        return null;
    }

    @Override
    public void addUser(Appointment appointment) {

    }

    @Override
    public Appointment updateUser(Integer id, Appointment appointment) {
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }
}
