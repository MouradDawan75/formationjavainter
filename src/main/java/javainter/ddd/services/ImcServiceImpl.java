package javainter.ddd.services;

import javainter.ddd.agregates.Imc;
import javainter.ddd.dtos.ImcDto;
import javainter.ddd.repositories.ImcRepository;
import javainter.ddd.valueobjects.Corpulance;

import java.time.LocalDate;

/*
Le service manipule l'agregate
Doc ModelMapper: https://modelmapper.org/getting-started/
 */

public class ImcServiceImpl implements ImcService{

    private ImcRepository imcRepository;

    public ImcServiceImpl(ImcRepository imcRepository) {
        this.imcRepository = imcRepository;
    }

    @Override
    public ImcDto compute(Corpulance corp) {
        Imc imc = new Imc(null, corp, LocalDate.now());
        imc.computeValue();
        imc.interpreter();

        ImcDto imcDto = MapperTool.FromImc(imc);

        return imcDto;
    }

    @Override
    public String interpret(double imcValue) {
        return Imc.staticInterpreter(imcValue);
    }

    @Override
    public boolean save(ImcDto imcDto) {
        Imc imc = ConvertTool.ToImc(imcDto);
        imcRepository.save(imc);
        return true;
    }
}
