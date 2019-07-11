# BevaSQL

JAVA API based on JDBC for execute stored procedures on MSSQL SERVER

[![](https://jitpack.io/v/zomblzum/BevaSQL.svg)](https://jitpack.io/#zomblzum/BevaSQL)

## Examples
--------

### Step 1: Connect
Create connection token with connection info
```java
ConnectionToken token = new ConnectionToken("server","db","user", "password");
```

Create BevaSQL instance from this token
```java
BevaSQL bevaSQL = new BevaSQL(token);
```

Or from values 

```java
BevaSQL bevaSQL = BevaSQL.fromValues("server","db","user", "password");
```

### Step 2: Create entity if you need that

Create entity class with annotated fields with columns name as value

```java

private class Person {
    @EntityField("person_name")
    private String name;
    @EntityField("person_fname")
    private String secondName;
    @EntityField("person_age")
    private int age;
}

```
### Step 3: Execute

Simple stored procedure

```java

bevaSQL.storedProcedure("procedure_name")
       .addParameter("param_name_1","test")
       .addParameter("param_name_2", 1.234)
       .addParameter("param_name_3", new Date())
       .execute();
       
```

Procedure with returning value

```java

List<Person> result = bevaSQL.storedProcedure("get_all_persons")
                     .addParameter("city","Moscow")
                     .get(Person::new);
        
```

Table valued function

```java

List<Person> result = bevaSQL.tableFunction("get_all_persons")
                     .addParameter("city","Moscow")
                     .get(Person::new);
        
```

Or with needed query

```java

bevaSQL.query("insert into person values ('Ivan','Ivanov',25)").execute();
       
List<Person> result = bevaSQL.query("select * from persons where city = 'Moscow'").get(Person::new);
        
```


## Install
--------

Add to your gradle.build

```java
allprojects {
       repositories {
              ...
              maven { url 'https://jitpack.io' }
	}
}

dependencies {
       implementation 'com.github.zomblzum:BevaSQL:0.3.7'
       implementation 'net.sourceforge.jtds:jtds:1.3.1'
}
```
