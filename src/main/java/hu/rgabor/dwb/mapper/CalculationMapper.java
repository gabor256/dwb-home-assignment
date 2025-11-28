package hu.rgabor.dwb.mapper;

import hu.rgabor.dwb.entity.Calculation;
import hu.rgabor.dwb.model.CalculationDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class CalculationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    @Mapping(target = "inputArray", ignore = true)
    @Mapping(target = "resultArray", ignore = true)
    public abstract CalculationDTO toDTO(Calculation calculation);

    @AfterMapping
    public void toDTO(Calculation calculation, CalculationDTO dto){
        dto.setInput(calculation.getInputArrayAsIntArray());
        dto.setResult(calculation.getResultArrayAsIntArray());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    @Mapping(target = "inputArray", ignore = true)
    @Mapping(target = "resultArray", ignore = true)
    public abstract Calculation toEntity(CalculationDTO dto);

    @AfterMapping
    public void toEntity(CalculationDTO dto, Calculation entity){
        entity.setInputArray(dto.getInput());
        entity.setResultArray(dto.getResult());
    }
}
