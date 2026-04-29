package edu.sjsu.cmpe172.starterdemo.service;

import edu.sjsu.cmpe172.starterdemo.model.AvailabilitySlot;
import edu.sjsu.cmpe172.starterdemo.repository.AvailabilitySlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilitySlotService {

    private final AvailabilitySlotRepository availabilitySlotRepository;

    public AvailabilitySlotService(AvailabilitySlotRepository availabilitySlotRepository) {
        this.availabilitySlotRepository = availabilitySlotRepository;
    }

    public List<AvailabilitySlot> getAllSlots() {
        return availabilitySlotRepository.findAll();
    }

//    public boolean isSlotAvailable(int slotId) {
//        // Simulated check (for screenshot)
//        String status = "AVAILABLE";
//
//        return "AVAILABLE".equals(status);
//    }
}
