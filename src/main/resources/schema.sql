CREATE TABLE IF NOT EXISTS availability_slots (
    slot_id INTEGER PRIMARY KEY,
    barber_id INTEGER NOT NULL,
    start_time TEXT NOT NULL,
    end_time TEXT NOT NULL,
    status TEXT NOT NULL
);

INSERT OR IGNORE INTO availability_slots
(slot_id, barber_id, start_time, end_time, status)
    VALUES
    (1, 1, '09:00', '09:30', 'AVAILABLE'),
    (2, 1, '09:30', '10:00', 'AVAILABLE'),
    (3, 2, '10:00', '10:30', 'AVAILABLE');


CREATE TABLE IF NOT EXISTS appointments (
    appointment_id INTEGER PRIMARY KEY,
    client_id INTEGER NOT NULL,
    barber_id INTEGER NOT NULL,
    service_id INTEGER NOT NULL,
    slot_id INTEGER,
    status TEXT NOT NULL,
    time_booked TEXT NOT NULL,
    FOREIGN KEY (slot_id) REFERENCES availability_slots(slot_id)
);

INSERT OR IGNORE INTO appointments
(appointment_id, client_id, barber_id, service_id, slot_id, status, time_booked)
    VALUES
    (1, 1, 1, 1, 1, 'BOOKED', '2026-03-07 10:00'),
    (2, 2, 1, 2, 2, 'CANCELLED', '2026-03-07 11:00');