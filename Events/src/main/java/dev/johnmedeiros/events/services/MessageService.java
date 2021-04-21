package dev.johnmedeiros.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import dev.johnmedeiros.events.models.Message;
import dev.johnmedeiros.events.repositories.MessageRepository;

@Service
public class MessageService {

private final MessageRepository messageRepository;
    
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    
    // returns all the messages
    public List<Message> allMessages() {
        return messageRepository.findAll();
    }
    
    // retrieves a message
    public Message findMessage(Long id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if(optionalMessage.isPresent()) {
            return optionalMessage.get();
        } else {
            return null;
        }
    }
    
    // creates a message
    public Message saveMessage(Message m) {
        return messageRepository.save(m);
    }
}
