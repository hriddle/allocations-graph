CREATE (fullBoyle:Product {name: 'Full Boyle'})
CREATE (puzzleMaster:Product {name: 'The Puzzle Master'})
CREATE (terryKitties:Product {name: 'Terry Kitties'})
CREATE (coralPalms:Product {name: 'Coral Palms'})

CREATE (Jake:Person {name: 'Jake'})
CREATE (Amy:Person {name: 'Amy'})
CREATE (Terry:Person {name: 'Terry'})
CREATE (Rosa:Person {name: 'Rosa'})

CREATE
  (Jake)-[:WORKED_ON {durationInWeeks: 12}]->(puzzleMaster),
  (Jake)-[:WORKED_ON {durationInWeeks: 12}]->(fullBoyle),
  (Jake)-[:WORKED_ON {durationInWeeks: 12}]->(terryKitties),
  (Amy)-[:WORKED_ON {durationInWeeks: 12}]->(fullBoyle),
  (Amy)-[:WORKED_ON {durationInWeeks: 12}]->(terryKitties),
  (Terry)-[:WORKED_ON {durationInWeeks: 12}]->(terryKitties)