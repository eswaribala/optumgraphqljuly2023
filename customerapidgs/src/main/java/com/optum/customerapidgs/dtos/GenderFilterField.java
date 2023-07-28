package com.optum.customerapidgs.dtos;

import com.optum.customerapidgs.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderFilterField {

    private String operator;
    private Gender value;


    public Predicate generateCriteria(CriteriaBuilder builder, Path field) {
        try {
           // int v = Integer.parseInt(value);
            switch (operator) {
             //   case "lt": return builder.lt(field, v);
             //   case "le": return builder.le(field, v);
             //   case "gt": return builder.gt(field, v);
             //   case "ge": return builder.ge(field, v);
                case "eq": return builder.equal(field, value);
            }
        } catch (NumberFormatException e) {
            switch (operator) {
                case "endsWith": return builder.like(field, "%" + value);
                case "startsWith": return builder.like(field, value + "%");
                case "contains": return builder.like(field, "%" + value + "%");
                case "eq": return builder.equal(field, value);
            }
        }

        return null;
    }
}
