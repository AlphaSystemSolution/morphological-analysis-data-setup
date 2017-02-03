package com.alphasystem.morphologicalanalysis.data;

import com.alphasystem.arabic.model.ArabicWord;
import com.alphasystem.morphologicalanalysis.util.Script;
import com.alphasystem.morphologicalanalysis.wordbyword.model.Chapter;
import com.alphasystem.morphologicalanalysis.wordbyword.model.Location;
import com.alphasystem.morphologicalanalysis.wordbyword.model.Token;
import com.alphasystem.morphologicalanalysis.wordbyword.repository.ChapterRepository;
import com.alphasystem.tanzil.model.Document;
import com.alphasystem.tanzil.model.Verse;
import com.alphasystem.util.AppUtil;
import com.alphasystem.util.JAXBTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * @author sali
 */
@Component
public class DataSetupTool {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSetupTool.class);

    private ChapterRepository chapterRepository;
    @Value("${script.name:SIMPLE_ENHANCED}") private String scriptName;
    private Document document;

    @PostConstruct
    public void setup() {
        JAXBTool jaxbTool = new JAXBTool();
        try {
            final Script script = Script.valueOf(scriptName);
            final URL url = AppUtil.getPath(script.getPath()).toUri().toURL();
            LOGGER.debug("Script URL: {}", url.toString());
            document = jaxbTool.unmarshal(Document.class, url);
        } catch (IOException | JAXBException | URISyntaxException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void createChapter(int chapterNumber) {
        if (chapterNumber <= 0 || chapterNumber > 114) {
            throw new RuntimeException(String.format("Invalid chapter number: %s", chapterNumber));
        }
        LOGGER.debug("Start creating chapter {}", chapterNumber);
        com.alphasystem.tanzil.model.Chapter ch = document.getChapters().get(chapterNumber - 1);
        Chapter chapter = new Chapter(chapterNumber, ch.getName());
        List<Verse> verses = ch.getVerses();
        int verseCount = verses.size();
        chapter.setVerseCount(verseCount);
        for (int verseNumber = 1; verseNumber <= verseCount; verseNumber++) {
            chapter.addVerse(createVerse(chapterNumber, null, verses.get(verseNumber - 1)));
        } // end of verse loop
        chapterRepository.save(chapter);
        LOGGER.debug("Finished creating chapter {}", chapterNumber);
    }

    public com.alphasystem.morphologicalanalysis.wordbyword.model.Verse createVerse(int chapterNumber,
                                                                                    com.alphasystem.morphologicalanalysis.wordbyword.model.Verse verse,
                                                                                    com.alphasystem.tanzil.model.Verse vs) {
        int verseNumber = vs.getVerseNumber();
        LOGGER.debug("Start creating verse {}", verseNumber);
        if (verse == null) {
            verse = new com.alphasystem.morphologicalanalysis.wordbyword.model.Verse(chapterNumber, verseNumber);
        }
        verse.setText(vs.getText());
        verse.setTokenCount(0);
        verse.setTokens(null);

        int tokenNumber = 1;
        List<ArabicWord> tokens = vs.getTokens();
        for (ArabicWord aw : tokens) {
            Token token = new Token(chapterNumber, verseNumber, tokenNumber, aw.toUnicode());
            LOGGER.debug("Length of token {} is {}", token.getDisplayName(), aw.toUnicode().length());
            LOGGER.debug("Token \"{}\" created with text \"{}\".", token, token.tokenWord().toUnicode());
            // we will create one location for each token
            Location location = new Location(chapterNumber, verseNumber, tokenNumber, 1);
            token.addLocation(location);
            verse.addToken(token);
            tokenNumber++;
        } // end of token loop
        verse.setTokenCount(verse.getTokens().size());
        LOGGER.debug("Finished creating verse {}", verseNumber);
        return verse;
    }

    public ChapterRepository getChapterRepository() {
        return chapterRepository;
    }

    @Autowired
    public void setChapterRepository(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

}
