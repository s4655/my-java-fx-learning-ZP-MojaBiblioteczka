package pl.moja.biblioteczka.database.dbutils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.moja.biblioteczka.database.models.Author;
import pl.moja.biblioteczka.database.models.Book;
import pl.moja.biblioteczka.database.models.Category;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String DB_URL = "jdbc:h2:./myLibraryDB";
    public static final String USER = "admin";
    public static final String PASS = "admin";

    private static ConnectionSource connectionSource;

    public static void initDatabase() {
        createConnectionSource();
        dropTables();
        createTables();
        closeConnectionSource();
    }

    private static void createConnectionSource() {
        try {
            connectionSource = new JdbcConnectionSource(DB_URL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource() {
        if (connectionSource == null) {
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTables() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Author.class);
            TableUtils.createTableIfNotExists(connectionSource, Book.class);
            TableUtils.createTableIfNotExists(connectionSource, Category.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTables() {
        try {
            TableUtils.dropTable(connectionSource, Author.class, true);
            TableUtils.dropTable(connectionSource, Book.class, true);
            TableUtils.dropTable(connectionSource, Category.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }


}
