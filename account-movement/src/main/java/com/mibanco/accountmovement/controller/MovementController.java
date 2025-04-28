package com.mibanco.accountmovement.controller;

import com.mibanco.accountmovement.dto.MovementRequestDTO;
import com.mibanco.accountmovement.dto.MovementResponseDTO;
import com.mibanco.accountmovement.dto.MovementUpdateRequestDTO;
import com.mibanco.accountmovement.dto.ReportResponseDTO;
import com.mibanco.accountmovement.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;

    @PostMapping
    public ResponseEntity<MovementResponseDTO> create(@RequestBody @Validated MovementRequestDTO request) {
        return new ResponseEntity<>(movementService.createMovement(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MovementResponseDTO> update(@PathVariable Long id, @RequestBody @Validated MovementUpdateRequestDTO request) {
        return new ResponseEntity<>(movementService.updateMovement(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        movementService.deleteMovement(id);
        return ResponseEntity.ok("Movement with id " + id + " eliminated");
    }

    @GetMapping
    public ResponseEntity<List<MovementResponseDTO>> getAll() {
        return ResponseEntity.ok(movementService.getAllMovements());
    }

    @GetMapping("/reportes")
    public ResponseEntity<List<ReportResponseDTO>> getReport(
            @RequestParam String customer,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        return ResponseEntity.ok(movementService.getReport(customer, desde, hasta));
    }
}