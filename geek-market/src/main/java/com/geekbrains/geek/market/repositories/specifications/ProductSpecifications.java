package com.geekbrains.geek.market.repositories.specifications;

import com.geekbrains.geek.market.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int price) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);  // where p.price >= minPrice
    }

    public static Specification<Product> priceLesserOrEqualsThan(int price) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price); // where p.price <= maxPrice
    }

    public static Specification<Product> titleLike(String title) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%")); // where p.price <= maxPrice
    }
}
