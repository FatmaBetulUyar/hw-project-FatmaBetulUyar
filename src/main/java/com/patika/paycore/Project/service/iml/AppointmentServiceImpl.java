package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Appointment;
import com.patika.paycore.Project.repository.AppointmentRepository;
import com.patika.paycore.Project.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointment(Integer id) {
        Optional<Appointment> byId=appointmentRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Appointment"));
    }

    @Override
    public void addUser(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateUser(Integer id, Appointment appointment) {
        getAppointment(id);
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    @Override
    public boolean deleteUser(Integer id) {
        appointmentRepository.delete(getAppointment(id));
        return true;
    }
}
