package com.canales.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong uidGenerator = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private long landmass;
    private long medianAge;

    public Country(String name, long population, long landmass, long medianAge) {
        this.id = uidGenerator.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landmass = landmass;
        this.medianAge = medianAge;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public long getLandmass() {
        return landmass;
    }

    public long getMedianAge() {
        return medianAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landmass=" + landmass +
                ", medianAge=" + medianAge +
                '}';
    }
}
