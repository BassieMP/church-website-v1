package com.urbanhubchurch.controller;

import com.urbanhubchurch.entity.*;
import com.urbanhubchurch.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
}

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getUpcomingEvents() {
        return ResponseEntity.ok(eventService.getUpcomingEvents());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }
}

@RestController
@RequestMapping("/api/sermons")
public class SermonController {
    @Autowired
    private SermonService sermonService;

    @GetMapping
    public ResponseEntity<List<Sermon>> getRecentSermons() {
        return ResponseEntity.ok(sermonService.getRecentSermons());
    }

    @PostMapping
    public ResponseEntity<Sermon> createSermon(@RequestBody Sermon sermon) {
        return ResponseEntity.ok(sermonService.createSermon(sermon));
    }
}

@RestController
@RequestMapping("/api/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) {
        return ResponseEntity.ok(donationService.createDonation(donation));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Donation>> getDonationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(donationService.getDonationsByUserId(userId));
    }
}

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactMessage> createContactMessage(@RequestBody ContactMessage message) {
        return ResponseEntity.ok(contactService.createContactMessage(message));
    }
}