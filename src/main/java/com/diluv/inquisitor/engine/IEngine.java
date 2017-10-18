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
     * @param file
     * @return
     */
    List<IReport> scanFile (File file);
}
