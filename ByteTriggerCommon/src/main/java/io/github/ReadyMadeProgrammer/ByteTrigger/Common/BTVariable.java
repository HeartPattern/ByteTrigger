package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

/**
 * Variable Holder used for Type-Hidden.
 */
public interface BTVariable {
    /**
     * Get a value as string.
     * @return Value that converted to string.
     */
    String getString();
//TODO: Edit JavaDocs
    /**
     * Get a value as int.
     * @return return value if variable hold int.
     * return converted string if string represent number, or throw {@link:ByteTriggerCastingException} if string is not a number.
     * return 1 if variable is true, return 0 if variable is false.
     */
    int getInteger();

    /**
     * Get a value as boolean.
     * @return return value if variable hold boolean.
     * return false if variable is 0 and in other case return 1.
     * return converted string if string represent boolean, or return false if string is not a boolean.
     */
    boolean getBoolean();

    void set(String value);

    void set(int value);

    void set(boolean value);

    void setNull();

    /**
     * @return Original Type of variable.
     */
    Type getType();

    boolean isNull();

    int hashCode();

    boolean equals(Object o);

    String toString();

    enum Type {
        STRING, INT, BOOLEAN, NULL
    }
}
