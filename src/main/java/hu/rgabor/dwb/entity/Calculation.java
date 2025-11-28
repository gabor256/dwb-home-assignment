package hu.rgabor.dwb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Table(name = "calculation")
@Getter
@Setter
@NoArgsConstructor
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="input_array")
    private String inputArray;

    @Column(name ="result_array")
    private String resultArray;

    @CreationTimestamp
    private Instant timestamp;

    public int[] getInputArrayAsIntArray() {
        return inputArray == null || inputArray.isEmpty()
                ? new int[0]
                : Arrays.stream(inputArray.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int[] getResultArrayAsIntArray() {
        return resultArray == null || resultArray.isEmpty()
                ? new int[0]
                : Arrays.stream(resultArray.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public void setInputArray(int[] inputArray) {
        this.inputArray = inputArray == null
                ? ""
                : Arrays.stream(inputArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public void setResultArray(int[] resultArray) {
        this.resultArray = resultArray == null
                ? ""
                : Arrays.stream(resultArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }



}
