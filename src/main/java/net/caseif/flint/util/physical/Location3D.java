/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2016, Max Roncace <me@caseif.net>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.caseif.flint.util.physical;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

/**
 * Represents a three-dimensional point in space, or optionally, in a world.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public class Location3D {

    private static final char SEPARATOR = ';';

    private final String world;
    private final double x;
    private final double y;
    private final double z;

    /**
     * Constructs a new {@link Location3D} in the given world from the given
     * coordinates.
     *
     * @param world The name of the world which contains this {@link Location3D}
     * @param x The x-coordinate of the new {@link Location3D}
     * @param y The y-coordinate of the new {@link Location3D}
     * @param z The z-coordinate of the new {@link Location3D}
     * @since 1.0
     */
    public Location3D(String world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a new {@link Location3D} from the given coordinates.
     *
     * @param x The x-coordinate of the new {@link Location3D}
     * @param y The y-coordinate of the new {@link Location3D}
     * @param z The z-coordinate of the new {@link Location3D}
     * @since 1.0
     */
    public Location3D(double x, double y, double z) {
        this.world = null;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets the world containing this {@link Location3D}.
     *
     * @return The world containing this {@link Location3D}, or
     *     {@link Optional#absent()} if one is not defined
     * @since 1.0
     */
    public Optional<String> getWorld() {
        return Optional.fromNullable(this.world);
    }

    /**
     * Gets the x-coordinate of this {@link Location3D}.
     *
     * @return The x-coordinate of this {@link Location3D}
     * @since 1.0
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets the y-coordinate of this {@link Location3D}.
     *
     * @return The y-coordinate of this {@link Location3D}
     * @since 1.0
     */
    public double getY() {
        return this.y;
    }

    /**
     * Gets the z-coordinate of this {@link Location3D}.
     *
     * @return The z-coordinate of this {@link Location3D}
     * @since 1.0
     */
    public double getZ() {
        return this.z;
    }

    /**
     * Serializes this {@link Location3D} to a string.
     *
     * @return The string representation of this {@link Location3D}
     * @since 1.0
     */
    public String serialize() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");

        if (getWorld().isPresent()) {
            sb.append("\"").append(getWorld().get()).append("\"").append(SEPARATOR);
        }

        sb.append(toCommaDecimal(getX())).append(SEPARATOR);
        sb.append(toCommaDecimal(getY())).append(SEPARATOR);
        sb.append(toCommaDecimal(getZ()));

        sb.append(")");

        return sb.toString();
    }

    /**
     * Deserializes the given string into a new {@link Location3D} object.
     *
     * @param serial The string to deserialize
     * @return The deserialized {@link Location3D} object
     * @throws IllegalArgumentException If the provided string is not a valid
     *     serial for this class
     * @since 1.0
     */
    public static Location3D deserialize(String serial) throws IllegalArgumentException {
        if (serial.startsWith("(") && serial.endsWith(")")) {
            serial = serial.substring(1, serial.length() - 1);
            String[] parts = serial.split(Character.toString(SEPARATOR));
            try {
                switch (parts.length) {
                    case 3:
                        return new Location3D(
                                fromCommaDecimal(parts[0]),
                                fromCommaDecimal(parts[1]),
                                fromCommaDecimal(parts[2])
                        );
                    case 4:
                        if (parts[0].startsWith("\"") && parts[0].endsWith("\"")) {
                            return new Location3D(
                                    parts[0].substring(1, parts[0].length() - 1),
                                    fromCommaDecimal(parts[1]),
                                    fromCommaDecimal(parts[2]),
                                    fromCommaDecimal(parts[3])
                            );
                        }
                        break;
                    default:
                }
            } catch (NullPointerException | NumberFormatException ex) {
                throw new IllegalArgumentException("Invalid serial", ex);
            }
        }
        throw new IllegalArgumentException("Invalid serial");
    }

    /**
     * Replaces the dot in a double with a comma to form a European-style
     * decimal. The reasoning behind this is to ensure better compatibility with
     * storage formats like YAML, where a dot signifies a nested key.
     *
     * @param d The double to convert
     * @return The European-style decimal as a string
     * @since 1.0
     */
    private static String toCommaDecimal(double d) {
        return Double.toString(d).replace(".", ",");
    }

    /**
     * Parses a comma-notation double from a string.
     *
     * <p>(See {@link Location3D#toCommaDecimal(double)})</p>
     *
     * @param d The comma-notation decimal as a string
     * @return The parsed double
     * @throws NumberFormatException If the double cannot be parsed
     */
    private static double fromCommaDecimal(String d) throws NumberFormatException {
        return Double.parseDouble(d.replace(",", "."));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Location3D) {
            Location3D l = ((Location3D) obj);
            return (l.getWorld().isPresent() ? l.getWorld().get().equals(world) : world == null)
                    && l.getX() == getX() && l.getY() == getY() && l.getZ() == getZ();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(world, x, y, z);
    }

}
