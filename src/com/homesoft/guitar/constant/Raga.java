/*
 * 
 */
package com.homesoft.guitar.constant;

/**
 * The Enum Raga.
 */
public enum Raga {

    /** The KANAKANGI. */
    KANAKANGI(Chakra.INDU, 1, 2, 3, 6, 8, 9, 10),

    /** The RATNANGI. */
    RATNANGI(Chakra.INDU, 1, 2, 3, 6, 8, 9, 11),

    /** The GANAMURTHI. */
    GANAMURTHI(Chakra.INDU, 1, 2, 3, 6, 8, 9, 12),

    /** The VANASPATI. */
    VANASPATI(Chakra.INDU, 1, 2, 3, 6, 8, 10, 11),

    /** The MANAVATI. */
    MANAVATI(Chakra.INDU, 1, 2, 3, 6, 8, 10, 12),

    /** The TANARUPI. */
    TANARUPI(Chakra.INDU, 1, 2, 3, 6, 8, 11, 12),

    /** The SENAVATI. */
    SENAVATI(Chakra.NETRA, 1, 2, 4, 6, 8, 9, 10),

    /** The HANUMATODI. */
    HANUMATODI(Chakra.NETRA, 1, 2, 4, 6, 8, 9, 11),

    /** The DHENUKA. */
    DHENUKA(Chakra.NETRA, 1, 2, 4, 6, 8, 9, 12),

    /** The NATAKAPRIYA. */
    NATAKAPRIYA(Chakra.NETRA, 1, 2, 4, 6, 8, 10, 11),

    /** The KOKILAPRIYA. */
    KOKILAPRIYA(Chakra.NETRA, 1, 2, 4, 6, 8, 10, 12),

    /** The RUPAVATI. */
    RUPAVATI(Chakra.NETRA, 1, 2, 4, 6, 8, 11, 12),

    /** The GAYAKAPRIYA. */
    GAYAKAPRIYA(Chakra.AGNI, 1, 2, 5, 6, 8, 9, 10),

    /** The VAKULABHARANAM. */
    VAKULABHARANAM(Chakra.AGNI, 1, 2, 5, 6, 8, 9, 11),

    /** The MAYAMALAVOGOWLA. */
    MAYAMALAVOGOWLA(Chakra.AGNI, 1, 2, 5, 6, 8, 9, 12),

    /** The CHAKRAVAKAM. */
    CHAKRAVAKAM(Chakra.AGNI, 1, 2, 5, 6, 8, 10, 11),

    /** The SURYAKANTAM. */
    SURYAKANTAM(Chakra.AGNI, 1, 2, 5, 6, 8, 10, 12),

    /** The HATAKAMBARI. */
    HATAKAMBARI(Chakra.AGNI, 1, 2, 5, 6, 8, 11, 12),

    /** The JHANKARADHWANI. */
    JHANKARADHWANI(Chakra.VEDA, 1, 3, 4, 6, 8, 9, 10),

    /** The NATABHAIRAVI. */
    NATABHAIRAVI(Chakra.VEDA, 1, 3, 4, 6, 8, 9, 11),

    /** The KEERAVANI. */
    KEERAVANI(Chakra.VEDA, 1, 3, 4, 6, 8, 9, 12),

    /** The KHARAHARAPRIYA. */
    KHARAHARAPRIYA(Chakra.VEDA, 1, 3, 4, 6, 8, 10, 11),

    /** The GOURIMANOHARI. */
    GOURIMANOHARI(Chakra.VEDA, 1, 3, 4, 6, 8, 10, 12),

    /** The VARUNAPRIYA. */
    VARUNAPRIYA(Chakra.VEDA, 1, 3, 4, 6, 8, 11, 12),

    /** The MARARANJANI. */
    MARARANJANI(Chakra.BANA, 1, 3, 5, 6, 8, 9, 10),

    /** The CHARUKESHI. */
    CHARUKESHI(Chakra.BANA, 1, 3, 5, 6, 8, 9, 11),

    /** The SARASANGI. */
    SARASANGI(Chakra.BANA, 1, 3, 5, 6, 8, 9, 12),

    /** The HARIKAMBHOJI. */
    HARIKAMBHOJI(Chakra.BANA, 1, 3, 5, 6, 8, 10, 11),

    /** The DHEERASANKARABHARANAM. */
    DHEERASANKARABHARANAM(Chakra.BANA, 1, 3, 5, 6, 8, 10, 12),

    /** The NAGANANDINI. */
    NAGANANDINI(Chakra.BANA, 1, 4, 5, 6, 8, 11, 12),

    /** The YAGAPRIYA. */
    YAGAPRIYA(Chakra.RUTU, 1, 4, 5, 6, 8, 9, 10),

    /** The RAGAVARDHINI. */
    RAGAVARDHINI(Chakra.RUTU, 1, 4, 5, 6, 8, 9, 11),

    /** The GANGEYABHUSHANI. */
    GANGEYABHUSHANI(Chakra.RUTU, 1, 4, 5, 6, 8, 9, 12),

    /** The VAGADHEESWARI. */
    VAGADHEESWARI(Chakra.RUTU, 1, 4, 5, 6, 8, 10, 11),

    /** The SHULINI. */
    SHULINI(Chakra.RUTU, 1, 4, 5, 6, 8, 10, 12),

    /** The CHALANATA. */
    CHALANATA(Chakra.RUTU, 1, 4, 5, 6, 8, 11, 12),

    /** The SALAGAM. */
    SALAGAM(Chakra.RISHI, 1, 2, 3, 7, 8, 9, 10),

    /** The JALARNAVAM. */
    JALARNAVAM(Chakra.RISHI, 1, 2, 3, 7, 8, 9, 11),

