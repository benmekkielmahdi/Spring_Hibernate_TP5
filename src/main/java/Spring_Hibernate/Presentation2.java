package Spring_Hibernate;

import Spring_Hibernate.dao.IDao;
import Spring_Hibernate.entities.Category;
import Spring_Hibernate.entities.Product;
import Spring_Hibernate.util.HibernateConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean(IDao.class);

        Product product1 = new Product();
        product1.setName("Produit 1");
        product1.setPrice(100.0);

        productDao.create(product1);

        System.out.println("Produit sauvegardé : " + product1.getName());


        Category category = new Category("Électronique");
        Product product2 = new Product("Téléphone", 1200.0);
        product2.setCategory(category);

        category.getProducts().add(product2);

        productDao.create(product2);

        System.out.println("Produit sauvegardé : " + product2.getName());


    }
}