package hu.rgabor.dwb.repository;


import hu.rgabor.dwb.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository <Calculation, Long>{
}
