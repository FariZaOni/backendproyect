package fari.ludica.backend.user;

import org.bson.types.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class userController {
    @Autowired
    private UserService service;

//PASA DATOS Y LOS VALIDA
    @PostMapping("/UserLogin")
    //@ResponseStatus(code = HttpStatus.CREATED)
    public void UserLogin(@RequestParam String username, @RequestParam String password){
        service.findForLogin(username,password);


    }

//CREA AL USUARIO:
    @PostMapping("/UserRegister")
    //@ResponseStatus(code = HttpStatus.CREATED)
    public void UserRegister(@RequestParam String Email, @RequestParam String UserName, @RequestParam String Password){
        User newUser = new User(Email,UserName,Password); //Contructor de usuario con los parametros
        service.createUser(newUser); //Llama al servicio, le entrega el usuario creado y procesa

    }

}

