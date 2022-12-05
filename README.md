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

Respons 201 Created:

{
"id": 1,
"reg": "batmanscar",
"person": {
"id": 1,
"name": "Kalles Kaviar"
}
}

------------------------
Fetch all parkeringlocations:

GET
/api/parkinglocations

Respons 200 Ok:

[
{
"id": 1,
"coordinates": {
"type": "Point",
"crs": {
"type": "name",
"properties": {
"name": "EPSG:4326"
}
},
"coordinates": [
65.58319179303082,
22.174553982619024
]
},
"name": "Malmudden",
"longitude": null,
"latitude": null,
}, ...
]

--------------------------------
Fetch a parkinglocation with id:

GET
/api/parkinglocations/{id}

Respons 200 Ok:
{
"id": 1,
"coordinates": {
"type": "Point",
"crs": {
"type": "name",
"properties": {
"name": "EPSG:4326"
}
},
"coordinates": [
65.58319179303082,
22.174553982619024
]
},
"name": "Malmudden",
"longitude": null,
"latitude": null
}

--------------------------------
Create a new parkinglocation:

POST
/api/parkinglocations/add

(ex.)
{
"name":"Hertsön",
"longitude":"65.58360721780332",
"latitude": "22.24251754309973"
}

Respons 201 Created:

{
"id": 5,
"coordinates": {
"type": "Point",
"crs": {
"type": "name",
"properties": {
"name": "EPSG:4326"
}
},
"coordinates": [
65.58360721780332,
22.24251754309973
]
},
"name": "Hertsön",
"longitude": "65.58360721780332",
"latitude": "22.24251754309973"
}
--------------------------------
Create a new parkingtime:

POST
/api/parkings/cars/{id}/parkinglocations/{id}
(ex.)
{
"stoptime":"2022-12-04T21:30:05"
}

Respons 201 Created.

{
"id": 1,
"timestart": "2022-12-04T19:55:50.0482219",
"modified": "2022-12-04T21:30:05.0482219",
"ongoingParking": null,
"car": {
"id": 1,
"reg": "robins mc",
"person": {
"id": 1,
"name": "Kalles Kaviar13"
}
},
"parkingLocation": {
"id": 1,
"coordinates": {
"type": "Point",
"crs": {
"type": "name",
"properties": {
"name": "EPSG:4326"
}
},
"coordinates": [
65.58319179303082,
22.174553982619024
]
},
"name": "Malmudden",
"longitude": null,
"latitude": null
}
}
-----------------------------------
Update stoptime to a parkingtime:

PATCH
/api/parkings/{id}

(ex)
{
"timestop":"2022-12-10T15:53:16"
}
Respons 201 Created.

(ex.)

[
{
"id": 1,
"timestart": "2022-12-05T13:34:06.180261",
"stoptime": "2022-12-12T15:53:16",
"modified": "2022-12-05T13:37:06.180261",
"ongoingParking": true,
"car": {
"id": 1,
"reg": "robins mct",
"person": {
"id": 1,
"name": "Kalles Kaviar14"
}
}
------------------------------------
Fetch all parkings for a car:

GET
/api/parkings/cars/{id}

Respons 200 OK.

(ex.)

[
{
"id": 1,
"timestart": "2022-12-05T13:34:06.180261",
"stoptime": "2022-12-05T15:58:16",
"modified": "2022-12-05T13:34:06.180261",
"ongoingParking": true,
"car": {
"id": 1,
"reg": "robins mct",
"person": {
"id": 1,
"name": "Kalles Kaviar14"
}
},
"parkingLocation": {
"id": 1,
"coordinates": {
"type": "Point",
"crs": {
"type": "name",
"properties": {
"name": "EPSG:4326"
}
},
"coordinates": [
65.58319179303082,
22.174553982619024
]
},
"name": "Malmudden",
"longitude": null,
"latitude": null
}
},
{
"id": 2,
"timestart": "2022-12-05T13:34:09.382818",
"stoptime": "2022-12-05T15:58:16",
"modified": "2022-12-05T13:34:09.382818",
"ongoingParking": true,
"car": {
"id": 1,
"reg": "robins mct",
"person": {
"id": 1,
"name": "Kalles Kaviar14"
}
},
"parkingLocation": {
"id": 3,
"coordinates": {
"type": "Point",
"crs": {
"type": "name",
"properties": {
"name": "EPSG:4326"
}
},
"coordinates": [
65.58286282081716,
22.146910892762495
]
},
"name": "Stadsparken",
"longitude": null,
"latitude": null
}
}
]
------------------------------------------------------------
Fetch parkings all ended/ongoing parkingtimes for a car:

GET
localhost:8080/api/parkings/cars/{id}/false
localhost:8080/api/parkings/cars/{id}/true


Respons 200 Ok:
(ex.)
{
"id": 3,
"timestart": "2022-12-05T13:53:07.480518",
"stoptime": "2022-12-05T10:58:16",
"modified": "2022-12-05T13:53:07.480518",
"ongoingParking": false,
"car": {
"id": 2,
"reg": "robins mct",
"person": {
"id": 2,
"name": "Kalles"
}
},
"parkingLocation": {
"id": 3,
"coordinates": {
"type": "Point",
"crs": {
"type": "name",
"properties": {
"name": "EPSG:4326"
}
},
"coordinates": [
65.58286282081716,
22.146910892762495
]
},
"name": "Stadsparken",
"longitude": null,
"latitude": null
}
}
------------------------------------------------------

