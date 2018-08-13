package com.in28minutes.rest.webservices.restfulwebservices.util;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public final class FilterUtil {

    public static MappingJacksonValue getFilter(final Object object, final String filterName, final String... fields) {
        final SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        final FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
        final MappingJacksonValue mapping = new MappingJacksonValue(object);
        mapping.setFilters(filters);
        return mapping;
    }

}
