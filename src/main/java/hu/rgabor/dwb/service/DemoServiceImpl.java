package hu.rgabor.dwb.service;

import hu.rgabor.dwb.entity.Calculation;
import hu.rgabor.dwb.mapper.CalculationMapper;
import hu.rgabor.dwb.model.CalculationDTO;
import hu.rgabor.dwb.repository.CalculationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final CalculationMapper calculationMapper;
    private final CalculationRepository calculationRepository;


    @Override
    public int[] calculateResult(int[] input) {
        // Validate array
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int length = input.length;
        int[] result = new int[length];

        // Prepare multiplications left side of n
        int leftSide = 1;
        for (int i = 0; i < length; i++) {
            result[i] = leftSide;
            leftSide *= input[i];
        }
        // Prepare multiplications right side of n
        int rightSide = 1;
        for (int i = length-1; i >= 0; i--) {
            result[i] *= rightSide;
            rightSide *= input[i];
        }
        CalculationDTO calculationDTO = CalculationDTO.builder().input(input).result(result).build();
        Calculation save = calculationRepository.save(calculationMapper.toEntity(calculationDTO));
        log.info("Saved calculation: {}", save);
        return result;
    }

    @Override
    public List<CalculationDTO> getHistory(Integer lastNumbers) {
        List<Calculation> calculationList = calculationRepository.findAll();

        if (lastNumbers != null && lastNumbers > 0) {
            int startIndex = Math.max(0, calculationList.size() - lastNumbers);
            calculationList = calculationList.subList(startIndex, calculationList.size());
        }

        return calculationMapper.toDTOList(calculationList);
    }
}
