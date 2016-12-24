package sergiocrespotoubes.com.unedsecuredsoftware.database.entities;


import sergiocrespotoubes.com.unedsecuredsoftware.database.repository.UsuariosRepository;

/**
 * Created by SCrespo on 04/05/2016.
 */
public class Usuario {

    public Usuario(){
        super();
    }

    private long id;

    private String username;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Usuario save() {
        return UsuariosRepository.save(this);
    }

    public void delete() {
        UsuariosRepository.delete(this);
    }

}