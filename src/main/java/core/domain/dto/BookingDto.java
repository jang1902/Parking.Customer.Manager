package core.domain.dto;

import java.time.LocalDateTime;

public class BookingDto {
    private Long id;
    private LocalDateTime estimated_starttime;
    private LocalDateTime estimated_endtime;
    private Long parking_area_id;
    private Long vehicle_id;
}
