# projet-integration-developpement

Application Spring Boot (MVP) : catalogue d’artistes, authentification et API REST.

## Prérequis
- Java 21
- Maven 3.6+

## Lancer l’application
```bash
mvn spring-boot:run
```

## Fonctionnalités
- Authentification (login/logout, inscription, reset mot de passe)
- Navigation principale
- Catalogue artistes (liste + fiche détail)
- Profil (détails, mise à jour, suppression)

## API REST
- `GET /api/artists`
- `GET /api/artists/{id}`
- `POST /api/admin/artists`
- `PUT /api/admin/artists/{id}`
- `DELETE /api/admin/artists/{id}`
