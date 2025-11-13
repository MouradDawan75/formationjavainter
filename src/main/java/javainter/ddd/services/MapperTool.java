package javainter.ddd.services;

import javainter.ddd.agregates.Imc;
import javainter.ddd.dtos.ImcDto;
import org.modelmapper.ModelMapper;

public class MapperTool {
    private static ModelMapper mapper = new ModelMapper();

    public static ImcDto FromImc(Imc imc){
        return mapper.map(imc, ImcDto.class);
    }

    //méthode générique de mapping

    public static <Source,Destination> Destination convert(Source src, Class<Destination> clazz){
        return mapper.map(src, clazz);
    }
}
