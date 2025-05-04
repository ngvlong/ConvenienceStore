/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

/**
 *
 * @author NAME
 */
public class AccountDLL {
    String username,password,Employ_id;
    int role,status;

    public AccountDLL(String username, String password, String Employ_id, int role, int status) {
        this.username = username;
        this.password = password;
        this.Employ_id = Employ_id;
        this.role = role;
        this.status = status;
    }

    public AccountDLL() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmploy_id() {
        return Employ_id;
    }

    public void setEmploy_id(String Employ_id) {
        this.Employ_id = Employ_id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
