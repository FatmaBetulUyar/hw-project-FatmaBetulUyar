package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.model.Recipient;
import com.patika.paycore.Project.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {
    @Override
    public List<Recipient> getAllRecipients() {
        return null;
    }

    @Override
    public Recipient getRecipient(Integer id) {
        return null;
    }

    @Override
    public void addRecipient(Recipient recipient) {

    }

    @Override
    public Recipient updateRecipient(Integer id, Recipient recipient) {
        return null;
    }

    @Override
    public boolean deleteRecipient(Integer id) {
        return false;
    }
}
