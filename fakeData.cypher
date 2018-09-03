CREATE (arrested:Product {name: "Arrested Development", startDate: "2018-01-01", description: "Level-headed son Michael Bluth takes over family affairs after his father is imprisoned. But the rest of his spoiled, dysfunctional family are making his job unbearable."})
CREATE (office:Product {name: "The Office", startDate: "2018-01-01", description: "A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium."})
CREATE (friends:Product {name: "Friends", startDate: "2018-01-01", description: "Follows the personal and professional lives of six 20 to 30-something-year-old friends living in Manhattan."})
CREATE (parks:Product {name: "Parks and Recreation", startDate: "2018-01-01", description: "The absurd antics of an Indiana town's public officials as they pursue sundry projects to make their city a better place."})
CREATE (community:Product {name: "Community", startDate: "2018-01-01", description: "A suspended lawyer is forced to enroll in a community college with an eclectic staff and student body."})
CREATE (brooklyn:Product {name: "Brooklyn Nine-Nine", startDate: "2018-01-01", description: "Jake Peralta, an immature, but talented N.Y.P.D. detective in Brooklyn's 99th Precinct, comes into immediate conflict with his new commanding officer, the serious and stern Captain Ray Holt."})
CREATE (thirty:Product {name: "30 Rock", startDate: "2018-01-01", description: "Liz Lemon, head writer of the sketch comedy show \"TGS with Tracy Jordan\", must deal with an arrogant new boss and a crazy new star, all while trying to run a successful television show without losing her mind."})
CREATE (scrubs:Product {name: "Scrubs", startDate: "2018-01-01", description: "In the unreal world of Sacred Heart Hospital, intern John \"J.D.\" Dorian learns the ways of medicine, friendship, and life."})
CREATE (sunny:Product {name: "It's Always Sunny In Philadelphia", startDate: "2018-01-01", description: "Five friends with big egos and slightly arrogant attitudes are the proprietors of an Irish bar in Philadelphia."})
CREATE (newgirl:Product {name: "New Girl", startDate: "2018-01-01", description: "After a bad break-up, Jess, an offbeat young woman, moves into an apartment loft with three single men. Although they find her behavior very unusual, the men support her - most of the time."})

CREATE (george:Person {name: 'George Bluth Sr.', role: "PM"})
CREATE (michael:Person {name: 'Michael Bluth', role: "BSO"})
CREATE (georgemichael:Person {name: 'George Michael Bluth', role: "DEVELOPER"})
CREATE (buster:Person {name: 'Buster Bluth', role: "DEVELOPER"})
CREATE (lindsay:Person {name: 'Lindsay Bluth Funke', role: "DEVELOPER"})
CREATE (tobias:Person {name: 'Tobias Funke', role: "DEVELOPER"})
CREATE (maeby:Person {name: 'Maeby Funke', role: "DEVELOPER"})
CREATE (gob:Person {name: 'Gob Bluth', role: "DEVELOPER"})
CREATE (bobloblaw:Person {name: 'Bob Loblaw', role: "QA"})
CREATE (annyong:Person {name: 'Annyong Bluth', role: "QA"})
CREATE
  (george)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(arrested),
  (michael)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(arrested),
  (georgemichael)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(arrested),
  (buster)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(arrested),
  (lindsay)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(arrested),
  (tobias)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(arrested),
  (maeby)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(arrested),
  (gob)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(arrested),
  (bobloblaw)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "QA"}]->(arrested),
  (annyong)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "QA"}]->(arrested)

CREATE (michaelscott:Person {name: 'Michael Scott', role: "PM"})
CREATE (dwight:Person {name: 'Dwight Schrute', role: "BSO"})
CREATE (jim:Person {name: 'Jim Halpert', role: "DEVELOPER"})
CREATE (pam:Person {name: 'Pam Beesly', role: "DEVELOPER"})
CREATE (stanley:Person {name: 'Stanley Hudson', role: "DEVELOPER"})
CREATE (kevin:Person {name: 'Kevin Malone', role: "DEVELOPER"})
CREATE (angela:Person {name: 'Angela Martin', role: "DEVELOPER"})
CREATE (andyb:Person {name: 'Andy Bernard', role: "DEVELOPER"})
CREATE (kelly:Person {name: 'Kelly Kapoor', role: "QA"})
CREATE
  (michaelscott)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(office),
  (dwight)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(office),
  (jim)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(office),
  (pam)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(office),
  (stanley)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(office),
  (kevin)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(office),
  (angela)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(office),
  (andyb)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(office),
  (kelly)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "QA"}]->(office)

