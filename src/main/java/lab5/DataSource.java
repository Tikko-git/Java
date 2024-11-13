package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public abstract class DataSource<T> {
    protected static final String path = "jdbc:postgresql://localhost:5432/hotel";
    protected static final String username = "postgres";
    protected static final String password = "PostgreSQL_study";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(path, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract List<T> getAll();

    public abstract T getOne(int id);

    public abstract void insert(T o);

    public abstract void update(T o);

    public abstract void delete(int id);
}
