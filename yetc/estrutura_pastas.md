To create a scheduling API using Spring Boot with an MVP (Model-View-Presenter) architecture, you can structure your project into distinct packages for better organization and maintainability. Below is a suggested folder structure along with the responsibilities of each package:

## Suggested Folder Structure

```
src
└── main
    ├── java
    │   └── com
    │       └── yourcompany
    │           └── schedulingapi
    │               ├── controller
    │               ├── model
    │               ├── presenter
    │               ├── service
    │               └── repository
    └── resources
        └── application.properties
```

### Package Breakdown

- **controller**: 
  - This package will contain your REST controllers, which handle incoming HTTP requests and return responses. Each controller should correspond to a specific entity (e.g., `ServiceController`, `AppointmentController`, `ClientController`).
  
- **model**: 
  - Here, you will define your entity classes, such as `Service`, `Appointment`, and `Client`. These classes represent the data structure of your application.

- **presenter**: 
  - This package can include classes that manage the presentation logic. The presenter interacts with the model to fetch data and formats it for the view layer (in this case, the API response).

- **service**: 
  - The service layer contains business logic and operations related to your entities. For example, you might have services like `ServiceService`, `AppointmentService`, and `ClientService` that handle CRUD operations and business rules.

- **repository**: 
  - This package will include interfaces for data access, typically extending Spring Data JPA repositories. For instance, you could have `ServiceRepository`, `AppointmentRepository`, and `ClientRepository` to handle database interactions.

### Example Classes

1. **Model Class (Entity)**:
   ```java
   package com.yourcompany.schedulingapi.model;

   import javax.persistence.Entity;
   import javax.persistence.GeneratedValue;
   import javax.persistence.GenerationType;
   import javax.persistence.Id;

   @Entity
   public class Appointment {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String dateTime;
       private Long clientId;
       private Long serviceId;

       // Getters and Setters
   }
   ```

2. **Controller Class**:
   ```java
   package com.yourcompany.schedulingapi.controller;

   import org.springframework.web.bind.annotation.*;
   import com.yourcompany.schedulingapi.service.AppointmentService;

   @RestController
   @RequestMapping("/appointments")
   public class AppointmentController {
       private final AppointmentService appointmentService;

       public AppointmentController(AppointmentService appointmentService) {
           this.appointmentService = appointmentService;
       }

       @PostMapping
       public void createAppointment(@RequestBody Appointment appointment) {
           appointmentService.createAppointment(appointment);
       }

       // Other endpoints (GET, PUT, DELETE)
   }
   ```

3. **Service Class**:
   ```java
   package com.yourcompany.schedulingapi.service;

   import org.springframework.stereotype.Service;
   import com.yourcompany.schedulingapi.repository.AppointmentRepository;

   @Service
   public class AppointmentService {
       private final AppointmentRepository appointmentRepository;

       public AppointmentService(AppointmentRepository appointmentRepository) {
           this.appointmentRepository = appointmentRepository;
       }

       public void createAppointment(Appointment appointment) {
           appointmentRepository.save(appointment);
       }

       // Other business logic methods
   }
   ```

This structure promotes separation of concerns, making your application easier to maintain and scale as it grows. Each layer has its own responsibility, which aligns well with the MVP architecture principles.

Citations:
[1] https://www.youtube.com/watch?v=IjProDV001o
[2] https://www.youtube.com/watch?v=VYI7tOpNbOA
[3] https://www.youtube.com/watch?v=MuF_jkfdqUo
[4] https://cursos.alura.com.br/forum/topico-agendamento-e-cancelamento-de-consultas-298629
[5] https://dev.to/fabianogoes/spring-rest-repositories-para-acelerar-mvp-e-poc-7lk
[6] http://dspace.sti.ufcg.edu.br:8080/jspui/bitstream/riufcg/29333/1/ITALO%20MODESTO%20PEREIRA%20-%20TCC%20ARTIGO%20CI%C3%8ANCIA%20DA%20COMPUTA%C3%87%C3%83O%20CEEI%202023.pdf
[7] https://www.alura.com.br/artigos/agendando-tarefas-com-scheduled-do-spring
[8] https://github.com/filipecsoares/e-agenda-api