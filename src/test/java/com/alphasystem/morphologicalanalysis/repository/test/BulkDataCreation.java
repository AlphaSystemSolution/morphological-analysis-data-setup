/**
 *
 */
package com.alphasystem.morphologicalanalysis.repository.test;

import com.alphasystem.morphologicalanalysis.data.spring.DataSetupSpringConfiguration;
import com.alphasystem.morphologicalanalysis.spring.support.MongoConfig;
import com.alphasystem.morphologicalanalysis.spring.support.MorphologicalAnalysisSpringConfiguration;
import com.alphasystem.morphologicalanalysis.spring.support.PropertyConfiguration;
import com.alphasystem.morphologicalanalysis.util.DataInitializationTool;
import com.alphasystem.morphologicalanalysis.util.Script;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.alphasystem.util.Utils.getTimeConsumed;
import static java.lang.System.currentTimeMillis;

/**
 * @author sali
 */
@ContextConfiguration(classes = {PropertyConfiguration.class, MongoConfig.class, MorphologicalAnalysisSpringConfiguration.class, DataSetupSpringConfiguration.class})
public class BulkDataCreation extends AbstractTestNGSpringContextTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(BulkDataCreation.class);

    @Autowired private DataInitializationTool dataSetupTool;

    /**
     * Creates initial data.
     */
    @Test
    public void createChapters() {
        long startTime = currentTimeMillis();
        for (int chapterNumber = 1; chapterNumber <= 114; chapterNumber++) {
            createChapterInternal(chapterNumber);
        }
        long endTime = currentTimeMillis();
        LOGGER.info("Total time consume is {}", getTimeConsumed(endTime - startTime));
    }

    @Test
    public void createChapter() {
        createChapterInternal(1);
    }

    private void createChapterInternal(int chapterNumber) {
        long chapterStartTime = currentTimeMillis();
        try {
            dataSetupTool.createChapter(chapterNumber, Script.SIMPLE_ENHANCED);
        } catch (JAXBException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        long chapterEndTime = currentTimeMillis();
        final String timeConsumed = getTimeConsumed(chapterEndTime - chapterStartTime);
        LOGGER.info("Time consume to save chapter {} is {}", chapterNumber, timeConsumed);
    }

}
