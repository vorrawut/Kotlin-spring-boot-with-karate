Feature: Data-Driven Shopping Cart API Testing

  Scenario Outline: Add different items to the cart
    Given url 'http://localhost:8080/cart/add'
    And request { id: <id>, name: '<name>', quantity: <quantity>, price: <price> }
    When method post
    Then status 200
    * print response
    And match response == 'Item added to cart successfully'

    Examples:
      | id | name      | quantity | price  |
      | 2  | "USB"     | 1        | 999.99 |
      | 3  | "Mouse"   | 2        | 25.00  |
      | 4  | "Keyboard"| 1        | 50.00  |