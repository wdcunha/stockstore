package com.salesapp.backend.repository;

import com.salesapp.backend.model.Product;
import com.salesapp.backend.utils.TextUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class ProductRepository {

    @PersistenceContext(unitName = "stockStorePU")
    private EntityManager entityManager;

    @Inject
    private TextUtil textUtil;

    public Product find(@NotNull Long id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional(REQUIRED)
    public Product create(@NotNull Product product) {
        product.setTitle(textUtil.sanitize(product.getTitle()));
        entityManager.persist(product);
        return product;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull @Min(1) @Max(1000) Long id) {
        entityManager.remove(entityManager.getReference(Product.class, id));
    }

    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p ORDER BY p.title", Product.class);
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT count(p) from Product p", Long.class);
        return query.getSingleResult();
    }
}
