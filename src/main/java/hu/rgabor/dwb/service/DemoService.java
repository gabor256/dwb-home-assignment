package hu.rgabor.dwb.service;

import java.util.List;

public interface DemoService {
    int[] calculateResult(int[] input);

    List<int[]> getHistory();
}
