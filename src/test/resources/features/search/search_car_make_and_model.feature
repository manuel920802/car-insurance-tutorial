Feature: Search car make and model

  As an insurer
  I want potential customers to provide details about their car
  So that I can provide an accurate quote

  # Rule: Customers can search car details by their registration number


  Rule: Customers can find their car by providing the make and model
    Example: Frank is prompted for the details corresponding to his car make and model
      Given Frank wants to insure his car
      When he finds his car by make and model:
        | Make   | Model  |
        | Ford   | Focus  |
      And he provides the following additional details:
        |         Question                         |           Answer         |
        | What fuel does it run on?                |  Petrol                  |
        | Is it manual or automatic transmission?  |  Manual                  |
        | What year was it registered?             |  2022                    |
        | How big is the engine?                   |  1.0L                    |
        | What version / trim is it?               |  Titanium Ecoboost 125   |
      Then he should be proposed the following cars:
        |FORD FOCUS 2022 - 2023 Petrol 1.0L Manual 5 Doors TITANIUM ECOBOOST 125 Estate   |
        |FORD FOCUS 2022 - 2023 Petrol 1.0L Manual 5 Doors TITANIUM ECOBOOST 125 Hatchback|

  #Rule: Popular makes should be visible on the default form


  Rule: The available fuel options depend on the make and model
    Example: A Peugeot 206 comes in Diesel and Petrol
    Example: A Renault Zoe is only electric so doesn't have a fuel option