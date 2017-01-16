Feature: Manager    

  Scenario: get name of manager
    Given WebContext
    When URL "/manager/name" is called
    Then "Marcin Miotk" body is returned
