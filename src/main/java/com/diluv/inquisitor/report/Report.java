package com.diluv.inquisitor.report;

import java.io.File;

/**
 * The default implementation of IReport. This implementation uses the constructor to get the
 * required information, and then presents it as is. Info should not be changed after it's
 * sent.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class Report implements IReport {

    /**
     * The name of the malware engine that created the report.
     */
    private final String engineName;

    /**
     * The title of the report. A short summary, no longer than one sentence.
     */
    private final String title;

    /**
     * The in-depth description of the report.
     */
    private final String description;

    /**
     * The file this report is for.
     */
    private final File file;

    public Report (String engineName, String title, String description, File file) {

        this.engineName = engineName;
        this.title = title;
        this.description = description;
        this.file = file;
    }

    @Override
    public String getEngineName () {

        return this.engineName;
    }

    @Override
    public String getTitle () {

        return this.title;
    }

    @Override
    public String getDescription () {

        return this.description;
    }

    @Override
    public File getFile () {

        return this.file;
    }

    @Override
    public String toString () {

        return "Report [engineName=" + this.engineName + ", title=" + this.title + ", description=" + this.description + ", file=" + this.file + "]";
    }

    @Override
    public int hashCode () {

        final int prime = 31;
        int result = 1;
        result = prime * result + (this.description == null ? 0 : this.description.hashCode());
        result = prime * result + (this.engineName == null ? 0 : this.engineName.hashCode());
        result = prime * result + (this.file == null ? 0 : this.file.hashCode());
        result = prime * result + (this.title == null ? 0 : this.title.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {

        if (this == obj) {

            return true;
        }

        if (obj == null) {

            return false;
        }

        if (this.getClass() != obj.getClass()) {

            return false;
        }

        final Report other = (Report) obj;

        if (this.description == null) {

            if (other.description != null) {

                return false;
            }
        }

        else if (!this.description.equals(other.description)) {

            return false;
        }

        if (this.engineName == null) {

            if (other.engineName != null) {

                return false;
            }
        }

        else if (!this.engineName.equals(other.engineName)) {

            return false;
        }

        if (this.file == null) {

            if (other.file != null) {

                return false;
            }
        }

        else if (!this.file.equals(other.file)) {

            return false;
        }

        if (this.title == null) {

            if (other.title != null) {

                return false;
            }
        }

        else if (!this.title.equals(other.title)) {

            return false;
        }

        return true;
    }
}