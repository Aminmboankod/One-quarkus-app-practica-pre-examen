package edu.craptocraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.craptocraft.entity.Item;
import edu.craptocraft.entity.Orden;
import edu.craptocraft.entity.Usuaria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ServiceOlli {

    public Usuaria cargaUsuaria(String name) {
        Optional<Usuaria> user = Usuaria.find("username", name).firstResultOptional();
        return user.isPresent() ? user.get() : new Usuaria();

    }

    public Item cargaItem(String name) {
        Optional<Item> item = Item.find("nombre", name).firstResultOptional();
        return item.isPresent() ? item.get() : new Item();

    }

    public List<Orden> cargaOrden(String name) {
        return Orden.find("user.username", name).list();
    }

    @Transactional
    public Orden comanda(String nombre, String item_nombre) {
        Orden orden = null;
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(nombre);
        Optional<Item> item = Item.findByIdOptional(item_nombre);
        if (usuaria.isPresent() && item.isPresent()) {
            orden = new Orden(usuaria.get(), item.get());
            orden.persist();
        }

        return orden;
    }

    public List<Orden> comandaMultiple(String string, List<String> listItems) {
        
        List<Orden> ordenes = new ArrayList<Orden>();

        Orden orden = null;

        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(string);
        if (usuaria.isPresent()) {
            for (String item_nombre : listItems) {
                Optional<Item> item = Item.findByIdOptional(item_nombre);
                if (item.isPresent()) {
                    orden = new Orden(usuaria.get(), item.get());
                    ordenes.add(orden);
                    orden.persist();
                }
            }
        }

        return ordenes;
        
    }


    

}
