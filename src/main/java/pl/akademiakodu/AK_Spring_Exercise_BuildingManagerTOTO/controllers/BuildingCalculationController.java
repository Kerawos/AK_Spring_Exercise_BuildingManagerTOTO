package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.Building;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.BuildingManager;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.UserInput;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.services.Converter;


@Controller
public class BuildingCalculationController {

    @Autowired
    private BuildingManager buildingManager;

    @Autowired
    private Converter converter;

    @GetMapping("/build") public String buildingGet(Model model){
        model.addAttribute("userInput", new UserInput());
        return "build";
    }

    @PostMapping("/build") public String buildingPost(@ModelAttribute("userInput") UserInput userInput, Model model){
        Building potentialBuilding = new Building();
        potentialBuilding = buildingManager.totalCostCalculator(converter.stringIntoInteger(userInput.getWidth()),
                converter.stringIntoInteger(userInput.getLength()), converter.stringIntoInteger(userInput.getFloors()),
                converter.stringIntoInteger(userInput.getUndergroundFloors()));
        model.addAttribute("info", "Your Potential Building: ");
        model.addAttribute("width", "width: " + potentialBuilding.getWidth());
        model.addAttribute("length", "length: " + potentialBuilding.getLength());
        model.addAttribute("floors", "floors: " + potentialBuilding.getFloors());
        model.addAttribute("undergroundFloors", "underground floors: " + potentialBuilding.getUndergroundFloors());
        model.addAttribute("totalBuildingArea", "total Building Space: " + potentialBuilding.getTotalBuildingArea());
        model.addAttribute("officeLevel", "office levels: " + potentialBuilding.getOfficeLevel());
        model.addAttribute("parkingLevel", "parking levels: " + potentialBuilding.getParkingLevel());
        model.addAttribute("serviceLevel", "service levels: " + potentialBuilding.getServiceLevel());
        model.addAttribute("gastroLevel", "gastro levels: " + potentialBuilding.getGastroLevel());
        model.addAttribute("elevator", "elevators: " + potentialBuilding.getElevator());
        model.addAttribute("rooms", "rooms: " + potentialBuilding.getRooms());
        model.addAttribute("straits", "straits: " + potentialBuilding.getStraits());
        model.addAttribute("toilets", "toilets: " + potentialBuilding.getToilets());
        model.addAttribute("potentialWorkers", "potential workers: " + potentialBuilding.getPotentialWorkers());
        model.addAttribute("potentialBuildingCost", "potential building cost: " + potentialBuilding.getPotentialBuildingCost());
        model.addAttribute("potentialMonthlyCharges", "potential monthly charges: " + potentialBuilding.getPotentialMonthlyCharges());
        return "build";
    }

}
