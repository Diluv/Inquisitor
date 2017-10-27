package com.diluv.inquisitor;

import java.io.File;
import java.util.List;

import com.diluv.inquisitor.report.IReport;

/**
 * The backing interface for a scanner.
 *
 * @author Tyler Hancock (Darkhax)
 */
public interface IInquisitor {

    /**
     * Scans a file, and provides a list of reports. If no reports are generated the list
     * should be empty.
     *
     * @param file The file to scan.
     * @return A list of reports generated for the file.
     */
    List<IReport> scanFile (File file) throws Exception;
}