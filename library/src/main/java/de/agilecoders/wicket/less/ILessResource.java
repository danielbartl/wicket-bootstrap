package de.agilecoders.wicket.less;

import org.apache.wicket.util.time.Time;

import java.io.File;
import java.io.InputStream;

/**
 * Representation of a less resource
 *
 * @author miha
 */
public interface ILessResource {

    /**
     * @return the absolute path as string.
     */
    String getPath();

    /**
     * @return the last modified date (including all children)
     */
    Time lastModified();

    /**
     * @return the resource as text (including all children)
     */
    String asText();

    /**
     * @return true, if resource exists on filesystem
     */
    boolean exists();

    /**
     * @return the content stream of this resource
     */
    InputStream getInputStream();

    /**
     * creates a path relative to current that points to a new resource
     *
     * @param subPath the sub path relative to current
     * @return new resource
     */
    LessResource getRelative(String subPath);

    /**
     * @return the file name of this resource
     */
    String getName();

    /**
     * @return this resource as file
     */
    File toFile();

    static final String LESS_EXTENSION = ".less";
    static final String LESSCSS_EXTENSION = ".less.css";
    static final String LESSCSSMIN_EXTENSION = ".less.min.css";
}
