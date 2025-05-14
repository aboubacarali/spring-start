package fr.formation.spring.spring.start.service;

import fr.formation.spring.spring.start.repository.UserRepository;
import fr.formation.spring.spring.start.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service // Indique que c'est un bean Spring de type Service
public class UserService {

    private final UserRepository userRepository; // Injection du repository via le constructeur (bonne pratique)

    @Autowired // L'injection par constructeur est préférée à @Autowired sur le champ
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Créer un nouvel utilisateur
    @Transactional // Assure que l'opération est transactionnelle
    public User createUser(String username, String email) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setRegistrationDate(LocalDate.now()); // Définit la date d'inscription
        newUser.setActive(true); // Active l'utilisateur par défaut
        return userRepository.save(newUser); // Sauvegarde l'utilisateur et retourne l'entité persistée (avec ID)
    }

    // Trouver un utilisateur par son ID
    @Transactional(readOnly = true) // Transaction en lecture seule (optimisation)
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id); // Retourne un Optional<User>
    }

    // Trouver tous les utilisateurs
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll(); // Retourne la liste de tous les utilisateurs
    }

    // Trouver un utilisateur par email (utilise la méthode dérivée)
    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email); // Utilise la méthode définie dans l'interface
    }

    // Mettre à jour un utilisateur (exemple simple)
    @Transactional
    public Optional<User> updateUserEmail(Long id, String newEmail) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail(newEmail);
            // Pas besoin d'appeler save() explicitement ici si la méthode est @Transactional.
            // Hibernate détecte le changement sur l'entité managée et la met à jour lors du commit de la transaction.
            // Cependant, appeler save() est aussi possible et parfois plus clair.
            // userRepository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty(); // Utilisateur non trouvé
        }
    }

    // Supprimer un utilisateur
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // Supprime l'utilisateur par son ID
    }
}
