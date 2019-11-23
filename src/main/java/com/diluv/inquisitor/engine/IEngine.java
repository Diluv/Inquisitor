package com.diluv.inquisitor.engine;

import java.io.File;
import java.util.List;

import com.diluv.inquisitor.report.IReport;

/**
 * This interface is used to allow inquisitor scanners to interact with the malware engine.
 * Each implementation should allow a new type of malware engine to be supported by the
 * Inquisitor application.
 *
 * @author Tyler Hancock (Darkhax)
 */
public interface IEngine {

    /**
     * Gets the name of the malware engine.
     *
     * @return The name of the engine.
     */
    String getEngineName ();

    /**
     * Called when the engine is requested to scan a file. The return results will be added to
     *
     * @param file The file that is being scanned
     * @return A list of reports generated for the file.
     * @throws Exception Throws an exception if an error occurs while processing the file.
     */
    List<IReport> scanFile (File file) throws Exception;

    /**
     * Initializes the engine. If the engine can not be initialized, this should return false.
     * Failing to initialized should prevent the engine from being used.
     *
     * @return Whether or not the engine could be initialized.
     */
    boolean initialize ();
}
