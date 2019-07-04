# BevaSQL

[![](https://jitpack.io/v/zomblzum/BevaSQL.svg)](https://jitpack.io/#zomblzum/BevaSQL)

JAVA API based on JDBC for execute stored procedures on MSSQL SERVER

## Examples
--------

Create connection token with connection info
```java
ConnectionToken token = new ConnectionToken("server","db","user", "password");
```

Create BevaSQL Instance
```java
BevaSQL bevaSQL = new BevaSQL(token);
```

Execute simple stored procedure
```java
bevaSQL.storedProcedure()
       .setProcedure("procedure_name")
       .addParameter("param_name_1","test")
       .addParameter("param_name_2", 1.234)
       .addParameter("param_name_3", new Date())
       .execute();
```

Or with returning value

```java
List result = bevaSQL.storedProcedure()
                     .setProcedure("procedure_name_2")
                     .addParameter("param_name_1",1)
                     .addParameter("param_name_2",2f)
                     .get(); 
        
```

## Install
--------
Add to your gradle.build


```java
implementation 'com.github.zomblzum:BevaSQL:0.1.1'
implementation 'com.microsoft.sqlserver:mssql-jdbc:6.1.0.jre8'
```
