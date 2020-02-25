package model;

public enum CardSpec {
    STRENGTH("Strength"),

    KNOWLEDGE("Knowledge"),

    INTELLIGENCE("Intelligence"),

    CUNNING("Cunning");

    private String specification;

    CardSpec(String specification) {
        this.specification = specification;
    }

    public String getSpecification() {
        return specification;
    }
}