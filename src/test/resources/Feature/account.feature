Feature: New Account in facebook
Background: Create a new account in facebook
Given Launch browser and facebook "https://www.facebook.com/"
When Click create a new account

Scenario Outline:
And Enter firstname and lastname "<firstname>" "<lastname>"
And Select dateofbirth "<date>" "<month>" "<year>"
And Select Gender "<Gender>"
And Enter id "<id>"
And Enter password "<password>"
And Click register
Then TakeScreenShot of the page "<firstname>"
Examples:
|firstname|lastname|date|month|year|Gender|id                |password     |
|John     |Cena    |23  |4    |1977|Male  |johncena@wwf.com  |Ucantcme     |
|Dwayne   |Johnson |2   |5    |1972|Male  |dwarock           |RockisCooking|
|Maria    |        |25  |2    |1982|Female|mariakane@wwf.com |Tatuta       |
|Randy    |Orton   |1   |4    |1980|Male  |randyortan@wwf.com|Rko          |