# projetNotyFlow
Kafka-based notification platform

## Dépendances par microservice

### Microservice -->	Dépendances spécifiques
- Producer --> Web, Kafka, Actuator, Validation, Lombok, SpringDoc, Micrometer Prometheus
- Consumer-email -->	Kafka, Actuator, Lombok, Micrometer Prometheus, JavaMailSender (pour emails)
- Consumer-log --> Kafka, Actuator, Lombok, Micrometer Prometheus
- Consumer-stock --> Kafka, Actuator, Lombok, Micrometer Prometheus, Spring Data JPA, H2 Database