CREATE (rachel:Person {name: 'Rachel Green', role: "PM"})
CREATE (chandler:Person {name: 'Chandler Bing', role: "BSO"})
CREATE (monica:Person {name: 'Monica Geller', role: "DEVELOPER"})
CREATE (ross:Person {name: 'Ross Geller', role: "DEVELOPER"})
CREATE (joey:Person {name: 'Joey Tribbiani', role: "DEVELOPER"})
CREATE (phoebe:Person {name: 'Phoebe Buffay', role: "DEVELOPER"})
CREATE
  (rachel)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(friends),
  (chandler)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(friends),
  (monica)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(friends),
  (ross)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(friends),
  (joey)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(friends),
  (phoebe)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(friends)

CREATE (leslie:Person {name: 'Leslie Knope', role: "PM"})
CREATE (ron:Person {name: 'Ron Swanson', role: "BSO"})
CREATE (ben:Person {name: 'Ben Wyatt', role: "DEVELOPER"})
CREATE (april:Person {name: 'April Ludgate', role: "DEVELOPER"})
CREATE (andy:Person {name: 'Andy Dwyer', role: "DEVELOPER"})
CREATE (ann:Person {name: 'Ann Perkins', role: "DEVELOPER"})
CREATE (chris:Person {name: 'Chris Traeger', role: "DEVELOPER"})
CREATE (tom:Person {name: 'Tom Haverford', role: "DESIGNER"})
CREATE
  (leslie)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(parks),
  (ron)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(parks),
  (ben)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(parks),
  (april)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(parks),
  (andy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(parks),
  (ann)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(parks),
  (chris)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(parks),
  (tom)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DESIGNER"}]->(parks)

CREATE (craig:Person {name: 'Craig Pelton', role: "PM"})
CREATE (jeff:Person {name: 'Jeff Winger', role: "BSO"})
CREATE (abed:Person {name: 'Abed Nadir', role: "DEVELOPER"})
CREATE (annie:Person {name: 'Annie Edison', role: "DEVELOPER"})
CREATE (troy:Person {name: 'Troy Barnes', role: "DEVELOPER"})
CREATE (britta:Person {name: 'Britta Perry', role: "DEVELOPER"})
CREATE (shirley:Person {name: 'Shirley Bennett', role: "QA"})
CREATE
  (craig)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(community),
  (jeff)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(community),
  (abed)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(community),
  (annie)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(community),
  (troy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(community),
  (britta)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(community),
  (shirley)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "QA"}]->(community)

