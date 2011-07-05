package it.dtsoft.tennismatchtracker.dataaccess.dao;


import java.io.Serializable;
import java.sql.Timestamp;

 /**
  * Point Value Object.
  * This class is value object representing database table tmt_point
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Point implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int pointId;
    private int matchId;
    private int playerId;
    private String pointType;
    private Timestamp timestamp;
    private String pointLiteral;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Point () {

    }

    public Point (int pointIdIn) {

          this.pointId = pointIdIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getPointId() {
          return this.pointId;
    }
    public void setPointId(int pointIdIn) {
          this.pointId = pointIdIn;
    }

    public int getMatchId() {
          return this.matchId;
    }
    public void setMatchId(int matchIdIn) {
          this.matchId = matchIdIn;
    }

    public int getPlayerId() {
          return this.playerId;
    }
    public void setPlayerId(int playerIdIn) {
          this.playerId = playerIdIn;
    }

    public String getPointType() {
          return this.pointType;
    }
    public void setPointType(String pointTypeIn) {
          this.pointType = pointTypeIn;
    }

    public Timestamp getTimestamp() {
          return this.timestamp;
    }
    public void setTimestamp(Timestamp timestampIn) {
          this.timestamp = timestampIn;
    }

    public String getPointLiteral() {
          return this.pointLiteral;
    }
    public void setPointLiteral(String pointLiteralIn) {
          this.pointLiteral = pointLiteralIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int pointIdIn,
          int matchIdIn,
          int playerIdIn,
          String pointTypeIn,
          Timestamp timestampIn,
          String pointLiteralIn) {
          this.pointId = pointIdIn;
          this.matchId = matchIdIn;
          this.playerId = playerIdIn;
          this.pointType = pointTypeIn;
          this.timestamp = timestampIn;
          this.pointLiteral = pointLiteralIn;
    }


    /** 
     * hasEqualMapping-method will compare two Point instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Point valueObject) {

          if (valueObject.getPointId() != this.pointId) {
                    return(false);
          }
          if (valueObject.getMatchId() != this.matchId) {
                    return(false);
          }
          if (valueObject.getPlayerId() != this.playerId) {
                    return(false);
          }
          if (this.pointType == null) {
                    if (valueObject.getPointType() != null)
                           return(false);
          } else if (!this.pointType.equals(valueObject.getPointType())) {
                    return(false);
          }
          if (this.timestamp == null) {
                    if (valueObject.getTimestamp() != null)
                           return(false);
          } else if (!this.timestamp.equals(valueObject.getTimestamp())) {
                    return(false);
          }
          if (this.pointLiteral == null) {
                    if (valueObject.getPointLiteral() != null)
                           return(false);
          } else if (!this.pointLiteral.equals(valueObject.getPointLiteral())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Point, mapping to table tmt_point\n");
        out.append("Persistent attributes: \n"); 
        out.append("pointId = " + this.pointId + "\n"); 
        out.append("matchId = " + this.matchId + "\n"); 
        out.append("playerId = " + this.playerId + "\n"); 
        out.append("pointType = " + this.pointType + "\n"); 
        out.append("timestamp = " + this.timestamp + "\n"); 
        out.append("pointLiteral = " + this.pointLiteral + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Point cloned = new Point();

        cloned.setPointId(this.pointId); 
        cloned.setMatchId(this.matchId); 
        cloned.setPlayerId(this.playerId); 
        if (this.pointType != null)
             cloned.setPointType(new String(this.pointType)); 
        if (this.timestamp != null)
             cloned.setTimestamp((Timestamp)this.timestamp.clone()); 
        if (this.pointLiteral != null)
             cloned.setPointLiteral(new String(this.pointLiteral)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}