package com.mibanco.accountmovement.service;

import com.mibanco.accountmovement.dto.MovementRequestDTO;
import com.mibanco.accountmovement.dto.MovementResponseDTO;
import com.mibanco.accountmovement.dto.MovementUpdateRequestDTO;
import com.mibanco.accountmovement.dto.ReportResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementService {
    MovementResponseDTO createMovement(MovementRequestDTO request);
    MovementResponseDTO updateMovement(Long id, MovementUpdateRequestDTO request);
    List<MovementResponseDTO> getAllMovements();
    void deleteMovement(Long id);
    List<ReportResponseDTO> getReport(String customerIdentification, LocalDateTime startDate, LocalDateTime endDate);
}