CREATE (ray:Person {name: 'Ray Holt', role: "PM"})
CREATE (jake:Person {name: 'Jake Peralta', role: "BSO"})
CREATE (amy:Person {name: 'Amy Santiago', role: "DEVELOPER"})
CREATE (rosa:Person {name: 'Rosa Diaz', role: "DEVELOPER"})
CREATE (terry:Person {name: 'Terry Jeffords', role: "DEVELOPER"})
CREATE (charles:Person {name: 'Charles Boyle', role: "DEVELOPER"})
CREATE (gina:Person {name: 'Gina Linetti', role: "DESIGNER"})
CREATE
  (ray)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(brooklyn),
  (jake)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(brooklyn),
  (amy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(brooklyn),
  (rosa)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(brooklyn),
  (terry)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(brooklyn),
  (charles)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(brooklyn),
  (gina)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DESIGNER"}]->(brooklyn)

CREATE (liz:Person {name: 'Liz Lemon', role: "PM"})
CREATE (jack:Person {name: 'Jack Donaghy', role: "BSO"})
CREATE (kenneth:Person {name: 'Kenneth Parcell', role: "DEVELOPER"})
CREATE (jenna:Person {name: 'Jenna Maroney', role: "DEVELOPER"})
CREATE (tracy:Person {name: 'Tracy Jordan', role: "DEVELOPER"})
CREATE (frank:Person {name: 'Frank Rossitano', role: "DEVELOPER"})
CREATE
  (liz)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(thirty),
  (jack)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(thirty),
  (kenneth)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(thirty),
  (jenna)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(thirty),
  (tracy)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(thirty),
  (frank)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(thirty)

CREATE (john:Person {name: 'John Dorian', role: "PM"})
CREATE (christopher:Person {name: 'Christopher Turk', role: "BSO"})
CREATE (elliot:Person {name: 'Elliot Reid', role: "ANCHOR"})
CREATE (perry:Person {name: 'Perry Cox', role: "DEVELOPER"})
CREATE (bob:Person {name: 'Bob Kelso', role: "DEVELOPER"})
CREATE (carla:Person {name: 'Carla Espinosa', role: "DEVELOPER"})
CREATE
  (john)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(scrubs),
  (christopher)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(scrubs),
  (elliot)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(scrubs),
  (perry)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(scrubs),
  (bob)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(scrubs),
  (carla)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(scrubs)

CREATE (charlie:Person {name: 'Charlie Kelly', role: "PM"})
CREATE (mac:Person {name: 'Mac McDonald', role: "BSO"})
CREATE (dennis:Person {name: 'Dennis Reynolds', role: "DEVELOPER"})
CREATE (dee:Person {name: 'Dee Reynolds', role: "DEVELOPER"})
CREATE (frankreynolds:Person {name: 'Frank Reynolds', role: "DEVELOPER"})
CREATE (artemis:Person {name: 'Artemis Dubois', role: "DEVELOPER"})
CREATE (rickety:Person {name: 'Rickety Cricket', role: "QA"})
CREATE
  (charlie)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(sunny),
  (mac)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(sunny),
  (dennis)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(sunny),
  (dee)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(sunny),
  (frankreynolds)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(sunny),
  (artemis)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(sunny),
  (rickety)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "QA"}]->(sunny)

CREATE (jessica:Person {name: 'Jessica Day', role: "PM"})
CREATE (nick:Person {name: 'Nick Miller', role: "BSO"})
CREATE (schmidt:Person {name: 'Schmidt', role: "DEVELOPER"})
CREATE (winston:Person {name: 'Winston Bishop', role: "DEVELOPER"})
CREATE (cece:Person {name: 'Cece Parikh', role: "DEVELOPER"})
CREATE (sam:Person {name: 'Sam Sweeney', role: "DEVELOPER"})
CREATE
  (jessica)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "PM"}]->(newgirl),
  (nick)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "BSO"}]->(newgirl),
  (schmidt)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "ANCHOR"}]->(newgirl),
  (winston)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(newgirl),
  (cece)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(newgirl),
  (sam)-[:WORKED_ON {startDate: "2018-08-01", endDate: "2999-12-31", role: "DEVELOPER"}]->(newgirl)

//currently unallocated
CREATE (person1:Person {name: 'Unallocated Person 1', role: "DEVELOPER"})
CREATE (person2:Person {name: 'Unallocated Person 2', role: "DEVELOPER"})
CREATE (person3:Person {name: 'Unallocated Person 3', role: "DEVELOPER"})
CREATE
  (person1)-[:WORKED_ON {startDate: "2018-07-01", endDate: "2018-07-31", role: "ANCHOR"}]->(office),
  (person2)-[:WORKED_ON {startDate: "2018-07-01", endDate: "2018-07-31", role: "DEVELOPER"}]->(office),
  (person3)-[:WORKED_ON {startDate: "2018-07-01", endDate: "2018-07-31", role: "DEVELOPER"}]->(office)

//crossover episodes
CREATE
  (jessica)-[:WORKED_ON {startDate: "2018-03-01", endDate: "2018-07-31", role: "PM"}]->(brooklyn),
  (jake)-[:WORKED_ON {startDate: "2018-03-01", endDate: "2018-07-31", role: "BSO"}]->(newgirl),
  (gina)-[:WORKED_ON {startDate: "2018-03-01", endDate: "2018-07-31", role: "DESIGNER"}]->(newgirl),
  (ray)-[:WORKED_ON {startDate: "2018-03-01", endDate: "2018-07-31", role: "PM"}]->(newgirl),
  (charles)-[:WORKED_ON {startDate: "2018-03-01", endDate: "2018-07-31", role: "DEVELOPER"}]->(newgirl)