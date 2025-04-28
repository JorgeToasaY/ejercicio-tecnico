package com.mibanco.accountmovement.mapper;

import com.mibanco.accountmovement.dto.MovementRequestDTO;
import com.mibanco.accountmovement.dto.MovementResponseDTO;
import com.mibanco.accountmovement.entity.Movement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    Movement toEntity(MovementRequestDTO dto);

    MovementResponseDTO toDto(Movement entity);

    List<MovementResponseDTO> toDtoList(List<Movement> entities);
}
