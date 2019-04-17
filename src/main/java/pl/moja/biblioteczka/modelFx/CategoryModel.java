package pl.moja.biblioteczka.modelFx;

import pl.moja.biblioteczka.database.dao.CategoryDao;
import pl.moja.biblioteczka.database.dbutils.DbManager;
import pl.moja.biblioteczka.database.models.Category;

public class CategoryModel {
    public void saveCategoryInDatabase(String name) {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        Category category = new Category();
        category.setName(name);
        categoryDao.createOrUpdate(category);
        DbManager.closeConnectionSource();
    }
}
