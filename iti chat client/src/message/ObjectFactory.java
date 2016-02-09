
package message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the messagesave package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Massage_QNAME = new QName("", "massage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: messagesave
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MassageType }
     * 
     */
    public MassageType createMassageType() {
        return new MassageType();
    }

    /**
     * Create an instance of {@link Msgc }
     * 
     */
    public Msgc createMsgc() {
        return new Msgc();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MassageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "massage")
    public JAXBElement<MassageType> createMassage(MassageType value) {
        return new JAXBElement<MassageType>(_Massage_QNAME, MassageType.class, null, value);
    }

}
