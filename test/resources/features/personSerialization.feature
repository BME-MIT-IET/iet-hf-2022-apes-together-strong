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