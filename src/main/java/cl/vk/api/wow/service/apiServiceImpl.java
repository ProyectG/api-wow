package cl.vk.api.wow.service;

import cl.vk.api.wow.dto.ExecuteDTO;
import cl.vk.api.wow.dto.ExecuteResponseDTO;
import cl.vk.api.wow.service.utils.SOAPUtils;
import cl.vk.api.wow.service.utils.XMLUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class apiServiceImpl implements apiService{
    private SOAPUtils soapUtils;
    private XMLUtils xmlUtils;
    @Override
    public ResponseEntity<ExecuteResponseDTO> executeCommand(ExecuteDTO input) {
        soapUtils = new SOAPUtils();
        xmlUtils = new XMLUtils();
        ExecuteResponseDTO answer = new ExecuteResponseDTO();
        answer.setResponse(xmlUtils.getResponse(soapUtils.sendMessage(input.getCommand()),"result"));
        if(answer.getResponse() != null){
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
