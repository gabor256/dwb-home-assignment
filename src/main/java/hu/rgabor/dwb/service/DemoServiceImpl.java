package hu.rgabor.dwb.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

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
        return result;
    }

    @Override
    public List<int[]> getHistory() {
        return List.of();
    }
}
