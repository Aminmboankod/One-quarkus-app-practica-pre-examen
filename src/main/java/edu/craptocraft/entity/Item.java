package edu.craptocraft.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_items")
public class Item extends PanacheEntityBase {

    @Id
    @Column(name = "item_nom")
    private String nombre = "";

    @Column(name = "item_prop")
    private int quality = 0;

    @Column(name = "item_tipo")
    private String tipo;

    public Item() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public Integer getQuality() {
        return this.quality;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
