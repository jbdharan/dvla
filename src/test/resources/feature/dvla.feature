Feature: dvla

  #Reprot Will be generated in /target/cucumber/homeoficetest.index.html

  @dvla_excelreader
  Scenario: search vehicle number in governament stite
    Given As end user i want to open browser and enter home url
    And click on start  button
    Then read registration number from inputfolder and enter registration number validate color and make then generate report


  @dvla_datadriver
  Scenario Outline: : search vehicle number in governament stite
    Given As end user i want to open browser and enter home url
    And click on start  button
    Then Enter registration number <RegNumber> then validate made <Made> and color <Colours>

    Examples:
      | RegNumber | Made | Colours |
      |  N864PPL   |  JEEP      |  BLUE   |
      |  BK04VJF   |  MERCEDES  |  SILVER |
      |  WAZ2144  |  VOLKSWAGEN|  RED  |
      |  BK04VJF   |  MERCEDES  |  SILVER |
