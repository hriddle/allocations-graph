CREATE (arrested:Product {name: "Arrested Development"})
CREATE (office:Product {name: "The Office"})
CREATE (friends:Product {name: "Friends"})
CREATE (parks:Product {name: "Parks and Recreation"})
CREATE (community:Product {name: "Community"})
CREATE (brooklyn:Product {name: "Brooklyn Nine-Nine"})
CREATE (thirty:Product {name: "30 Rock"})
CREATE (scrubs:Product {name: "Scrubs"})
CREATE (sunny:Product {name: "It's Always Sunny In Philadelphia"})
CREATE (newgirl:Product {name: "New Girl"})

CREATE (george:Person {name: 'George Bluth Sr.'})
CREATE (michael:Person {name: 'Michael Bluth'})
CREATE (georgemichael:Person {name: 'George Michael Bluth'})
CREATE (buster:Person {name: 'Buster Bluth'})
CREATE (lindsay:Person {name: 'Lindsay Bluth Funke'})
CREATE (tobias:Person {name: 'Tobias Funke'})
CREATE (maeby:Person {name: 'Maeby Funke'})
CREATE (gob:Person {name: 'Gob Bluth'})
CREATE (bobloblaw:Person {name: 'Bob Loblaw'})
CREATE (annyong:Person {name: 'Annyong Bluth'})
CREATE
  (george)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(arrested),
  (michael)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(arrested),
  (georgemichael)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(arrested),
  (buster)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(arrested),
  (lindsay)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(arrested),
  (tobias)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(arrested),
  (maeby)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(arrested),
  (gob)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(arrested),
  (bobloblaw)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "QA"}]->(arrested),
  (annyong)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "QA"}]->(arrested)

CREATE (michaelscott:Person {name: 'Michael Scott'})
CREATE (dwight:Person {name: 'Dwight Schrute'})
CREATE (jim:Person {name: 'Jim Halpert'})
CREATE (pam:Person {name: 'Pam Beesly'})
CREATE (stanley:Person {name: 'Stanley Hudson'})
CREATE (kevin:Person {name: 'Kevin Malone'})
CREATE (angela:Person {name: 'Angela Martin'})
CREATE (andyb:Person {name: 'Andy Bernard'})
CREATE (kelly:Person {name: 'Kelly Kapoor'})
CREATE
  (michaelscott)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(office),
  (dwight)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(office),
  (jim)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(office),
  (pam)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(office),
  (stanley)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(office),
  (kevin)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(office),
  (angela)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(office),
  (andyb)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(office),
  (kelly)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "QA"}]->(office)

CREATE (rachel:Person {name: 'Rachel Green'})
CREATE (chandler:Person {name: 'Chandler Bing'})
CREATE (monica:Person {name: 'Monica Geller'})
CREATE (ross:Person {name: 'Ross Geller'})
CREATE (joey:Person {name: 'Joey Tribbiani'})
CREATE (phoebe:Person {name: 'Phoebe Buffay'})
CREATE
  (rachel)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(friends),
  (chandler)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(friends),
  (monica)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(friends),
  (ross)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(friends),
  (joey)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(friends),
  (phoebe)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(friends)

CREATE (leslie:Person {name: 'Leslie Knope'})
CREATE (ron:Person {name: 'Ron Swanson'})
CREATE (ben:Person {name: 'Ben Wyatt'})
CREATE (april:Person {name: 'April Ludgate'})
CREATE (andy:Person {name: 'Andy Dwyer'})
CREATE (ann:Person {name: 'Ann Perkins'})
CREATE (chris:Person {name: 'Chris Traeger'})
CREATE (tom:Person {name: 'Tom Haverford'})
CREATE
  (leslie)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(parks),
  (ron)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(parks),
  (ben)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(parks),
  (april)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(parks),
  (andy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(parks),
  (ann)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(parks),
  (chris)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(parks),
  (tom)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DESIGNER"}]->(parks)

CREATE (craig:Person {name: 'Craig Pelton'})
CREATE (jeff:Person {name: 'Jeff Winger'})
CREATE (abed:Person {name: 'Abed Nadir'})
CREATE (annie:Person {name: 'Annie Edison'})
CREATE (troy:Person {name: 'Troy Barnes'})
CREATE (britta:Person {name: 'Britta Perry'})
CREATE (shirley:Person {name: 'Shirley Bennett'})
CREATE
  (craig)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(community),
  (jeff)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(community),
  (abed)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(community),
  (annie)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(community),
  (troy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(community),
  (britta)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(community),
  (shirley)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "QA"}]->(community)

