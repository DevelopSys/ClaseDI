package org.example.gestor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioJSON implements Serializable {
    String gender;
     String email;
     String phone;
     String cell;
     String nat;

}
