package DTO;

import java.util.List;

public class ContactoDTO {
    MoradaDTO morada;
    List<NumeroTelefoneDTO> numerosTelefone;

    public ContactoDTO() {
    }

    public MoradaDTO getMorada() {
        return morada;
    }

    public void setMorada(MoradaDTO morada) {
        this.morada = morada;
    }

    public List<NumeroTelefoneDTO> getNumerosTelefone() {
        return numerosTelefone;
    }

    public void setNumerosTelefone(List<NumeroTelefoneDTO> numerosTelefone) {
        this.numerosTelefone = numerosTelefone;
    }
}
