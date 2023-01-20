package com.salesianostriana.dam.restquery.search.spec;

import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenericSpecification<T> implements Specification<T> {
    public GenericSpecification(SearchCriteria searchCriteria) {
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
