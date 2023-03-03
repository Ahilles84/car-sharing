package by.it.academy.dao;

import java.util.List;

public interface DAO<Entity, Key> {
    void create(Entity model);

    Entity read(Key key);
    List<Entity> readAll();
}
