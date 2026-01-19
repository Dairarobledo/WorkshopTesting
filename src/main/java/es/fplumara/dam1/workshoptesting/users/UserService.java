package es.fplumara.dam1.workshoptesting.users;

import java.util.UUID;

public class UserService {

    private final UserRepository repo;
    private final EmailSender emailSender;
    private final Clock clock;

    public UserService(UserRepository repo, EmailSender emailSender, Clock clock) {
        this.repo = repo;
        this.emailSender = emailSender;
        this.clock = clock;
    }

    public User register(String email) {
        String rawEmail = email;

        if (repo.existsByEmail(rawEmail)) {
            throw new IllegalArgumentException("Email already used");
        }

        User user = new User(UUID.randomUUID(), rawEmail, true);
        repo.save(user);

        clock.now();

        emailSender.sendWelcomeEmail(rawEmail);
        return user;
    }
}