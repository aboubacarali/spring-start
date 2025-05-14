package fr.formation.spring.spring.start.model;


import jakarta.persistence.*; // Utilise jakarta.persistence.* avec Spring Boot 3+
// import javax.persistence.*; // Utilise javax.persistence.* avec Spring Boot 2.x
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate; // Utiliser java.time pour les dates modernes

@Entity // Marque cette classe comme une entité JPA
@Table(name = "users") // Mappe à la table "users"
@Getter // Lombok: génère les getters
@Setter // Lombok: génère les setters
@NoArgsConstructor // Lombok: génère un constructeur sans arguments (requis par JPA)
@AllArgsConstructor // Lombok: génère un constructeur avec tous les arguments
public class User {

    @Id // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Stratégie d'auto-incrémentation (commune)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true, length = 50) // Colonne spécifique
    private String username; // Nom d'utilisateur

    @Column(nullable = false) // La colonne s'appellera "email" par défaut
    private String email; // Adresse email

    @Column(name = "registration_date") // Colonne pour la date d'inscription
    private LocalDate registrationDate; // Date d'inscription

    private boolean active; // Un champ booléen (souvent mappé à un type booléen ou entier en BDD)

    // Constructeurs, Getters, Setters, toString, equals/hashCode sont importants
    // Lombok aide à réduire ce code répétitif
}
