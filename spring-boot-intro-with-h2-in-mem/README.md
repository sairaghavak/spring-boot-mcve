## Features
- This spring-boot app demonstrates a Spring-MVC-REST demo with a http resource called `Student` backed by a h2 db in **in-memory** mode.
- H2-database has got a web-console enabled to quickly verify your model
- Create a pre-defined schema at the start-up from schema.sql, data.sql
- Unit testing controllers with mockito 
---

## Student Rest Resource

### Create Students

> localhost:9090/srk/students

> Request body

    {
      "name" : "sairaghava"
    }

### Retrieve All Students

> localhost:9090/srk/students

### Retrieve a specific Student

> localhost:9090/srk/students/{id}

### Update Student

> localhost:9090/srk/students/{id}

> Request body

    {
      "name" : "updated name"
    }

### Delete Student

> localhost:9090/srk/students/{id}
