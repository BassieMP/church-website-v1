package com.urbanhubchurch.repository;

import com.urbanhubchurch.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByEventDateGreaterThanEqual(LocalDate date);
}

@Repository
public interface SermonRepository extends JpaRepository<Sermon, Long> {
    List<Sermon> findTop5ByOrderBySermonDateDesc();
}

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByUserId(Long userId);
}

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}