package cl.vk.api.wow.service;

import cl.vk.api.wow.dto.ExecuteDTO;
import cl.vk.api.wow.dto.ExecuteResponseDTO;
import cl.vk.api.wow.service.utils.SOAPUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class apiServiceImpl implements apiService{

    private SOAPUtils soapUtils;


    @Override
    public ResponseEntity<ExecuteResponseDTO> executeCommand(ExecuteDTO input) {
        SOAPUtils response = new SOAPUtils();
        ExecuteResponseDTO answer = new ExecuteResponseDTO();
        answer.setResponse(response.sendMessage(input.getCommand()));
        if(answer.getResponse() != null){
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
