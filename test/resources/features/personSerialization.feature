Feature: example

  Scenario Outline: Adding person to graph
    Given A person named <Michael Grove>
    And We add them to a graph
    When They exist
    When The graph has <element> element
    And We can copy them from the graph
    Then The original and the copy equals
    Examples:
      | Michael Grove   | element |
      | "Michael Grove" | 1       |
