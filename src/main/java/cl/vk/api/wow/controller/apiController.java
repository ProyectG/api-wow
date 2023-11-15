package cl.vk.api.wow.controller;

import cl.vk.api.wow.dto.*;
import cl.vk.api.wow.service.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/3.3.5/soap")
public class apiController {

    @Autowired
    ApiServiceImpl execute;

    @PostMapping(value="/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExecuteResponseDTO> executeCommand(@RequestBody ExecuteDTO input){
        return execute.executeCommand(input) ;
    }

    @PostMapping(value="/addacc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExecuteResponseDTO> createAccount(@RequestBody CreateAccountDTO input){
        ExecuteDTO executeDTO = ExecuteDTO.builder().command("account create "+input.getUsername()+" "+input.getPassword()).build();
        return execute.executeCommand(executeDTO);

    }

    @PostMapping(value="/updacc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExecuteResponseDTO> updAccount(@RequestBody UpdatePasswordDTO input){
        ExecuteDTO executeDTO = ExecuteDTO.builder().command("account set password "+input.getUsername()+" "+input.getNewPassword()+" "+input.getRNewPassword()).build();
        return execute.executeCommand(executeDTO);
    }

    @PostMapping(value="/announce", produces = MediaType.APPLICATION_JSON_VALUE)
    public void announce(@RequestBody AnnounceDTO input){
        ExecuteDTO executeDTO = ExecuteDTO.builder().command("announce "+input.getAnnounce()).build();
        execute.executeCommand(executeDTO);
    }


}
