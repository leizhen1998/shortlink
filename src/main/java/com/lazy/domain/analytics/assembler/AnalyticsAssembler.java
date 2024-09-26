package com.lazy.domain.analytics.assembler;

import com.lazy.domain.analytics.entity.Analytics;
import com.lazy.domain.analytics.repository.po.AnalyticsPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnalyticsAssembler {
    AnalyticsAssembler INSTANCE = Mappers.getMapper(AnalyticsAssembler.class);

    @Mapping(source = "location", target = ".")
    @Mapping(source = "userAgent", target = ".")
    AnalyticsPO toPO(Analytics analytics);
}
