Feature: example

  Scenario Outline: User adds person to graph
    Given User created a person named <Michael Grove>
    When User adds the person to a graph
    Then The person exist
      And The graph has <element> element
    Examples:
      | Michael Grove   | element |
      | "Michael Grove" | 1       |


  Scenario Outline: User gets person from graph
    Given User created a person named <Michael Grove>
      And Added it to a graph
    When User copies the person from graph
    Then The original and the copy equals
    Examples:
      | Michael Grove   |
      | "Michael Grove" |


  Scenario Outline: User loads from file
    Given User created a graph from <file>
    When the user loads a <class with primitives>
    Then we expect the loaded class to have a <number>
      And has <another number>
      And they equal
    Examples:
      | file                           | class with primitives                                    | number | another number |
      | "/data/primitive_rdf_lists.nt" | "tag:complexible:pinto:9017b0ab9335e4d090290a0dffc81826" | 4      | 5              |
    
    
  Scenario Outline: We load in a new model
    Given a graph in <location>
    When we create a new class with object list
      And we add a person named <Earl Weaver> to the collection
      And we add a person named <Brooks Robinson> to the collection
      And we add a person named <JJ Hardy> to the set
      And we add a person named <Manny Machado> to the set
      And we add a person named <Alejandro De Aza> to the list
      And we add a person named <Adam Jones> to the list
      And we add a person named <Steve Pearce> to the sorted set
      And we add a person named <Zach Britton> to the sorted set
    Then the created class equals the class on the graph with the tag: <tag>
    Examples:
    | location                | Earl Weaver   | Brooks Robinson   | JJ Hardy   | Manny Machado   | Alejandro De Aza   | Adam Jones   | Steve Pearce   | Zach Britton   | tag |
    | "/data/object_lists.nt" | "Earl Weaver" | "Brooks Robinson" | "JJ Hardy" | "Manny Machado" | "Alejandro De Aza" | "Adam Jones" | "Steve Pearce" | "Zach Britton" | "tag:complexible:pinto:881b2f11232944aeda9ba543e030dcfc" |


  Scenario Outline: User serializes annotation
    Given a company named <Clark & Parsia>
      And has a <website>
    When the user creates a graph with the company
    Then the content of the graph equals the content of <file>
    Examples:
    | Clark & Parsia   | website                  | file               |
    | "Clark & Parsia" | "http://clarkparsia.com" | "/data/company.nt" |