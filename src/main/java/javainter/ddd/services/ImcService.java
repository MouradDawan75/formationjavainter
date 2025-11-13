package javainter.ddd.services;

import javainter.ddd.dtos.ImcDto;
import javainter.ddd.valueobjects.Corpulance;

public interface ImcService {
    ImcDto compute(Corpulance corp);
    String interpret(double imcValue);
    boolean save(ImcDto imcDto);
}
