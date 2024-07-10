package com.example.restaurante.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_allergy", schema = "restaurante", catalog = "")
public class ProductAllergy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_allergy_id")
    private int productAllergyId;
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "allergy_id")
    private Integer allergyId;

    public int getProductAllergyId() {
        return productAllergyId;
    }

    public void setProductAllergyId(int productAllergyId) {
        this.productAllergyId = productAllergyId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(Integer allergyId) {
        this.allergyId = allergyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductAllergy that = (ProductAllergy) o;

        if (productAllergyId != that.productAllergyId) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (allergyId != null ? !allergyId.equals(that.allergyId) : that.allergyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productAllergyId;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (allergyId != null ? allergyId.hashCode() : 0);
        return result;
    }
}
