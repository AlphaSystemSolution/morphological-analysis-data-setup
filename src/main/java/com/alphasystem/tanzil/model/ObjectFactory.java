//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.09 at 11:32:37 PM EDT 
//


package com.alphasystem.tanzil.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.alphasystem.tanzil package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Quran_QNAME = new QName("quran");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.alphasystem.tanzil
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Verse }
     * 
     */
    public Verse createAyaType() {
        return new Verse();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createQuranType() {
        return new Document();
    }

    /**
     * Create an instance of {@link Chapter }
     * 
     */
    public Chapter createSuraType() {
        return new Chapter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}}
     * 
     */
    @XmlElementDecl(name = "quran")
    public JAXBElement<Document> createQuran(Document value) {
        return new JAXBElement<Document>(_Quran_QNAME, Document.class, null, value);
    }

}
