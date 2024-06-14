package application.model;


import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "genero_id")
    private Long generoId;

    @Column(name = "multiplayer")
    private boolean multiplayer;



    public Jogo() {
    }

    public Jogo(String titulo, Long generoId, boolean multiplayer) {
        this.titulo = titulo;
        this.generoId = generoId;
        this.multiplayer = multiplayer;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }
}
