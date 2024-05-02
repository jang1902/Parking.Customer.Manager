package core.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingAreaDto {
    private Long id;
    private String name;
    private String type;
    private int total_space;
    private int priority_space;
    private int remaining_space;
    private int remaining_priority_space;
    private int parking_lot_id;

}
