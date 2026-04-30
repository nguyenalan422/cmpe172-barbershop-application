package edu.sjsu.cmpe172.starterdemo.repository;

import edu.sjsu.cmpe172.starterdemo.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AppointmentRepository
{
    private final JdbcTemplate jdbcTemplate;

    public AppointmentRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Appointment> findAll()
    {
        String sql = """
                SELECT appointment_id,
                       client_id,
                       barber_id,
                       service_id,
                       slot_id,
                       status,
                       time_booked
                FROM appointments
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Appointment(
                        rs.getInt("appointment_id"),
                        rs.getInt("client_id"),
                        rs.getInt("barber_id"),
                        rs.getInt("service_id"),
                        rs.getInt("slot_id"),
                        rs.getString("status"),
                        rs.getString("time_booked")
                )
        );
    }

    public void createAppointment(int clientId, int barberId, int serviceId, int slotId) {
        String sql = """
            INSERT INTO appointments
            (client_id, barber_id, service_id, slot_id, status, time_booked)
            VALUES (?, ?, ?, ?, 'BOOKED', datetime('now'))
            """;

        jdbcTemplate.update(sql, clientId, barberId, serviceId, slotId);
    }

    public int cancelAppointment(int appointmentId) {
        String sql = """
            UPDATE appointments
            SET status = 'CANCELLED'
            WHERE appointment_id = ? AND status = 'BOOKED'
            """;

        return jdbcTemplate.update(sql, appointmentId);
    }

    public Appointment findById(int appointmentId)
    {
        String sql = """
            SELECT appointment_id,
                   client_id,
                   barber_id,
                   service_id,
                   slot_id,
                   status,
                   time_booked
            FROM appointments
            WHERE appointment_id = ?
            """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                        new Appointment(
                                rs.getInt("appointment_id"),
                                rs.getInt("client_id"),
                                rs.getInt("barber_id"),
                                rs.getInt("service_id"),
                                rs.getInt("slot_id"),
                                rs.getString("status"),
                                rs.getString("time_booked")
                        ),
                appointmentId
        );
    }
}