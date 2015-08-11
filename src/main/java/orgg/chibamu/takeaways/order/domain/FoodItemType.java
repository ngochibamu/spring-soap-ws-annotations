//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.11 at 08:27:13 AM SAST 
//


package orgg.chibamu.takeaways.order.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FoodItemType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FoodItemType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Snacks"/>
 *     &lt;enumeration value="Beverages"/>
 *     &lt;enumeration value="Starters"/>
 *     &lt;enumeration value="Meals"/>
 *     &lt;enumeration value="Coffee"/>
 *     &lt;enumeration value="Juices"/>
 *     &lt;enumeration value="Desserts"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FoodItemType")
@XmlEnum
public enum FoodItemType {

    @XmlEnumValue("Snacks")
    SNACKS("Snacks"),
    @XmlEnumValue("Beverages")
    BEVERAGES("Beverages"),
    @XmlEnumValue("Starters")
    STARTERS("Starters"),
    @XmlEnumValue("Meals")
    MEALS("Meals"),
    @XmlEnumValue("Coffee")
    COFFEE("Coffee"),
    @XmlEnumValue("Juices")
    JUICES("Juices"),
    @XmlEnumValue("Desserts")
    DESSERTS("Desserts");
    private final String value;

    FoodItemType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FoodItemType fromValue(String v) {
        for (FoodItemType c: FoodItemType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
