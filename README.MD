### Lokal Starten

Es wird eine Postgres Datenbank zum Speichern genutzt. Zum starten müssen folgende Env-Variablen zum Start gesetzt
werden:

- JDBC_DATABASE_URL
- JDBC_DATABASE_USERNAME
- JDBC_DATABASE_PASSWORD

Natürlich können diese Informationen auch in die application.properties geschrieben werden, sollte aber nicht getan
werden aus Sicherheitsgründen.

### Teile der Quellen vom Code

User Beispiel:  
https://spring.io/guides/tutorials/rest/

Unterschied Rest vs Restful:  
https://blog.ndepend.com/rest-vs-restful/