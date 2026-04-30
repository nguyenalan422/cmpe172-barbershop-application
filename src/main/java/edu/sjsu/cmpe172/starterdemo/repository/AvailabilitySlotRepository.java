package edu.sjsu.cmpe172.starterdemo.repository;

import edu.sjsu.cmpe172.starterdemo.model.AvailabilitySlot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AvailabilitySlotRepository
{

    private final JdbcTemplate jdbcTemplate;

    public AvailabilitySlotRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AvailabilitySlot> findAll()
    {
        String sql = "SELECT slot_id, barber_id, start_time, end_time, status FROM availability_slots";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new AvailabilitySlot(
                        rs.getInt("slot_id"),
                        rs.getInt("barber_id"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getString("status")
                )
        );
    }

    public int bookSlot(int slotId)
    {
        String sql = """
            UPDATE availability_slots
            SET status = 'BOOKED'
            WHERE slot_id = ? AND status = 'AVAILABLE'
            """;

        return jdbcTemplate.update(sql, slotId);
    }

    public int reopenSlot(int slotId) {
        String sql = """
            UPDATE availability_slots
            SET status = 'AVAILABLE'
            WHERE slot_id = ?
            """;

        return jdbcTemplate.update(sql, slotId);
    }
}