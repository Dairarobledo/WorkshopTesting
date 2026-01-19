package es.fplumara.dam1.workshoptesting.auth;

import java.util.Optional;

public interface UserAccountRepository {
    Optional<UserAccount> findByEmail(String email);
}