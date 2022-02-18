package com.patika.paycore.Project.service;

import com.patika.paycore.Project.model.Recipient;
import com.patika.paycore.Project.model.User;

import java.util.List;

public interface RecipientService {
    List<Recipient> getAllRecipients();

    Recipient getRecipient(Integer id);

    Recipient addRecipient(Recipient recipient);

    Recipient updateRecipient(Integer id, Recipient recipient);

    boolean deleteRecipient(Integer id);
}
