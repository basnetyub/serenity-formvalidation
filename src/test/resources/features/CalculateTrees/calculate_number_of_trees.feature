Business Need: Calculate the number of Trees

#  Not a good BDD scenario
  Scenario Template: Form Validation
    Given User is on a calculate page
    When User enters the required values
      | Number Of Seed   | Name   | Time   | Tree Type   |
      | <Number Of Seed> | <Name> | <Time> | <Tree Type> |
    And calculates number of trees
    Then User should get "<Validation Error>" message
    Examples:
      | Number Of Seed | Name          | Time     | Tree Type | Validation Error              |
      | 0              | Yubraj Basnet | 11:12 pm | Two       | The seeds must be at least 1. |
      | -1             | Yubraj Basnet | 11:12 pm | Two       | The seeds must be at least 1. |
      | 10             | yub jr.       | 11:12 pm | Two       | The name format is invalid.   |
      | 10             |               | 11:12 pm | Two       | The name field is required.   |
      | 10             | yub           | 11:12 pm |           | The type field is required.   |

  Scenario Template: Calculating The Number of Trees Using Default Calculation Method
    Given User is on a calculate page
    When User enters the required values
      | Number Of Seed   | Name   | Time   | Tree Type   |
      | <Number Of Seed> | <Name> | <Time> | <Tree Type> |
    And calculate number of trees using default method
    Then User should see the result "<Result>"
    Examples:
      | Number Of Seed | Name          | Time     | Tree Type | Result                              |
      | 1              | Yubraj Basnet | 11:12 pm | Two       | Your result is 0.2, Yubraj Basnet!  |
      | 999999         | Adam          | 12:00 am | One       | Your result is 99999.9, Adam!       |
      | 098            | Oliver D King | 12:00 am | Three     | Your result is 29.4, Oliver D King! |

  Scenario Template: Calculating The Number of Trees Using Alternate Calculation Method
    Given User is on a calculate page
    When User enters the required values
      | Number Of Seed   | Name   | Time   | Tree Type   |
      | <Number Of Seed> | <Name> | <Time> | <Tree Type> |
    And calculate number of trees using alternate method
    Then User should see the result "<Result>"
    Examples:
      | Number Of Seed | Name          | Time     | Tree Type | Result                              |
      | 1              | Yubraj        | 11:12 pm | Two       | Your result is 0.4, Yubraj!         |
      | 999999         | Adam          | 12:00 am | One       | Your result is 199999.8, Adam!      |
      | 098            | Oliver D King | 12:00 am | Three     | Your result is 58.8, Oliver D King! |