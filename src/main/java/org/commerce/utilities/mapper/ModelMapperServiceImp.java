package org.commerce.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperServiceImp implements ModelMapperService {
    private final ModelMapper _modelMapper;

    @Autowired
    public ModelMapperServiceImp(ModelMapper modelMapper){
        this._modelMapper=modelMapper;
    }
    @Override
    public ModelMapper forRequest() {
        this._modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return _modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        this._modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return _modelMapper;
    }
}
