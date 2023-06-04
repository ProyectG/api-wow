package cl.vk.api.wow.service;

import cl.vk.api.wow.dto.ExecuteDTO;
import cl.vk.api.wow.dto.ExecuteResponseDTO;
import org.springframework.http.ResponseEntity;

public interface apiService {
    ResponseEntity<ExecuteResponseDTO> executeCommand(ExecuteDTO input);

}
