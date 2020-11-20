package exercicio8;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Vehicles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    private long id;

    private int anyModel;
    private String marca;
    private Date data;
    private boolean isRojo;

    public Vehicles(){
    }

    Vehicles(String marca, int anyModel, Date data, boolean isRojo){
        this.marca = marca;
        this.anyModel = anyModel;
        this.data = data;
        this.isRojo = isRojo;

    }

    public Long getId() {
        return id;
    }

    public String getMarca(){
        return marca;
    }

    public int getAnyModel(){
        return anyModel;
    }

    public Date getData(){
        return data;
    }

    public boolean getIsRojo(){
        return isRojo;
    }

    @Override
    public String toString() {
        return "Vehicles{" + "id=" + id + ", anyModel=" + anyModel + ", marca="
                + marca + ", data=" + data + ", isRojo=" + isRojo + '}';
    }


}

