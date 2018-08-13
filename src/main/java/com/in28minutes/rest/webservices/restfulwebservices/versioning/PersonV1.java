package com.in28minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {

    private String name;

    /**
     * @param name
     */
    public PersonV1(final String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

}
