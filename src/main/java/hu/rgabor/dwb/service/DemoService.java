package hu.rgabor.dwb.service;

import hu.rgabor.dwb.model.CalculationDTO;

import java.util.List;

public interface DemoService {
    int[] calculateResult(int[] input);

    List<CalculationDTO>  getHistory(Integer lastNumbers);
}
