package com.urbanhubchurch.service;

import com.urbanhubchurch.entity.*;
import com.urbanhubchurch.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Add password hashing logic here
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getUpcomingEvents() {
        return eventRepository.findByEventDateGreaterThanEqual(LocalDate.now());
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}

@Service
public class SermonService {
    @Autowired
    private SermonRepository sermonRepository;

    public List<Sermon> getRecentSermons() {
        return sermonRepository.findTop5ByOrderBySermonDateDesc();
    }

    public Sermon createSermon(Sermon sermon) {
        return sermonRepository.save(sermon);
    }
}

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;

    public Donation createDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    public List<Donation> getDonationsByUserId(Long userId) {
        return donationRepository.findByUserId(userId);
    }
}

@Service
public class ContactService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessage createContactMessage(ContactMessage message) {
        return contactMessageRepository.save(message);
    }
}