automation-marketplace
======================

Test Automation using Selenium WebDriver, TestNG, ReportNG and Maven

- Suite 1

  Test Objective:\n 
  In order to show the browsing cart functionality\n
  As a user\n
  I want to browse in a gallery\n

  Scenario1: Browsing around the site for items

    Browse through a treasury gallery\n
    Buy something\n
    Browse the treasury\n
    Choose the first treasury gallery\n
    Then results will be displayed in the gallery\n

- Suite 2
  
  Test Objective:\n
  In order to show the basic cart functionality\n
  As a user\n
  I want to add and remove items from the cart\n

  Scenario 1: Item can be added to cart

    Given that the cart is empty\n
    Search for an item(a hat for example)\n
    And an item is added to the cart\n
    Then the cart contains that item\n

  Scenario 2: Item can be removed from cart

    Given the cart contains one item\n
    When the item is removed\n
    Then the cart will be empty\n

- Suite 3
   
   Test Objective:\n
   In order to show the advance cart functionality\n
   As a user\n
   I want to search for an item in a sub category\n

   Scenario 1: Advanced Search for a hat

    Searching on the marketplace\n
    When I specify the Vintage sub category\n
    Search for hat\n
    Then there are search results\n

   Scenario 2: Advanced Search for a ring
    
    Searching on the marketplace\n
    When I specify the Jewelry sub category\n
    Search for ring\n
    Then there are search results\n


