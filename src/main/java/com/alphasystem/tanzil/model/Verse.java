//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2016.11.21 at 09:14:51 AM EST
//


package com.alphasystem.tanzil.model;

import com.alphasystem.arabic.model.ArabicWord;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.alphasystem.arabic.model.ArabicWord.concatenateWithSpace;
import static com.alphasystem.arabic.model.ArabicWord.fromUnicode;
import static org.apache.commons.lang3.StringUtils.isBlank;


/**
 * <p>Java class for aya complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="aya"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chapterNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="verse" type="{http://www.alphasystem.com/arabic/support}arabic-word" minOccurs="0"/&gt;
 *         &lt;element name="tokens" type="{http://www.alphasystem.com/arabic/support}arabic-word" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="bismillah" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aya", propOrder = {

})
public class Verse {

    @XmlTransient
    protected Integer chapterNumber;
    @XmlTransient
    protected ArabicWord verse;
    @XmlTransient
    protected List<ArabicWord> tokens;
    @XmlAttribute(name = "index", required = true)
    protected int verseNumber;
    @XmlAttribute(name = "text", required = true)
    protected String text;
    @XmlAttribute(name = "bismillah")
    protected String bismillah;
    @XmlAttribute
    protected String translation;

    /**
     * Gets the value of the chapterNumber property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getChapterNumber() {
        return chapterNumber;
    }

    /**
     * Sets the value of the chapterNumber property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setChapterNumber(Integer value) {
        this.chapterNumber = value;
    }

    /**
     * Gets the value of the verse property.
     *
     * @return possible object is
     * {@link ArabicWord }
     */
    public ArabicWord getVerse() {
        if (verse == null) {
            if (text != null) {
                setVerse(fromUnicode(text));
            }
        }
        return verse;
    }

    /**
     * Sets the value of the verse property.
     *
     * @param value allowed object is
     *              {@link ArabicWord }
     */
    public void setVerse(ArabicWord value) {
        this.verse = value;
    }

    /**
     * Gets the value of the tokens property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tokens property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTokens().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArabicWord }
     */
    public List<ArabicWord> getTokens() {
        if (tokens == null) {
            tokens = new ArrayList<>();
            tokens.addAll(loadTokens());
        }
        return this.tokens;
    }

    /**
     * Gets the value of the verseNumber property.
     */
    public int getVerseNumber() {
        return verseNumber;
    }

    /**
     * Sets the value of the verseNumber property.
     */
    public void setVerseNumber(int value) {
        this.verseNumber = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the bismillah property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBismillah() {
        return bismillah;
    }

    /**
     * Sets the value of the bismillah property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBismillah(String value) {
        this.bismillah = value;
    }

    /**
     * Gets the value of the translation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Sets the value of the translation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTranslation(String value) {
        this.translation = value;
    }

    public Verse withChapterNumber(Integer value) {
        setChapterNumber(value);
        return this;
    }

    public Verse withVerse(ArabicWord value) {
        setVerse(value);
        return this;
    }

    public Verse withTokens(ArabicWord... values) {
        if (values != null) {
            for (ArabicWord value : values) {
                getTokens().add(value);
            }
        }
        return this;
    }

    public Verse withTokens(Collection<ArabicWord> values) {
        if (values != null) {
            getTokens().addAll(values);
        }
        return this;
    }

    public Verse withVerseNumber(int value) {
        setVerseNumber(value);
        return this;
    }

    public Verse withText(String value) {
        setText(value);
        return this;
    }

    public Verse withBismillah(String value) {
        setBismillah(value);
        return this;
    }

    private List<ArabicWord> loadTokens() {
        List<ArabicWord> tokens = new ArrayList<>();
        String[] _tokens = getText().split(" ");
        for (int i = 0; i < _tokens.length; i++) {
            String token = _tokens[i];
            if (isBlank(token)) {
                continue;
            }
            token = token.trim();
            ArabicWord word = fromUnicode(token);
            if (token.length() == 1) {
                // one of punctuation character
                // logic is to merge punctuation with the previous token,
                // but if it is the first token then merge it with next token
                if (i == 0) {
                    String nextToken = _tokens[++i].trim();
                    tokens.add(concatenateWithSpace(word, fromUnicode(nextToken)));
                } else {
                    int lastIndex = tokens.size() - 1;
                    ArabicWord lastWord = tokens.get(lastIndex);
                    tokens.set(lastIndex, concatenateWithSpace(lastWord, word));
                }
            } else {
                tokens.add(word);
            }
        }
        return tokens;
    }

}
