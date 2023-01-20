package com.salesianostriana.dam.restquery.search.spec;

import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class GenericSpecificationBuilder<T> {

    private final List<SearchCriteria> params;

    public GenericSpecificationBuilder(List<SearchCriteria> params){

        this.params = params;
    }

    public Specification<T> build(){

        if (params.isEmpty()){

            return null;
        }

        Specification<T> result = new GenericSpecification<T>(params.get(0));

        for (int i = 1; i < params.size(); i++){

            result = result.and(new GenericSpecification<T>(params.get(i)));
        }

        return result;
    }
}
