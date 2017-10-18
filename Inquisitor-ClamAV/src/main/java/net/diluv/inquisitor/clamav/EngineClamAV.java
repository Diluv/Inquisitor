package net.diluv.inquisitor.clamav;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.diluv.inquisitor.engine.IEngine;
import com.diluv.inquisitor.report.IReport;
import com.diluv.inquisitor.report.Report;

import fi.solita.clamav.ClamAVClient;

/**
 * This engine implementation adds support for the ClamAV malware engine. More info can be
 * found here: https://www.clamav.net/
 *
 * @author Tyler Hancock (Darkhax)
 */
public class EngineClamAV implements IEngine {

    /**
     * A byte array that should match with any okay/clean file.
     */
    private static final byte[] OKAY_SIGNATURE = new byte[] { 115, 116, 114, 101, 97, 109, 58, 32, 79, 75, 0 };

    /**
     * The IP of the server being connected to.
     */
    private final String ip;

    /**
     * The port to connect to.
     */
    private final int port;

    /**
     * The time to wait for a response, an an unknown unit.
     */
    private final int timeout;

    /**
     * The ClamAV client instance. Initialized during {@link #initialize()}
     */
    private ClamAVClient client;

    /**
     * Constructs a default inquisitor interface to the ClamAV engine. This will use the
     * default port and set the timeout to an infinite amount. These are not recommended.
     *
     * @param ip The IP of the server to connect to.
     */
    public EngineClamAV (String ip) {

        this(ip, 3310, 0);
    }

    /**
     * Constructs an inquisitor interface to the ClamAV engine.
     *
     * @param ip The IP of the server to connect to.
     * @param port The port of the server to connect to.
     * @param timeout The time to wait for a response. Setting to 0 will make this time
     *        infinite.
     */
    public EngineClamAV (String ip, int port, int timeout) {

        this.ip = ip;
        this.port = port;
        this.timeout = timeout;
    }

    @Override
    public String getEngineName () {

        return "ClamAV";
    }

    @Override
    public List<IReport> scanFile (File file) {

        final List<IReport> reports = new ArrayList<>();

        try {

            final byte[] rawReply = this.client.scan(new FileInputStream(file));

            if (!Arrays.equals(OKAY_SIGNATURE, rawReply)) {

                final String reply = new String(rawReply, StandardCharsets.US_ASCII);
                final String type = reply.substring(8, reply.length() - 7);
                reports.add(new Report(this.getEngineName(), type, "The " + type + " malware was detected.", file));
            }
        }

        catch (final Exception e) {

            e.printStackTrace();

        }

        return reports;
    }

    @Override
    public boolean initialize () {

        try {

            this.client = new ClamAVClient(this.ip, this.port, this.timeout);
            return true;
        }

        catch (final IllegalArgumentException e) {

            e.printStackTrace();
            return false;
        }
    }
}