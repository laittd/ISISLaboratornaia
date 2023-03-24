package ru.bstu.itz.cherepchenko.lab1;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Expression {
    int start;
    int end;

    public Expression(int start, int end) {
        this.start = start;
        this.end = end;
    }

//     public List<Integer> getAllYs(){
//        List<Integer> Ys = new ArrayList<>();
//        for (int x=start; x<end; x++)
//            Ys.add(x*x+x+17);
//        return Ys;
//    }

    public List<Integer> getAllYs(){
        List<Integer> Ys = new ArrayList<>();
        int x = start;
        while (end > x) {
            Ys.add(x * x + x + 17);
            x++;
        }
        return Ys;
    }



    protected boolean isSimple(int ANum) {
        if (ANum < 2)
            return false;
        double s = sqrt(ANum);
        for (int i = 2; i <= s; i++) {
            if (ANum % i == 0)
                return false;
        }
        return true;
    }

    public boolean isSimpleList(List<Integer> numbers) {
        for (Integer number : numbers)
            if (!isSimple(number))
                return false;
        return true;
    }
}
