/*
 * Class Gamer, representing a game player information including email and point.
 * 
 * 
 */
package exercise1;

import java.io.Serializable;

/**
 *
 *  @author Khanh Hoa
 */
public class Gamer implements Serializable {

    private static final long serialVersionUID = 1L;
    String email;//email of gamer
    long point;//point of gamer

    public Gamer() {
    }

    /**
     * Constructs a game entry with given parameters.
     */
    public Gamer(String email, long point) {
        this.email = email;
        this.point = point;
    }

    /**
     * Returns the email field.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email field.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the point field.
     */
    public long getPoint() {
        return point;
    }

    /**
     * Set the point field.
     */
    public void setPoint(long point) {
        this.point = point;
    }

}
