package com.lazy.domain.shortlink.assembler;

import com.lazy.domain.shortlink.entity.ShortLink;
import com.lazy.domain.shortlink.repository.po.ShortLinkPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShortLinkAssembler {
    ShortLinkAssembler INSTANCE = Mappers.getMapper(ShortLinkAssembler.class);

    ShortLinkPO toPO(ShortLink shortLink);

    ShortLink toDO(ShortLinkPO shortLinkPO);
}
