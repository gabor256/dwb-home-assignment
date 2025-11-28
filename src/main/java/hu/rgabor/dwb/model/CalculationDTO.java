package hu.rgabor.dwb.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class CalculationDTO {
    private Long id;
    private int[] input;
    private int[] result;
    private Instant timestamp;
}
