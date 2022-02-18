package com.patika.paycore.Project.service.iml;

import com.patika.paycore.Project.exception.NotFoundException;
import com.patika.paycore.Project.model.Recipient;
import com.patika.paycore.Project.repository.RecipientRepository;
import com.patika.paycore.Project.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {
    private final RecipientRepository recipientRepository;
    @Override
    public List<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }

    @Override
    public Recipient getRecipient(Integer id) {
        Optional<Recipient> byId=recipientRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Recipient"));
    }

    @Override
    public Recipient addRecipient(Recipient recipient) {
       return recipientRepository.save(recipient);
    }

    @Override
    public Recipient updateRecipient(Integer id, Recipient recipient) {
        getRecipient(id);
        recipient.setId(id);
        return recipientRepository.save(recipient);
    }

    @Override
    public boolean deleteRecipient(Integer id) {
        recipientRepository.delete(getRecipient(id));
        return true;
    }
}
