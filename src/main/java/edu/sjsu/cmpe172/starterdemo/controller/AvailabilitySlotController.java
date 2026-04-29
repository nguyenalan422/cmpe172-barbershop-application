package edu.sjsu.cmpe172.starterdemo.controller;
import edu.sjsu.cmpe172.starterdemo.model.AvailabilitySlot;
import edu.sjsu.cmpe172.starterdemo.service.AvailabilitySlotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AvailabilitySlotController
{

    private final AvailabilitySlotService availabilitySlotService;

    public AvailabilitySlotController(AvailabilitySlotService availabilitySlotService)
    {
        this.availabilitySlotService = availabilitySlotService;
    }

    @GetMapping("/slots")
    public List<AvailabilitySlot> getSlots()
    {
        return availabilitySlotService.getAllSlots();
    }
    
}
