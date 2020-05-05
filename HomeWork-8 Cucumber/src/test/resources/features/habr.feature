Feature: habr

  @Test
  Scenario: Preview authorization page
    Given Open main Habr page
    When Click Login button
    Then Check auth page

  @Test
  Scenario: Preview registration page
    Given Open main Habr page
    When Click Registration button
    Then Check reg page

  @Test
  Scenario: Change language to interface
    Given Open main Habr page
    And Save title page
    And Click LanguageChange button
    And Click ratio button English
    When Save language settings
    Then Check English language to interface
    And Click LanguageChange button
    And Click ratio button Russian
    When Save language settings
    Then Check Russian language to interface
