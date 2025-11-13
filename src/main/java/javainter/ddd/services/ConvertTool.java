package javainter.ddd.services;

import javainter.ddd.agregates.Imc;
import javainter.ddd.dtos.ImcDto;
import javainter.ddd.valueobjects.Corpulance;

import java.time.LocalDate;

public class ConvertTool {

    public static ImcDto ToImcDto(Imc imc) {
        ImcDto dto = new ImcDto();
        dto.setCorpulanceHeight(imc.getCorpulance().getHeight());
        dto.setCorpulanceWeight(imc.getCorpulance().getWeight());
        dto.setUserName("Jean");
        dto.setInterpretation(imc.getInterpretation());
        dto.setValue(imc.getValue());

        return dto;
    }

    public static Imc ToImc(ImcDto imcDto) {
        Imc imc = new Imc(null, new Corpulance(imcDto.getCorpulanceHeight(), imcDto.getCorpulanceWeight()), LocalDate.now());

        return imc;
    }
}
