package fari.ludica.backend.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public void createUser(User user){
        if (userExist(user.getEmail())){
            //Que retorne un HTTP???
        }else{
            repo.save(user);
        }


    }
    public boolean userExist(String userEmail){
        User existingUser;
        existingUser=repo.findByEmail(userEmail);
        return existingUser!=null; //si existe retorna true, si no false, en caso de esto ultimo guarda los datos
        }

    public void findForLogin(String email, String password){
        User user;
        user =repo.findByEmail(email);
        if (user!=null){
            validatePassword(password,user.getPassword());
        }else {
            //Enviar un HTTP diciendo que no existe el correo
        }
    }
    public boolean validatePassword(String password, String dbpassword){
        //La logica (OJO HAY QUE ENCRIPTAR)
        return true;
    }





    //HACER EL RESTO DEL CRUD

}
