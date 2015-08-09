/*
 * New BSD License (BSD-new)
 *
 * Copyright (c) 2015 Maxim Roncacé
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the name of the copyright holder nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.caseif.flint.util.physical;

import com.google.common.base.Optional;

/**
 * Represents a three-dimensional point in space, or optionally, in a world.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public class Location3D {

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
            sb.append("\"").append(getWorld().get()).append("\",");
        }
        sb.append(getX()).append(",").append(getY()).append(",").append(getZ()).append(")");
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
            String[] parts = serial.split(",");
            try {
                switch (parts.length) {
                    case 3:
                        return new Location3D(
                                Double.parseDouble(parts[0]),
                                Double.parseDouble(parts[1]),
                                Double.parseDouble(parts[2])
                        );
                    case 4:
                        if (parts[0].startsWith("\"") && parts[0].endsWith("\"")) {
                            return new Location3D(
                                    parts[0].substring(1, parts[0].length() - 1),
                                    Double.parseDouble(parts[1]),
                                    Double.parseDouble(parts[2]),
                                    Double.parseDouble(parts[3])
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

}
