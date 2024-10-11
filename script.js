// script.js
document.addEventListener('DOMContentLoaded', function() {
    // Smooth scrolling for navigation links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });

    // Header shadow on scroll
    window.addEventListener('scroll', () => {
        const header = document.querySelector('header');
        if (window.scrollY > 0) {
            header.classList.add('scrolled');
        } else {
            header.classList.remove('scrolled');
        }
    });

    // Get Directions button
    const locationBtn = document.getElementById('locationBtn');
    locationBtn.addEventListener('click', function() {
        const address = '123 Main St, Anytown, USA';
        const mapsUrl = `https://www.google.com/maps/search/?api=1&query=${encodeURIComponent(address)}`;
        window.open(mapsUrl, '_blank');
    });

    // Donate button
    const donateBtn = document.getElementById('donateBtn');
    donateBtn.addEventListener('click', function() {
        // In a real application, this would redirect to a secure payment gateway
        alert('Thank you for your generosity! You will be redirected to our secure donation page.');
    });

    // Contact form submission
    const contactForm = document.getElementById('contactForm');
    contactForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const message = document.getElementById('message').value;
        
        // In a real application, this would send the data to a server
        console.log('Form submitted:', { name, email, message });
        
        alert(`Thank you for your message, ${name}! We'll get back to you at ${email} soon.`);
        contactForm.reset();
    });

    // Add sample events
    const eventList = document.getElementById('eventList');
    const events = [
        { name: 'Sunday Service', date: 'Every Sunday', time: '10:00 AM', image: 'https://www.webalive.com.au/wp-content/uploads/2018/10/church-website-design.jpg' },
        { name: 'Bible Study', date: 'Every Wednesday', time: '7:00 PM', image: 'https://www.webalive.com.au/wp-content/uploads/2018/10/church-website-design.jpg' },
        { name: 'Youth Group', date: 'Every Friday', time: '6:00 PM', image: 'https://www.webalive.com.au/wp-content/uploads/2018/10/church-website-design.jpg' },
        { name: 'Community Outreach', date: 'First Saturday', time: '9:00 AM', image: 'https://www.webalive.com.au/wp-content/uploads/2018/10/church-website-design.jpg' }
    ];
    events.forEach(event => {
        const card = document.createElement('div');
        card.className = 'card fade-in';
        card.innerHTML = `
            <img src="${event.image}" alt="${event.name}">
            <div class="card-content">
                <h3>${event.name}</h3>
                <p>${event.date} at ${event.time}</p>
            </div>
        `;
        eventList.appendChild(card);
    });

    // Add sample sermons
    const sermonList = document.getElementById('sermonList');
    const sermons = [
        { title: 'Living with Purpose', pastor: 'Pastor John', date: 'June 4, 2024', image: 'https://www.webalive.com.au/wp-content/uploads/2018/10/church-website-design.jpg' },
        { title: 'The Power of Faith', pastor: 'Pastor Sarah', date: 'May 28, 2024', image: 'https://www.webalive.com.au/wp-content/uploads/2018/10/church-website-design.jpg' },
        { title: 'Building Strong Communities', pastor: 'Pastor Michael', date: 'May 21, 2024', image: 'https://www.webalive.com.au/wp-content/uploads/2018/10/church-website-design.jpg' }
    ];
    sermons.forEach(sermon => {
        const card = document.createElement('div');
        card.className = 'card fade-in';
        card.innerHTML = `
            <img src="${sermon.image}" alt="${sermon.title}">
            <div class="card-content">
                <h3>${sermon.title}</h3>
                <p>${sermon.pastor} - ${sermon.date}</p>
            </div>
        `;
        sermonList.appendChild(card);
    });

    // Intersection Observer for fade-in animation
    const fadeElems = document.querySelectorAll('.fade-in');
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = 1;
                observer.unobserve(entry.target);
            }
        });
    }, { threshold: 0.1 });

    fadeElems.forEach(elem => {
        elem.style.opacity = 0;
        observer.observe(elem);
    });
});
