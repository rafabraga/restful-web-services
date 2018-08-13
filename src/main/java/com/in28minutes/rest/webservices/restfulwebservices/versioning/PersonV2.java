package com.in28minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {

    private Name name;

    /**
     * @param name
     */
    public PersonV2(final Name name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public Name getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final Name name) {
        this.name = name;
    }

}