    /** The JHALAVARALI. */
    JHALAVARALI(Chakra.RISHI, 1, 2, 3, 7, 8, 9, 12),

    /** The NAVANEETAM. */
    NAVANEETAM(Chakra.RISHI, 1, 2, 3, 7, 8, 10, 11),

    /** The PAVANI. */
    PAVANI(Chakra.RISHI, 1, 2, 3, 7, 8, 10, 12),

    /** The RAGHUPRIYA. */
    RAGHUPRIYA(Chakra.RISHI, 1, 2, 3, 7, 8, 11, 12),

    /** The GAVAMBHODI. */
    GAVAMBHODI(Chakra.VASU, 1, 2, 4, 7, 8, 9, 10),

    /** The BHAVAPRIYA. */
    BHAVAPRIYA(Chakra.VASU, 1, 2, 4, 7, 8, 9, 11),

    /** The SHUBHAPANTUVARALI. */
    SHUBHAPANTUVARALI(Chakra.VASU, 1, 2, 4, 7, 8, 9, 12),

    /** The SHADVIDAMARGINI. */
    SHADVIDAMARGINI(Chakra.VASU, 1, 2, 4, 7, 8, 10, 11),

    /** The SUVARGANGI. */
    SUVARGANGI(Chakra.VASU, 1, 2, 4, 7, 8, 10, 12),

    /** The DIVYAMANI. */
    DIVYAMANI(Chakra.VASU, 1, 2, 4, 7, 8, 11, 12),

    /** The DHAVALAMBARI. */
    DHAVALAMBARI(Chakra.BRAHMA, 1, 2, 4, 7, 8, 11, 12),

    /** The NAMANARAYANI. */
    NAMANARAYANI(Chakra.BRAHMA, 1, 2, 5, 7, 8, 9, 10),

    /** The KAMAVARDANI. */
    KAMAVARDANI(Chakra.BRAHMA, 1, 2, 5, 7, 8, 9, 11),

    /** The RAMAPRIYA. */
    RAMAPRIYA(Chakra.BRAHMA, 1, 2, 5, 7, 8, 9, 12),

    /** The GAMANASHRAMA. */
    GAMANASHRAMA(Chakra.BRAHMA, 1, 2, 5, 7, 8, 10, 11),

    /** The VISHWAMBARI. */
    VISHWAMBARI(Chakra.BRAHMA, 1, 2, 5, 7, 8, 10, 12),

    /** The SHAMALANGI. */
    SHAMALANGI(Chakra.DISI, 1, 3, 4, 7, 8, 9, 10),

    /** The SHANMUKHAPRIYA. */
    SHANMUKHAPRIYA(Chakra.DISI, 1, 3, 4, 7, 8, 9, 11),

    /** The SIMHENDRAMADHYAMAM. */
    SIMHENDRAMADHYAMAM(Chakra.DISI, 1, 3, 4, 7, 8, 9, 12),

    /** The HEMAVATI. */
    HEMAVATI(Chakra.DISI, 1, 3, 4, 7, 8, 10, 11),

    /** The DHARMAVATI. */
    DHARMAVATI(Chakra.DISI, 1, 3, 4, 7, 8, 10, 12),

    /** The NEETIMATI. */
    NEETIMATI(Chakra.DISI, 1, 3, 4, 7, 8, 11, 12),

    /** The KANTAMANI. */
    KANTAMANI(Chakra.RUDRA, 1, 3, 5, 7, 8, 9, 10),

    /** The RISHABHAPRIYA. */
    RISHABHAPRIYA(Chakra.RUDRA, 1, 3, 5, 7, 8, 9, 11),

    /** The LATANGI. */
    LATANGI(Chakra.RUDRA, 1, 3, 5, 7, 8, 9, 12),

    /** The VACHASPATI. */
    VACHASPATI(Chakra.RUDRA, 1, 3, 5, 7, 8, 10, 11),

    /** The MECHAKALYANI. */
    MECHAKALYANI(Chakra.RUDRA, 1, 3, 5, 7, 8, 10, 12),

    /** The CHITRAMBARI. */
    CHITRAMBARI(Chakra.RUDRA, 1, 4, 5, 7, 8, 11, 12),

    /** The SUCHARITRA. */
    SUCHARITRA(Chakra.ADITYA, 1, 4, 5, 7, 8, 9, 10),

    /** The JROTHISWARUPINI. */
    JROTHISWARUPINI(Chakra.ADITYA, 1, 4, 5, 7, 8, 9, 11),

    /** The DHATUVARDHINI. */
    DHATUVARDHINI(Chakra.ADITYA, 1, 4, 5, 7, 8, 9, 12),

    /** The NASIKABHUSHANI. */
    NASIKABHUSHANI(Chakra.ADITYA, 1, 4, 5, 7, 8, 10, 11),

    /** The KOSALAM. */
    KOSALAM(Chakra.ADITYA, 1, 4, 5, 7, 8, 10, 12),

    /** The RASIKAPRIYA. */
    RASIKAPRIYA(Chakra.ADITYA, 1, 4, 5, 7, 8, 11, 12),

    ;

    /** The chakra. */
    private Chakra chakra;

    /** The degree. */
    private int[] degree;

    /**
     * Instantiates a new melakarta.
     * 
     * @param chakra the chakra
     * @param degree the degree
     */
    private Raga(Chakra chakra, int... degree) {
        this.chakra=chakra;
        this.degree=degree;
    }

    /**
     * Gets the chakra.
     * 
     * @return the chakra
     */
    public Chakra getChakra() {
        return chakra;
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
     * @return the melakarta
     */
    public static Raga get(String name) {
        for (Raga raga : values()) {
            if (raga.toString().equals(name)) {
                return raga;
            }
        }
        return null;
    }

}
