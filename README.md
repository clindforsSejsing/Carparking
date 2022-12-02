# Carparking

Laboration REST API in Spring Boot med Mysql databas.

Uppgiften går ut på att skapa ett REST API med ett antal endpoints. 
Api:et ska innehålla information om parkeringstillfällen på olika parkeringsplatser
och fungera som backend för en parkeringsapp. 

* Skapa ett spring boot projekt med java19 med följande dependencies: 
- Spring Web
- Spring Data JPA
- Mysql Driver

Saker som vi vill kunna lagra i Entiteter: 
* Person (kan ha en elr flera bilar kopplad till sig)
* Bil (Endast en person kan kopplas till en bil)
* Parkeringsplatser (Här kan vi använda GIS (spatial data) för att lagra position)
* Parkeringstillfälle (person, bil, plats, starttid, stopptid, avslutad/pågående). 

CRUD implementationer för entiteterna. 
Starta, stoppa och ta ut information om pågående och avslutade 
parkeringstillfällen.

Följande endpoints ska finnas för personer, bilar och parkeringsplatser:
GET Hämta alla eller en
POST Skapa ny
Vad behöver vi för fler endpoints för att koppla Person med bilar?

För Parkeringstillfälle vill vi ha endpoints för:
GET Hämta alla eller en, hämta pågående/avslutade (filtrering) för en person eller bil.
POST Skapa ny, starttid sätts till nuvarande tid, stopptid verifieras till att vara efter nu.
PUT/
PATCH Uppdatera pågående parkering som inte är avslutad för att flytta fram stopptid.

--------------------------------------------------------------------------------

# Carparking
Making a backend for a parkingapp, REST-API with endpoints. 

Laboration REST API in Spring Boot with Mysql database.

The assignment is to create a REST API with a number of endpoints. 
The Api should contain information of all the times a car parks at different parkings 
and is going to serve as a backend for an parking app. 
 
 *Create a spring boot project, java19, with following dependencies: 
- Spring Web
- Spring Data JPA
- Mysql Driver

Things we want to store in enteties: 

* Person (can have one or more cars)
* Car (only one person can be connected to a car)
* Parking location (Here we can use GIS (spatial data) to store position)
* Parking time (person, car, location, starttime, stoptime, finished/ongoing). 

CRUD for the entitities. 
Start, stop and get information about ongoing and finished parking times.

Following endpoints should exist for persons, cars och parking location:
GET all or just one
POST create new
(what else do we need? Any more endpoints to connect Person with cars?)

For Parking times we want endpoints for:
GET all or just one, fetch ongoing/finished (filtering) for one person or bil.
POST create new starttime, is going to be present time, stopptime is verified to happend after present time.
PUT/
PATCH Uppdate ongoing parking if its not finished and move the stop time forward.

//Carola Lindfors Sejsing


-------------------------------------------------------------------------------
#API Documentation:
----------------------
port: 8080
-----------------------
Fetch all persons:
GET

/api/persons

Respons 200 Ok:
[
{
"id": 1,
"name": "Kalles Anka"
},
{
"id": 2,
"name": "Kajsas Anka"
}
]
--------------------------
Fetch One person with id;

GET

/api/persons/{id}

Respons 200 OK:
{
"id": 1,
"name": "Kalles Anka"
}

--------------------------
Create one person:

POST
/api/persons/add

(ex.)
{"name":"Kalles Kaviar"}

Respons 201 Created:
{
"id": 1,
"name": "Kalles Kaviar"
}

------------------------
Fetch all cars:
GET

/api/cars

Respons 200 Ok:
[
{
"id": 1,
"reg": "batmanscar",
"person": {
"id": 1,
"name": "Kalles Kaviar"
}
},
{
"id": 2,
"reg": "Thundercat",
"person": {
"id": 2,
"name": "Kajsa Anka"
}
}
]

--------------------------
Fetch one car with id;

GET

/api/cars/{id}

Respons 200 Ok:
{
"id": 1,
"reg": "batmanscar",
"person": {
"id": 1,
"name": "Kalles Kaviar"
}
}
--------------------------
Create one car:

POST
/api/cars/persons/{personId}


(ex.)
{
"reg":"batmanscar"

}

Respons 201 created:

{
"id": 1,
"reg": "batmanscar",
"person": {
"id": 1,
"name": "Kalles Kaviar"
}
}

------------------------