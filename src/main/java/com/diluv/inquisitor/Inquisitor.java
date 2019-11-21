package com.diluv.inquisitor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.diluv.inquisitor.engine.IEngine;
import com.diluv.inquisitor.report.IReport;

/**
 * A default implementation of the inquisitor scanner. Handles all the basic requirements for a
 * scanner.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class Inquisitor implements IInquisitor {

    /**
     * A list of all malware engines you're scanning for.
     */
    private final List<IEngine> engines = new ArrayList<>();

    /**
     * Adds a new malware engine to the scanner.
     *
     * @param engine The engine to add.
     */
    public void addEngine (IEngine engine) {

        if (engine.initialize()) {

            this.engines.add(engine);
        }

        //TODO else fire warning
    }

    @Override
    public List<IReport> scanFile (File file) throws Exception {

        final List<IReport> reports = new ArrayList<>();

        for (final IEngine engine : this.engines) {

            reports.addAll(engine.scanFile(file));
        }

        return reports;
    }
}
