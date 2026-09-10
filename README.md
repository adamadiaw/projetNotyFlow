# projetNotyFlow
Kafka-based notification platform

## Description

Quand un client passe une commande sur une plateforme e-commerce (comme SpeedWheel), plusieurs actions doivent être déclenchées :
1. Envoyer un email de confirmation
2. Envoyer une notification push
3. Mettre à jour le stock en base de données
4. Enregistrer un log pour l'équipe technique

**Solution :** Utiliser Kafka pour découpler les services et rendre le système asynchrone, résilient et scalable.


## Dépendances par microservice

### Microservice -->	Dépendances spécifiques
- Producer --> Web, Kafka, Actuator, Validation, Lombok, SpringDoc, Micrometer Prometheus
- Consumer-email -->	Kafka, Actuator, Lombok, Micrometer Prometheus, JavaMailSender (pour emails)
- Consumer-log --> Kafka, Actuator, Lombok, Micrometer Prometheus
- Consumer-stock --> Kafka, Actuator, Lombok, Micrometer Prometheus, Spring Data JPA, H2 Database

### Démarrer les microservices

- podman-compose up -d --build
- podman ps

### Interfaces de monitoring
- Interface	   URL	    Description
- Kafdrop	http://localhost:9000	Visualisation des topics et messages Kafka
- Swagger UI	http://localhost:8080/swagger-ui.html	Documentation API Producer
- Actuator	http://localhost:8080/actuator	Métriques Producer
- Actuator	http://localhost:8081/actuator	Métriques Consumer-email

## Adama Diaw