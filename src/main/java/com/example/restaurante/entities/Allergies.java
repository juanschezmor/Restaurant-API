package com.example.restaurante.entities;

import jakarta.persistence.*;

@Entity
public class Allergies {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "allergy_id")
    private int allergyId;
    @Basic
    @Column(name = "allergy_name")
    private String allergyName;

    public int getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Allergies allergies = (Allergies) o;

        if (allergyId != allergies.allergyId) return false;
        if (allergyName != null ? !allergyName.equals(allergies.allergyName) : allergies.allergyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = allergyId;
        result = 31 * result + (allergyName != null ? allergyName.hashCode() : 0);
        return result;
    }
}
