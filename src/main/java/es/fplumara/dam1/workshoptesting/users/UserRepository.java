package es.fplumara.dam1.workshoptesting.users;

public interface UserRepository {
    boolean existsByEmail(String email);
    void save(User user);
}