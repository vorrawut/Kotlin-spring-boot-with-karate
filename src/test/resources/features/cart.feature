Feature: API Testing for Shopping Cart

  Scenario: Add an item to the cart
    Given url 'http://localhost:8080/cart/add'
    And request { "id": 1, "name": "Laptop", "quantity": 1, "price": 999.99 }
    When method post
    Then status 200
    And match response == 'Item added to cart'

  Scenario: Retrieve cart items
    Given url 'http://localhost:8080/cart'
    When method get
    Then status 200
    And match response[0].name == 'Laptop'

  Scenario: Remove an item from the cart
    Given url 'http://localhost:8080/cart/remove/1'
    When method delete
    Then status 200
    And match response == 'Item removed from cart'