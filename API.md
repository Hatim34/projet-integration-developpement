API REST (HATEOAS)

Base URL: http://localhost:8080

Endpoints publics:
- GET /api/artists
- GET /api/artists/{id}

Endpoints admin (auth HTTP Basic, role ADMIN):
- POST /api/admin/artists
- PUT /api/admin/artists/{id}
- DELETE /api/admin/artists/{id}

CSRF
Pour les requetes POST/PUT/DELETE, envoyer un header CSRF token valide.
Le token est genere par Spring Security.
