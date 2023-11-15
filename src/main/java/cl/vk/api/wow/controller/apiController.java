package cl.vk.api.wow.controller;

import cl.vk.api.wow.dto.ExecuteDTO;
import cl.vk.api.wow.dto.ExecuteResponseDTO;
import cl.vk.api.wow.service.apiServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/api/v1/soap")
public class apiController {

    @PostMapping(value="/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExecuteResponseDTO> executeCommand(@RequestBody ExecuteDTO input){
        apiServiceImpl execute = new apiServiceImpl();
        return execute.executeCommand(input) ;
    }

}
