automation-marketplace
======================

Test Automation using Selenium WebDriver, TestNG, ReportNG and Maven.

 JDK 6
 
 Multi browsers (Firefox and Chrome)

- Suite 1

  Test Objective:
  
  In order to show the browsing cart functionality
  
  As a user
  
  I want to browse in a gallery
  

  Scenario1: Browsing around the site for items

    Browse through a treasury gallery
    
    Buy something
    
    Browse the treasury
        
    Choose the first treasury gallery
    
    Then results will be displayed in the gallery
    

- Suite 2
  
  Test Objective:
  
  In order to show the basic cart functionality
  
  As a user
  
  I want to add and remove items from the cart
  

  Scenario 1: Item can be added to cart

    Given that the cart is empty
    
    Search for an item(a hat for example)
    
    And an item is added to the cart
    
    Then the cart contains that item
    

  Scenario 2: Item can be removed from cart

    Given the cart contains one item
    
    When the item is removed
    
    Then the cart will be empty
    

- Suite 3
  
   Test Objective:
   
   In order to show the advance cart functionality
  
   As a user
   
   I want to search for an item in a sub category
   

   Scenario 1: Advanced Search for a hat

    Searching on the marketplace
    
    When I specify the Vintage sub category
    
    Search for hat
    
    Then there are search results


   Scenario 2: Advanced Search for a ring
    
    Searching on the marketplace
    
    When I specify the Jewelry sub category
    
    Search for ring
    
    Then there are search results
    


