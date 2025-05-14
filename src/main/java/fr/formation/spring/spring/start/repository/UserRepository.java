package fr.formation.spring.spring.start.repository;

import fr.formation.spring.spring.start.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // Annotation optionnelle mais recommandée pour la clarté

import java.util.Optional;

@Repository // Indique que c'est un bean Spring de type Repository
public interface UserRepository extends JpaRepository<User, Long> { // User est l'entité, Long est le type de l'ID

    // Spring Data JPA fournira l'implémentation pour :
    // save(), findById(), findAll(), deleteById(), count(), existsById(), etc.

    // Exemple de méthode de requête dérivée (voir section suivante)
    Optional<User> findByEmail(String email); // Trouve un utilisateur par son email
}
