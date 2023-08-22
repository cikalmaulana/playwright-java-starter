Feature: The test of opening google

@FirstScenarios
Scenario: Try to opening google on chrome
  Given access google and search:
    | keywords   | isImage |
    | google     | false   |
    | facebook   | false   |
    | bill gates | true    |