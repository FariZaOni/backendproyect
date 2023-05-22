package fari.ludica.backend.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;


@Data
@Document(collection = "Users")
@AllArgsConstructor

public class User {
    @Id
    private ObjectId id;
    private String username;
    private String Email;
    //private LocalDate dateCreation;
    private String password;
    private boolean isLocked;
    private int lockedCounter;
    //Constructor
    public User(){

    }

    public User(String email, String username, String password) {
        this.Email=email;
        this.username=username;
        //this.dateCreation=java.time.LocalDate.now();
        this.password = password;
        this.isLocked=false;
        this.lockedCounter=0;
    }

    public void wrongPassword(){
        if (!this.isLocked){
            this.lockedCounter++;
            if (this.lockedCounter>=5){
                this.isLocked=true;
            }
        }
//SPRING Home, formulario de contacto (informacion), quienes somos, ver mi perfil.

    }
}

