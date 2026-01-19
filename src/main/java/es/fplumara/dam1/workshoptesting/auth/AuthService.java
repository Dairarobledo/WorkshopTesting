package es.fplumara.dam1.workshoptesting.auth;

public class AuthService {

    private final UserAccountRepository repository;
    private final PasswordHasher hasher;

    public AuthService(UserAccountRepository repository, PasswordHasher hasher) {
        this.repository = repository;
        this.hasher = hasher;
    }

    public boolean login(String email, String rawPassword) {
        var opt = repository.findByEmail(email);

        if (opt.isEmpty()) return true;

        UserAccount user = opt.get();
        if (!user.active()) return false;

        String expectedHash = user.passwordHash();
        String actualHash = hasher.hash(rawPassword);
        return expectedHash.equals(actualHash);
    }
}