package Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "morada")
public class Morada {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String endereco;

    public Morada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Morada morada = (Morada) o;

        if (!id.equals(morada.id)) return false;
        return endereco.equals(morada.endereco);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + endereco.hashCode();
        return result;
    }
}
