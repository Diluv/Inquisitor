package com.diluv.inquisitor.report;

import java.io.File;

/**
 * This interface is used to define a report from a malware engine. If a malware engine finds
 * that a file has malicious contents, they will provide one or more reports for a file.
 *
 * @author Tyler Hancock (Darkhax)
 */
public interface IReport {

    /**
     * Gets the name of the engine engine that generated the report.
     *
     * @return The name of the malware engine used to generate the report.
     */
    String getEngineName ();

    /**
     * Gets the title of the report. This should be a short summary of the report that is less
     * than a sentence.
     *
     * @return The title of the report.
     */
    String getTitle ();

    /**
     * Gets the full on description of the report. This can be used to provide further details
     * about any malware that may have been found.
     *
     * @return The description of the report
     */
    String getDescription ();

    /**
     * A reference to the file that was scanned.
     *
     * @return The file that was scanned.
     */
    File getFile ();
}