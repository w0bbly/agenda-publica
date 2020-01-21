package Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "numeros")
public class NumeroTelefone {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 9, unique = true)
    @NotNull
    private Long numero;

    public NumeroTelefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumeroTelefone that = (NumeroTelefone) o;

        if (!id.equals(that.id)) return false;
        return numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + numero.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "NumeroTelefone{" +
                "id=" + id +
                ", numero=" + numero +
                '}';
    }
}
