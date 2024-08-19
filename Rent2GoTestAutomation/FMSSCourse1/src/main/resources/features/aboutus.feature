Feature: Enterprise pages text and images verification

  @aboutus, @smoke
  Scenario: Verify text and images
    Given User lands on enterprise page with this "FMSS Future Mobile Software Solutions" title and this "Enterprise page should have title"
    Given User clicks "Hakkimizda" page under "Kurumsal"
    When User reads text
    And User verifies text as
