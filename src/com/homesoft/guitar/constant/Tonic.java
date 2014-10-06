package com.homesoft.guitar.constant;

/**
 * The Enum Tonic.
 */
public enum Tonic {

    /** The MAJO r_ pentatonic. */
    //MAJOR_PENTATONIC ("Major Pentatonic", new int[] {1, 2, 3, 5, 6}),
    MAJOR_PENTATONIC ("Major Pentatonic", 1, 3, 5, 8, 10),

    /** The MINO r_ pentatonic. */
    //MINOR_PENTATONIC ("Minor Pentatonic", new int[] {1, 3, 4, 5, 7});
    MINOR_PENTATONIC ("Minor Pentatonic", 1, 5, 6, 8, 12),

    /** The HEPTA. */
    MAJOR_HEPTATONIC ("Major Heptatonic", 1, 3, 5, 6, 8, 10, 12);

    /** The name. */
    private String name;

    /** The degree. */
    private int[] degree;

    /**
     * Instantiates a new tonic.
     * 
     * @param name the name
     * @param degree the degree
     */
    private Tonic(String name, int... degree) {
        this.name=name;
        this.degree=degree;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the degree.
     * 
     * @return the degree
     */
    public int[] getDegree() {
        return degree;
    }

    /**
     * Gets the.
     * 
     * @param name the name
     * @return the tonic
     */
    public static Tonic get(String name) {
        for (Tonic tonic : values()) {
            if (tonic.getName().equals(name)) {
                return tonic;
            }
        }
        return null;
    }

}
