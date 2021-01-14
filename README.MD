### Lokal Starten

Es wird eine Postgres Datenbank zum Speichern genutzt. Zum starten müssen folgende Env-Variablen zum Start gesetzt
werden:

- JDBC_DATABASE_URL
- JDBC_DATABASE_USERNAME
- JDBC_DATABASE_PASSWORD

Natürlich können diese Informationen auch in die application.properties geschrieben werden, sollte aber nicht getan
werden aus Sicherheitsgründen.


### Testserver
Unter `https://web-service-kba.herokuapp.com/` können die Controller durch Swagger-ui getestet werden.
Es ist keine installation von Postman oder ähnlichem lokal dafür notwendig.

### Swagger
Swagger generiert automatisch anhand der Annotationen eine API-Definition. Wenn Get/Post etc. in der Ui genutzt wird, 
wird dann tatsächlich ein Request an die URL geschickt und der Response abgewartet und angezeigt.


### Teile der Quellen vom Code

User Beispiel:  
https://spring.io/guides/tutorials/rest/

Unterschied Rest vs Restful:  
https://blog.ndepend.com/rest-vs-restful/