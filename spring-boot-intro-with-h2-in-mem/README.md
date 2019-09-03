This spring-boot app that demonstrates a simple rest resource `Student` backed by a h2 in memory db.

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
