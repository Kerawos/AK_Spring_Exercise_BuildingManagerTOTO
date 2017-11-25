#Java Basic by AkademiaKodu.pl 2017

Your task is to implement or repair methods "//todo" to proper work of application. 

[1]. totalCostCalculator:
- throw an exception in case where office levels are not presented;
- calculate service level need by divide office levels by ServicesNeedPerOfficeLevel;

*-*-*-*-*-*

[2]. Cost Of Roof:
- throw a exceptions in case where area level are not greater than 0;
- throw a exceptions in case where area level are reach maximum allowed space;
- calculation formula is by multiply area level by 'CostMaterialRoofPerAreaMeter';

*-*-*-*-*-*

[3]. Cost of foundation:
- throw a exceptions in case where area level are not greater than 0;
- throw a exceptions in case where area level are reach maximum allowed space;
- throw a exceptions in case where counted floors are below 0;
- throw a exceptions in case where total floors are reach maximum allowed space;
- the rate of 'CostFoundationPerFloor' will increases (by multiply per self) in every building level (included also underground levels);
- total cost of foundation formula = area level * CostMaterialFloorPerAreaMeter * CostFoundationPerFloor;

*-*-*-*-*-*

[4]. Total Cost Underground Level:
- underground levels are very expansive, they cost drastically increase in every floor. In every level 'CostFoundationPerFloor'
are multiply by self. Cost of next underground floor are more expansive of this CostFoundationPerFloor.

*-*-*-*-*-*

[5]. Total Cost Calculator:
- set proper amount of toilets in building;
- set proper amount of rooms in building;
- remember that toilets and rooms are very connected. Rooms and toilets have to counted in same time because if rooms 
and toilets take some space from area level. You have to count lot of possibilities and set which possibility is most optimal,
means: maximum rooms and only minimum toilets, f.e: for 488 rooms only 15 toilets are needed.

*-*-*-*-*-*


Good Luck!



 
