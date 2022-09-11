package model.comparator;

import java.util.Comparator;
import model.*;

public class OrdenaTimes implements Comparator<Time>{

    @Override
    public int compare(Time a, Time b) {
        if(a.getPontos() < b.getPontos())
            return 1;
        if(a.getPontos() > b.getPontos())
            return -1;
        else{
            if(a.getSaldGols() > b.getSaldGols())
                return 1;
            if(a.getSaldGols() < b.getSaldGols())
                return -1;
            else
                return 1;
        } 
    }
}
