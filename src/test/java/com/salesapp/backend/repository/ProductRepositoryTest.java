package com.salesapp.backend.repository;

import com.salesapp.backend.model.Product;
import com.salesapp.backend.model.ProfileType;
import com.salesapp.backend.utils.TextUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ProductRepositoryTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ProductRepository.class)
                .addClass(Product.class)
                .addClass(ProfileType.class)
                .addClass(TextUtil.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml");
    }

    @Inject
    private ProductRepository productRepository;

    @Test
    public void testMethods() {
        // Test counting and find all products
        assertEquals(Long.valueOf(0), productRepository.countAll());
        assertEquals(0, productRepository.findAll().size());

        // Create a Product
        Product product = new Product("a title", "can be anything",
                50.00F, new Date(), 5,"http://blahblahblah", ProfileType.FEMININO_PLUS_SIZE);

        product = productRepository.create(product);
        Long productId = product.getId();

        // Check created product
        assertNotNull(productId);

        // Find created product
        Product productFound = productRepository.find(productId);

        // Check the found product
        assertEquals("a title", productFound.getTitle());
    }
}