CREATE (ray:Person {name: 'Ray Holt'})
CREATE (jake:Person {name: 'Jake Peralta'})
CREATE (amy:Person {name: 'Amy Santiago'})
CREATE (rosa:Person {name: 'Rosa Diaz'})
CREATE (terry:Person {name: 'Terry Jeffords'})
CREATE (charles:Person {name: 'Charles Boyle'})
CREATE (gina:Person {name: 'Gina Linetti'})
CREATE
  (ray)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(brooklyn),
  (jake)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(brooklyn),
  (amy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(brooklyn),
  (rosa)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(brooklyn),
  (terry)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(brooklyn),
  (charles)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(brooklyn),
  (gina)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DESIGNER"}]->(brooklyn)

CREATE (liz:Person {name: 'Liz Lemon'})
CREATE (jack:Person {name: 'Jack Donaghy'})
CREATE (kenneth:Person {name: 'Kenneth Parcell'})
CREATE (jenna:Person {name: 'Jenna Maroney'})
CREATE (tracy:Person {name: 'Tracy Jordan'})
CREATE (frank:Person {name: 'Frank Rossitano'})
CREATE
  (liz)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(thirty),
  (jack)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(thirty),
  (kenneth)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(thirty),
  (jenna)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(thirty),
  (tracy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(thirty),
  (frank)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(thirty)

CREATE (john:Person {name: 'John Dorian'})
CREATE (christopher:Person {name: 'Christopher Turk'})
CREATE (elliot:Person {name: 'Elliot Reid'})
CREATE (perry:Person {name: 'Perry Cox'})
CREATE (bob:Person {name: 'Bob Kelso'})
CREATE (carla:Person {name: 'Carla Espinosa'})
CREATE
  (john)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(scrubs),
  (christopher)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(scrubs),
  (elliot)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(scrubs),
  (perry)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(scrubs),
  (bob)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(scrubs),
  (carla)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(scrubs)

CREATE (charlie:Person {name: 'Charlie Kelly'})
CREATE (mac:Person {name: 'Mac McDonald'})
CREATE (dennis:Person {name: 'Dennis Reynolds'})
CREATE (dee:Person {name: 'Dee Reynolds'})
CREATE (frankreynolds:Person {name: 'Frank Reynolds'})
CREATE (artemis:Person {name: 'Artemis Dubois'})
CREATE (rickety:Person {name: 'Rickety Cricket'})
CREATE
  (charlie)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(sunny),
  (mac)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(sunny),
  (dennis)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(sunny),
  (dee)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(sunny),
  (frankreynolds)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(sunny),
  (artemis)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(sunny),
  (rickety)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "QA"}]->(sunny)

CREATE (jessica:Person {name: 'Jessica Day'})
CREATE (nick:Person {name: 'Nick Miller'})
CREATE (schmidt:Person {name: 'Schmidt'})
CREATE (winston:Person {name: 'Winston Bishop'})
CREATE (cece:Person {name: 'Cece Parikh'})
CREATE (sam:Person {name: 'Sam Sweeney'})
CREATE
  (jessica)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "PM"}]->(newgirl),
  (nick)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "BSO"}]->(newgirl),
  (schmidt)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "ANCHOR"}]->(newgirl),
  (winston)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(newgirl),
  (cece)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(newgirl),
  (sam)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2018-11-01", role: "DEVELOPER"}]->(newgirl)

CREATE (person1:Person {name: 'Unallocated Person 1', role: "DEVELOPER"})
CREATE (person2:Person {name: 'Unallocated Person 2', role: "DEVELOPER"})
CREATE (person3:Person {name: 'Unallocated Person 3', role: "DEVELOPER"})
CREATE
  (person1)-[:WORKED_ON {role: "ANCHOR", startDate: "2018-07-01", endDate: "2018-07-31"}]->(office),
  (person2)-[:WORKED_ON {role: "DEVELOPER", startDate: "2018-07-01", endDate: "2018-07-31"}]->(office),
  (person3)-[:WORKED_ON {role: "DEVELOPER", startDate: "2018-07-01", endDate: "2018-07-31"}]->(office)
